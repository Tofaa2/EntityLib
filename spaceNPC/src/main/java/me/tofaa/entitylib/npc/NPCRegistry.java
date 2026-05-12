package me.tofaa.entitylib.npc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NPCRegistry {

    private static final Map<String, NPC> npcs = new ConcurrentHashMap<>();
    private static final Map<UUID, NPC> npcsByUuid = new ConcurrentHashMap<>();
    private static final Map<Integer, NPC> npcsByEntityId = new ConcurrentHashMap<>();

    private NPCRegistry() {
    }

    public static void register(@NotNull NPC npc) {
        npcs.put(npc.getId(), npc);
        npc.getEntity().ifPresent(e -> {
            npcsByUuid.put(e.getUuid(), npc);
            npcsByEntityId.put(e.getEntityId(), npc);
        });
    }

    public static void unregister(@NotNull NPC npc) {
        npcs.remove(npc.getId());
        npc.getEntity().ifPresent(e -> {
            npcsByUuid.remove(e.getUuid());
            npcsByEntityId.remove(e.getEntityId());
        });
    }

    public static void unregister(@NotNull String id) {
        NPC npc = npcs.remove(id);
        if (npc != null) {
            npc.getEntity().ifPresent(e -> {
                npcsByUuid.remove(e.getUuid());
                npcsByEntityId.remove(e.getEntityId());
            });
        }
    }

    public static @Nullable NPC get(@NotNull String id) {
        return npcs.get(id);
    }

    public static @Nullable NPC getByUuid(@NotNull UUID uuid) {
        return npcsByUuid.get(uuid);
    }

    public static @Nullable NPC getByEntityId(int entityId) {
        return npcsByEntityId.get(entityId);
    }

    public static void registerEntityId(@NotNull NPC npc) {
        npc.getEntity().ifPresent(e -> npcsByEntityId.put(e.getEntityId(), npc));
    }

    public static void unregisterEntityId(int entityId) {
        npcsByEntityId.remove(entityId);
    }

    public static @NotNull Collection<NPC> getAll() {
        return Collections.unmodifiableCollection(npcs.values());
    }

    public static int count() {
        return npcs.size();
    }

    public static void clear() {
        for (NPC npc : npcs.values()) {
            npc.despawn();
        }
        npcs.clear();
        npcsByUuid.clear();
        npcsByEntityId.clear();
    }
}
