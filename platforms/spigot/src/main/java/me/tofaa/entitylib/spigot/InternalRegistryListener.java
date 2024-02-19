package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnExperienceOrb;
import me.tofaa.entitylib.TrackedEntity;
import me.tofaa.entitylib.event.types.tracking.UserStopTrackingEntityEvent;
import me.tofaa.entitylib.event.types.tracking.UserTrackingEntityEvent;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

final class InternalRegistryListener extends PacketListenerAbstract implements Listener  {

    private SpigotEntityLibPlatform platform;

    InternalRegistryListener(SpigotEntityLibPlatform platform) {
        this.platform = platform;
    }


    @Override
    public void onPacketSend(PacketSendEvent event) {
        final User user = event.getUser();
        final PacketTypeCommon type = event.getPacketType();
        if (type == PacketType.Play.Server.DESTROY_ENTITIES) {
            WrapperPlayServerDestroyEntities packet = new WrapperPlayServerDestroyEntities(event);
            int[] ids = packet.getEntityIds();
            for (int id : ids) {
                TrackedEntity tracked = findTracker(id);
                if (tracked == null) {
                    continue;
                }
                platform.getEventBus().call(new UserStopTrackingEntityEvent(user, tracked));
            }
        }
        else if (type == PacketType.Play.Server.SPAWN_ENTITY) {
            WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
            int id = packet.getEntityId();
            trackEntity(user, id);
        }
        else if (type == PacketType.Play.Server.SPAWN_EXPERIENCE_ORB) {
            WrapperPlayServerSpawnExperienceOrb packet = new WrapperPlayServerSpawnExperienceOrb(event);
            int id = packet.getEntityId();
            trackEntity(user, id);
        }
        else if (type == PacketType.Play.Server.SPAWN_LIVING_ENTITY) {
            WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
            int id = packet.getEntityId();
            trackEntity(user, id);
        }
        else if (type == PacketType.Play.Server.SPAWN_PLAYER) {
            WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
            int id = packet.getEntityId();
            trackEntity(user, id);
        }
        else if (type == PacketType.Play.Server.SPAWN_WEATHER_ENTITY) {
            WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
            int id = packet.getEntityId();
            trackEntity(user, id);
        }
        else if (type == PacketType.Play.Server.SPAWN_PAINTING) {
            WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
            int id = packet.getEntityId();
            trackEntity(user, id);
        }
    }

    private void trackEntity(User user, int id) {
        TrackedEntity entity = findTracker(id);
        if (entity == null) {
            return;
        }
        platform.getEventBus().call(new UserTrackingEntityEvent(user, entity));
    }

    private TrackedEntity findTracker(int id) {
        TrackedEntity entity = platform.findPlatformEntity(id);
        if (entity == null) {
            entity = platform.getAPI().getEntity(id);
        }
        if (entity == null) {
            if (platform.getAPI().getSettings().isDebugMode()) {
                platform.getLogger().warning("Failed to find entity with id " + id);
            }
        }
        return entity;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity e = event.getEntity();
        platform.getPlatformEntities().put(e.getEntityId(), e);
    }


}
