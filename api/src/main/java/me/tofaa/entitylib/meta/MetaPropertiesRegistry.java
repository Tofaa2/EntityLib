package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.property.IMetaProperties;
import me.tofaa.entitylib.meta.property.MetadataProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Global metadata registry optimized for speed and memory efficiency.
 * Maps properties explicitly via their declared entity class hierarchy.
 */
public class MetaPropertiesRegistry {

    private static final Map<Class<? extends IMetaProperties>, List<MetadataProperty<?, ?>>> TYPE_PROPERTIES = new ConcurrentHashMap<>();
    private static final Map<Class<? extends IMetaProperties>, Map<ClientVersion, MetadataProperty<?, ?>[]>> FAST_LOOKUP_CACHE = new ConcurrentHashMap<>();

    /**
     * Automatically called by {@link MetadataProperty.Builder#build()}
     */
    public static void register(@NotNull MetadataProperty<?, ?> property) {
        TYPE_PROPERTIES.computeIfAbsent(property.getMetaPropertiesClass(), k -> new CopyOnWriteArrayList<>()).add(property);
    }

    /**
     * Resolves a raw protocol metadata index back into its tracking {@link MetadataProperty} instance.
     */
    public static @Nullable MetadataProperty<?, ?> get(@NotNull Class<? extends IMetaProperties> clazz, @NotNull ClientVersion version, int index) {
        Map<ClientVersion, MetadataProperty<?, ?>[] > versionMap = FAST_LOOKUP_CACHE.computeIfAbsent(clazz, k -> new ConcurrentHashMap<>());
        MetadataProperty<?, ?>[] indexArray = versionMap.computeIfAbsent(version, v -> buildIndexArray(clazz, v));

        if (index >= 0 && index < indexArray.length) {
            return indexArray[index];
        }

        return null;
    }

    private static List<MetadataProperty<?, ?>> collectInheritedProperties(Class<?> clazz) {
        List<MetadataProperty<?, ?>> inheritedProperties = new ArrayList<>();
        Class<?> current = clazz;

        // Traverse class hierarchy to inherit keys from parent wrappers
        while (current != null && current != Object.class) {
            List<MetadataProperty<?, ?>> properties = TYPE_PROPERTIES.get(current);
            if (properties != null) {
                inheritedProperties.addAll(properties);
            }
            current = current.getSuperclass();
        }
        return inheritedProperties;
    }

    private static MetadataProperty<?, ?>[] buildIndexArray(Class<?> clazz, ClientVersion version) {
        List<MetadataProperty<?, ?>> inheritedProperties = collectInheritedProperties(clazz);

        if (inheritedProperties.isEmpty()) {
            return new MetadataProperty<?, ?>[0];
        }

        int maxIndex = -1;
        for (MetadataProperty<?, ?> property : inheritedProperties) {
            int idx = property.getIndex(version);
            if (idx > maxIndex) {
                maxIndex = idx;
            }
        }

        if (maxIndex == -1) return new MetadataProperty<?, ?>[0];

        MetadataProperty<?, ?>[] array = new MetadataProperty<?, ?>[maxIndex + 1];
        for (MetadataProperty<?, ?> property : inheritedProperties) {
            int idx = property.getIndex(version);
            if (idx >= 0 && array[idx] == null) {
                array[idx] = property;
            }
        }
        return array;
    }
}