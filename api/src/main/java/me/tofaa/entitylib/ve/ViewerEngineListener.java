package me.tofaa.entitylib.ve;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUnloadChunk;
import me.tofaa.entitylib.utils.Check;

import java.util.concurrent.atomic.AtomicBoolean;

final class ViewerEngineListener extends PacketListenerAbstract {

    private final ViewerEngine engine;

    ViewerEngineListener(ViewerEngine engine) {
        this.engine = engine;
    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
        PacketTypeCommon type = event.getPacketType();
        if (type == PacketType.Play.Server.UNLOAD_CHUNK) {
            PacketSendEvent copy = event.clone();
            engine.getExecutor().execute(() -> {
                WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk(event);
                int chunkX = packet.getChunkX();
                int chunkZ = packet.getChunkZ();
                engine.getTracked0().forEach(entity -> {
                    if (!Check.inChunk(entity.getLocation(), chunkX, chunkZ)) return;
                    entity.removeViewer(event.getUser());
                });
                copy.cleanUp();
            });
        }
        if (type == PacketType.Play.Server.CHUNK_DATA) {
            PacketSendEvent copy = event.clone();
            engine.getExecutor().execute(() -> {
                WrapperPlayServerUnloadChunk packet = new WrapperPlayServerUnloadChunk(event);
                int chunkX = packet.getChunkX();
                int chunkZ = packet.getChunkZ();
                engine.getTracked0().forEach(entity -> {
                    if (!Check.inChunk(entity.getLocation(), chunkX, chunkZ)) return;
                    if (entity.hasViewer(event.getUser())) return;
                    AtomicBoolean pass = new AtomicBoolean(false);
                    entity.getViewerRules().forEach(rule -> {
                        pass.set(rule.shouldSee(event.getUser()));
                    });
                    engine.getViewerRules().forEach(rule -> {
                        pass.set(rule.shouldSee(event.getUser()));
                    });
                    if (!pass.get()) return;
                    entity.addViewer(event.getUser());
                });
                copy.cleanUp();
            });
        }
    }

}
