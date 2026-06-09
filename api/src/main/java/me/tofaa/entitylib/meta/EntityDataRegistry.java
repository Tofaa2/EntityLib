package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.types.EntityDataKeys;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Global metadata registry optimized for speed and memory efficiency.
 * Maps keys explicitly via their declared entity class hierarchy.
 */
public class EntityDataRegistry {

    private static final Map<Class<? extends EntityDataKeys>, List<EntityDataKey<?>>> TYPE_KEYS = new ConcurrentHashMap<>();
    private static final Map<Class<? extends EntityDataKeys>, Map<ClientVersion, EntityDataKey<?>[]>> FAST_LOOKUP_CACHE = new ConcurrentHashMap<>();

    /**
     * Automatically called by EntityDataKey.Builder#build().
     */
    public static void register(@NotNull EntityDataKey<?> key) {
        TYPE_KEYS.computeIfAbsent(key.getDataKeysClass(), k -> new CopyOnWriteArrayList<>()).add(key);
    }

    /**
     * Resolves a raw protocol metadata index back into its tracking EntityDataKey instance.
     */
    public static @Nullable EntityDataKey<?> get(@NotNull Class<? extends EntityDataKeys> clazz, @NotNull ClientVersion version, int index) {
        Map<ClientVersion, EntityDataKey<?>[]> versionMap = FAST_LOOKUP_CACHE.computeIfAbsent(clazz, k -> new ConcurrentHashMap<>());
        EntityDataKey<?>[] fastLookup = versionMap.computeIfAbsent(version, v -> buildFastLookup(clazz, v));

        if (index >= 0 && index < fastLookup.length) {
            return fastLookup[index];
        }

        return null;
    }

    private static EntityDataKey<?>[] buildFastLookup(Class<?> clazz, ClientVersion version) {
        List<EntityDataKey<?>> inheritedKeys = new ArrayList<>();
        Class<?> current = clazz;

        // Traverse class hierarchy to inherit keys from parent wrappers
        while (current != null && current != Object.class) {
            List<EntityDataKey<?>> keys = TYPE_KEYS.get(current);
            if (keys != null) {
                inheritedKeys.addAll(keys);
            }
            current = current.getSuperclass();
        }

        if (inheritedKeys.isEmpty()) {
            return new EntityDataKey<?>[0];
        }

        int maxIndex = -1;
        for (EntityDataKey<?> key : inheritedKeys) {
            int idx = key.getIndex(version);
            if (idx > maxIndex) {
                maxIndex = idx;
            }
        }

        if (maxIndex == -1) return new EntityDataKey<?>[0];

        EntityDataKey<?>[] array = new EntityDataKey<?>[maxIndex + 1];
        for (EntityDataKey<?> key : inheritedKeys) {
            int idx = key.getIndex(version);
            if (idx >= 0 && array[idx] == null) {
                array[idx] = key;
            }
        }
        return array;
    }
}