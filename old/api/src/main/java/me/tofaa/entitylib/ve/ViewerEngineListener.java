package me.tofaa.entitylib.ve;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperEntity;

import java.util.function.Consumer;

final class ViewerEngineListener extends PacketListenerAbstract {

    private final ViewerEngine engine;

    ViewerEngineListener(ViewerEngine engine) {
        this.engine = engine;
    }

    @Override
    public void onPacketSend(PacketSendEvent e) {
        PacketTypeCommon type = e.getPacketType();
        if (type == PacketType.Play.Server.SPAWN_PLAYER) {
            exec(e, (event) -> {
                WrapperPlayServerSpawnPlayer packet = new WrapperPlayServerSpawnPlayer(event);
                genericSpawnCheck(packet.getEntityId(), event.getUser());
            });
        }
        else if (type == PacketType.Play.Server.SPAWN_WEATHER_ENTITY) {
            exec(e, (event) -> {
                WrapperPlayServerSpawnWeatherEntity packet = new WrapperPlayServerSpawnWeatherEntity(event);
                genericSpawnCheck(packet.getEntityId(), event.getUser());
            });
        }
        else if (type == PacketType.Play.Server.SPAWN_EXPERIENCE_ORB) {
            exec(e, (event) -> {
                WrapperPlayServerSpawnExperienceOrb packet = new WrapperPlayServerSpawnExperienceOrb(event);
                genericSpawnCheck(packet.getEntityId(), event.getUser());
            });
        }
        else if (type == PacketType.Play.Server.SPAWN_LIVING_ENTITY) {
            exec(e, (event) -> {
                WrapperPlayServerSpawnLivingEntity packet = new WrapperPlayServerSpawnLivingEntity(event);
                genericSpawnCheck(packet.getEntityId(), event.getUser());
            });
        }
        else if (type == PacketType.Play.Server.SPAWN_ENTITY) {
            exec(e, (event) -> {
                WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(event);
                genericSpawnCheck(packet.getEntityId(), event.getUser());
            });
        }
        else if (type == PacketType.Play.Server.UNLOAD_CHUNK) {
            exec(e, (event) -> {
                WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk(event);
                int chunkX = packet.getChunkX();
                int chunkZ = packet.getChunkZ();
                engine.getTracked0().forEach(entity -> {
                    if (!Check.inChunk(entity.getLocation(), chunkX, chunkZ)) return;
                    entity.removeViewer(e.getUser());
                });
            });
        }
        else if (type == PacketType.Play.Server.CHUNK_DATA) {
            exec(e, (event) -> {
                WrapperPlayServerChunkData packet = new WrapperPlayServerChunkData(event);
                int chunkX = packet.getColumn().getX();
                int chunkZ = packet.getColumn().getZ();
                engine.getTracked0().forEach(entity -> {
                    if (!Check.inChunk(entity.getLocation(), chunkX, chunkZ)) return;
                    if (entity.hasViewer(event.getUser())) return;
                    if (engine.canSpawnFor(event.getUser(), entity)) {
                        entity.addViewer(event.getUser());
                    }
                });
            });
        }
    }

    private void genericSpawnCheck(int entityId, User user) {
        WrapperEntity entity = EntityLib.getApi().getEntity(entityId);
        if (entity == null) return;
        if (engine.canSpawnFor(user, entity)) {
            entity.addViewer(user);
        }
    }

    private <T extends PacketWrapper<T>> void exec(
            PacketSendEvent event,
            Consumer<PacketSendEvent> runnable
    ) {
        PacketSendEvent copy = event.clone();
        engine.getExecutor().execute(() -> {
            runnable.accept(copy);
            copy.cleanUp();
        });
    }

}
