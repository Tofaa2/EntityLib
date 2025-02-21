package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.EntityIdProvider;
import me.tofaa.entitylib.Platform;
import org.bukkit.Bukkit;
import org.bukkit.UnsafeValues;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

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
            return Bukkit.getUnsafe()::nextEntityId; // Paper API
        }

        final Class<?> entityClass = getEntityClass();
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_14)) {
            final Field entityAtomicField = getField(entityClass, "entityCount", "d", "c"); // Obfuscated names
            if (entityAtomicField == null) {
                throw new IllegalStateException("Could not find entity counter field");
            }
            try {
                entityAtomicField.setAccessible(true);
                final AtomicInteger counter = (AtomicInteger) entityAtomicField.get(null);
                return counter::incrementAndGet;
            } catch (final Exception exception) {
                throw new IllegalStateException("Failed to access entity counter", exception);
            }
        }

        final Field entityLegacyField = getField(entityClass, "entityCount");
        if (entityLegacyField == null) {
            throw new IllegalStateException("Could not find legacy entity counter field");
        }
        try {
            entityLegacyField.setAccessible(true);
            return () -> {
                try {
                    final int entityId = entityLegacyField.getInt(null);
                    entityLegacyField.setInt(null, entityId + 1);
                    return entityId;
                } catch (final Exception exception) {
                    throw new IllegalStateException("Failed to modify entity counter", exception);
                }
            };
        } catch (final Exception exception) {
            throw new IllegalStateException("Failed to access legacy entity counter", exception);
        }
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

        final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        final String packagePath = isFlattened ? "net.minecraft.world.entity" : "net.minecraft.server." + version;

        try {
            return Class.forName(packagePath + ".Entity");
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
