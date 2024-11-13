package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import me.tofaa.entitylib.utils.ConcurrentWeakIdentityHashMap;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.UUID;

final class MultiMeta {

    private final WeakReference<EntityMeta> parent;
    private final Map<UUID, List<EntityData>> replacements;

    MultiMeta(EntityMeta parent) {
        this.parent = new WeakReference<>(parent);
        this.replacements = new ConcurrentWeakIdentityHashMap<>();
    }

}
