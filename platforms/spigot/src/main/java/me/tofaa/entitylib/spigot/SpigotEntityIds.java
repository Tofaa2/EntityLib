package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import org.bukkit.Bukkit;
import org.bukkit.UnsafeValues;
import org.bukkit.World;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

final class SpigotEntityIds {

    private SpigotEntityIds() {
    }

    static Supplier<Integer> detect(ServerVersion serverVersion) {
        if (isPaper() && serverVersion.isNewerThanOrEquals(ServerVersion.V_1_16)) {
            if (serverVersion.isOlderThan(ServerVersion.V_26_2)) {
                return Bukkit.getUnsafe()::nextEntityId;
            }
            try {
                Method method = UnsafeValues.class.getMethod("nextEntityId", World.class);
                UnsafeValues unsafe = Bukkit.getUnsafe();
                return () -> {
                    try {
                        return (Integer) method.invoke(unsafe, Bukkit.getWorlds().get(0));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                };
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        Class<?> entityClass = getEntityClass(serverVersion);
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_14)) {
            Supplier<Integer> modernSupplier = resolveAtomicSupplier(entityClass);
            if (modernSupplier != null) {
                return modernSupplier;
            }
        }
        return resolveLegacySupplier(entityClass);
    }

    private static Supplier<Integer> resolveAtomicSupplier(Class<?> entityClass) {
        Field field = getStaticFieldOfType(entityClass, AtomicInteger.class,
                "entityCount", "d", "c", "counter", "nextEntityId");
        if (field == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            Object value = field.get(null);
            if (!(value instanceof AtomicInteger)) {
                return null;
            }
            AtomicInteger counter = (AtomicInteger) value;
            return counter::incrementAndGet;
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException("Failed to access entity counter", exception);
        }
    }

    private static Supplier<Integer> resolveLegacySupplier(Class<?> entityClass) {
        Field field = getStaticFieldOfType(entityClass, Integer.TYPE, "entityCount", "b");
        if (field == null) {
            throw new IllegalStateException("Could not find legacy entity counter field");
        }
        field.setAccessible(true);
        return () -> {
            try {
                int entityId = field.getInt(null);
                field.setInt(null, entityId + 1);
                return entityId;
            } catch (IllegalAccessException exception) {
                throw new IllegalStateException("Failed to modify entity counter", exception);
            }
        };
    }

    private static Class<?> getEntityClass(ServerVersion serverVersion) {
        boolean isFlattened = serverVersion.isNewerThanOrEquals(ServerVersion.V_1_17);
        try {
            if (isFlattened) {
                return Class.forName("net.minecraft.world.entity.Entity");
            }
            String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            return Class.forName("net.minecraft.server." + version + ".Entity");
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("Could not find Entity class", exception);
        }
    }

    private static Field getField(Class<?> clazz, String... possibleNames) {
        for (String name : possibleNames) {
            try {
                return clazz.getDeclaredField(name);
            } catch (NoSuchFieldException ignored) {
            }
        }
        return null;
    }

    private static Field getStaticFieldOfType(Class<?> clazz, Class<?> desiredType, String... possibleNames) {
        for (String name : possibleNames) {
            Field field = getField(clazz, name);
            if (field != null && desiredType.isAssignableFrom(field.getType())
                    && Modifier.isStatic(field.getModifiers())) {
                return field;
            }
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && desiredType.isAssignableFrom(field.getType())) {
                return field;
            }
        }
        return null;
    }

    private static boolean isPaper() {
        return Stream.of(
                "com.destroystokyo.paper.PaperConfig",
                "io.papermc.paper.configuration.Configuration"
        ).anyMatch(SpigotEntityIds::hasClass);
    }

    private static boolean hasClass(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }
}
