package me.tofaa.entitylib.spigot;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.UnsafeValues;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;

import me.tofaa.entitylib.EntityIdProvider;
import me.tofaa.entitylib.Platform;

/**
 * Internal {@link EntityIdProvider} for Spigot servers, handling version and platform differences.
 */
public final class SpigotEntityIdProvider implements EntityIdProvider {

    /** The platform abstraction. */
    private final Platform<JavaPlugin> platform;
    /** The supplier for entity IDs, dynamically chosen by {@link #detectIdSupplier()}. */
    private final Supplier<Integer> entityIdSupplier ;

    /**
     * Constructs a new {@code SpigotEntityIdProvider}.
     *
     * @param platform The platform instance. Must not be null.
     */
    public SpigotEntityIdProvider(final @NotNull Platform<JavaPlugin> platform) {
        this.platform = platform;
        this.entityIdSupplier = detectIdSupplier();
    }

    @Override
    public int provide(@NotNull UUID entityUUID, @NotNull EntityType entityType) {
        // UUID and EntityType are unused in Minecraft id generation.
        return entityIdSupplier.get();
    }

    /**
     * Detects and configures the appropriate {@link Supplier} for entity IDs based on server version
     * and platform.
     * Logic:
     * <ul>
     *   <li>Paper (1.16+): Use `{@link UnsafeValues#nextEntityId()}`. (Paper API)</li>
     *   <li>1.14+: Access `AtomicInteger` field ("entityCount", "d", "c").</li>
     *   <li>1.8+: Access legacy `int` field "entityCount".</li>
     * </ul>
     *
     * @return A {@link Supplier} instance that provides the next entity ID.
     * @throws IllegalStateException if the entity counter field cannot be located or accessed.
     */
    private Supplier<Integer> detectIdSupplier() {


        final ServerVersion serverVersion = platform.getAPI().getPacketEvents().getServerManager().getVersion();

        if (isPaper() && serverVersion.isNewerThanOrEquals(ServerVersion.V_1_16)) {
            // Paper removed UnsafeValues.nextEntityId() in API 26.2+.
            // Verify the method exists via reflection to avoid NoSuchMethodError.
            try {
                UnsafeValues.class.getMethod("nextEntityId");
                return Bukkit.getUnsafe()::nextEntityId; // Paper API (pre-26.x)
            } catch (final NoSuchMethodException ignored) {
                // Method removed — fall through to AtomicInteger reflection path
            }
        }

        final Class<?> entityClass = getEntityClass();
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_14)) {
            final Supplier<Integer> modernSupplier = resolveAtomicSupplier(entityClass);
            if (modernSupplier != null) {
                return modernSupplier;
            }
        }

        return resolveLegacySupplier(entityClass);
    }

    private Supplier<Integer> resolveAtomicSupplier(final Class<?> entityClass) {
        final Field entityAtomicField = getStaticFieldOfType(entityClass, AtomicInteger.class,
                "entityCount", "d", "c", "counter", "nextEntityId", "ENTITY_COUNTER");
        if (entityAtomicField == null) {
            return null;
        }
        try {
            entityAtomicField.setAccessible(true);
            final Object fieldValue = entityAtomicField.get(null);
            if (!(fieldValue instanceof AtomicInteger)) {
                return null; // incompatible type, fall back to legacy strategy
            }
            final AtomicInteger counter = (AtomicInteger) fieldValue;
            return counter::incrementAndGet;
        } catch (final IllegalAccessException exception) {
            throw new IllegalStateException("Failed to access entity counter", exception);
        }
    }

    private Supplier<Integer> resolveLegacySupplier(final Class<?> entityClass) {
        // Search for a non-final static int field (entity counters are never final).
        final Field entityLegacyField = findMutableStaticIntField(entityClass);
        if (entityLegacyField == null) {
            // Last resort: local high-offset counter. Entity ID collision is unlikely
            // since the server allocates from 1 upward.
            final AtomicInteger fallback = new AtomicInteger(Integer.MAX_VALUE - 100000);
            return fallback::incrementAndGet;
        }
        entityLegacyField.setAccessible(true);
        return () -> {
            try {
                final int entityId = entityLegacyField.getInt(null);
                entityLegacyField.setInt(null, entityId + 1);
                return entityId;
            } catch (final IllegalAccessException exception) {
                throw new IllegalStateException("Failed to modify entity counter", exception);
            }
        };
    }

    /**
     * Finds a mutable (non-final) static int field in the given class to use as
     * a legacy entity counter. Tries known field names first, then falls back to
     * any non-final static int field.
     */
    private static Field findMutableStaticIntField(final Class<?> clazz) {
        for (final String name : new String[]{"entityCount", "b", "c"}) {
            final Field field = getField(clazz, name);
            if (field != null
                    && field.getType() == Integer.TYPE
                    && Modifier.isStatic(field.getModifiers())
                    && !Modifier.isFinal(field.getModifiers())) {
                return field;
            }
        }
        // Wildcard fallback: any non-final static int field
        for (final Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())
                    && field.getType() == Integer.TYPE
                    && !Modifier.isFinal(field.getModifiers())) {
                return field;
            }
        }
        return null;
    }

    /**
     * Resolves server's internal `Entity` class, handling version-specific packages.
     * In Minecraft versions 1.17 and later, the `Entity` class resides in `net.minecraft.world.entity.Entity`.
     * Prior to 1.17, it is located in `net.minecraft.server.[version].Entity`.
     *
     * @return Resolved `Entity` class.
     * @throws IllegalStateException if the `Entity` class cannot be found.
     */
    private Class<?> getEntityClass() {
        final ServerVersion serverVersion = platform.getAPI().getPacketEvents().getServerManager().getVersion();
        final boolean isFlattened = serverVersion.isNewerThanOrEquals(ServerVersion.V_1_17);

        if (isFlattened) {
            try {
                return Class.forName("net.minecraft.world.entity.Entity");
            } catch (final ClassNotFoundException exception) {
                throw new IllegalStateException("Could not find Entity class", exception);
            }
        }

        // Pre-1.17: versioned package (e.g. net.minecraft.server.v1_16_R3.Entity)
        final String[] parts = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
        final String ver = parts.length > 3 ? parts[3] : "";
        try {
            return Class.forName("net.minecraft.server." + ver + ".Entity");
        } catch (final ClassNotFoundException exception) {
            throw new IllegalStateException("Could not find Entity class", exception);
        }
    }

    /**
     * Utility method to retrieve a declared field from a class by trying multiple names.
     * @param clazz The class to examine for the field.
     * @param possibleNames An array of potential field names to attempt retrieval with.
     * @return The {@link Field} if a matching field is found, otherwise {@code null}.
     */
    private static Field getField(final Class<?> clazz, final String... possibleNames) {
        for (final String name : possibleNames) {
            try {
                return clazz.getDeclaredField(name);
            } catch (final NoSuchFieldException ignored) {
                // Field name not found, proceed to the next
            }
        }
        return null;
    }

    private static Field getStaticFieldOfType(final Class<?> clazz, final Class<?> desiredType,
                                              final String... possibleNames) {
        for (final String name : possibleNames) {
            final Field field = getField(clazz, name);
            if (field != null && desiredType.isAssignableFrom(field.getType())
                    && Modifier.isStatic(field.getModifiers())) {
                return field;
            }
        }

        for (final Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && desiredType.isAssignableFrom(field.getType())) {
                return field;
            }
        }
        return null;
    }

    /**
     * Determines if the server environment is Paper by checking for Paper-specific classes.
     * @return true if Paper is detected.
     */
    private static boolean isPaper() {
        return Stream.of(
                "com.destroystokyo.paper.PaperConfig",
                "io.papermc.paper.configuration.Configuration"
        ).anyMatch(SpigotEntityIdProvider::hasClass);
    }

    /**
     * Utility to check if a class exists on the classpath.
     * @param className Class name to check.
     * @return true if class exists.
     */
    private static boolean hasClass(final String className) {
        try {
            Class.forName(className);
            return true;
        } catch (final ClassNotFoundException ignored) {
            return false;
        }
    }
}
