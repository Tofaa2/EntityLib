package me.tofaa.entitylib;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketListenerCommon;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.UserDisconnectEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import com.github.retrooper.packetevents.util.PEVersion;
import me.tofaa.entitylib.event.EntityLibEvent;
import me.tofaa.entitylib.event.EventNode;
import me.tofaa.entitylib.event.entity.EntityInteractEvent;
import me.tofaa.entitylib.utils.ELVersions;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class EntityLib {

    private static volatile EntityLib instance;
    private final APIConfig config;
    private final Map<Integer, WeakReference<WrapperEntity>> entities = new ConcurrentHashMap<>();
    private final PacketListenerCommon listener;
    private final EventNode<EntityLibEvent> eventNode = EventNode.all("entitylib");

    private EntityLib(@NotNull APIConfig config) {
        this.config = config;
        this.listener = config.getPacketEvents().getEventManager().registerListener(new PacketListenerAbstract() {
            @Override
            public void onPacketReceive(PacketReceiveEvent event) {
                if (event.getPacketType() != PacketType.Play.Client.INTERACT_ENTITY
                        || entities.isEmpty() || !eventNode.hasListener(EntityInteractEvent.class)) {
                    return;
                }
                WrapperPlayClientInteractEntity packet = new WrapperPlayClientInteractEntity(event);
                WrapperEntity entity = getEntity(packet.getEntityId());
                if (entity == null) {
                    return;
                }
                EntityInteractEvent interact = eventNode.call(
                    new EntityInteractEvent(entity, event.getUser(), packet.getAction(), packet.getHand()));
                if (interact.isCancelled()) {
                    event.setCancelled(true);
                }
            }

            @Override
            public void onUserDisconnect(UserDisconnectEvent event) {
                UUID uuid = event.getUser().getUUID();
                if (uuid != null) {
                    handleDisconnect(uuid);
                }
            }
        });
    }

    public static void init(@NotNull APIConfig config) {
        shutdown();
        instance = new EntityLib(config);
        config.getPlatform().setup(config);
    }

    public static @NotNull EntityLib get() {
        EntityLib current = instance;
        if (current == null) {
            throw new IllegalStateException("EntityLib not initialized");
        }
        return current;
    }

    public @NotNull APIConfig getConfig() {
        return config;
    }

    public @NotNull EventNode<EntityLibEvent> getEventNode() {
        return eventNode;
    }

    public @NotNull EntityLibPlatform getPlatform() {
        return config.getPlatform();
    }

    public static @NotNull PEVersion getVersion() {
        return ELVersions.CURRENT;
    }

    public @Nullable WrapperEntity getEntity(int entityId) {
        WeakReference<WrapperEntity> reference = entities.get(entityId);
        if (reference == null) {
            return null;
        }
        WrapperEntity entity = reference.get();
        if (entity == null) {
            entities.remove(entityId, reference);
        }
        return entity;
    }

    public @NotNull Collection<WrapperEntity> getEntities() {
        List<WrapperEntity> result = new ArrayList<>(entities.size());
        entities.values().removeIf(reference -> {
            WrapperEntity entity = reference.get();
            if (entity == null) {
                return true;
            }
            result.add(entity);
            return false;
        });
        return result;
    }

    public void registerEntity(@NotNull WrapperEntity entity) {
        WeakReference<WrapperEntity> existing = entities.get(entity.getEntityId());
        if (existing == null || existing.get() != entity) {
            entities.put(entity.getEntityId(), new WeakReference<>(entity));
        }
    }

    public void unregisterEntity(@NotNull WrapperEntity entity) {
        WeakReference<WrapperEntity> existing = entities.get(entity.getEntityId());
        if (existing != null && existing.get() == entity) {
            entities.remove(entity.getEntityId(), existing);
        }
    }

    public static void shutdown() {
        EntityLib current = instance;
        if (current == null) {
            return;
        }
        for (WrapperEntity entity : current.getEntities()) {
            entity.remove();
        }
        current.entities.clear();
        current.config.getPacketEvents().getEventManager().unregisterListener(current.listener);
        instance = null;
    }

    public void handleDisconnect(@NotNull UUID user) {
        for (WrapperEntity entity : getEntities()) {
            entity.handleViewerDisconnect(user);
        }
    }

}
