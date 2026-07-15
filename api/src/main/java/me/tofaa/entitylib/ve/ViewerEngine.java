package me.tofaa.entitylib.ve;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ApiStatus.Experimental
public class ViewerEngine {

    private final List<ViewerRule> globalRules = new CopyOnWriteArrayList<>();
    private final Map<Integer, WrapperEntity> tracked = new ConcurrentHashMap<>();
    private final PacketListener listener = new PacketListener();
    private Executor executor;
    private boolean enabled = false;

    public ViewerEngine() {
        this(Executors.newSingleThreadExecutor());
    }

    public ViewerEngine(@NotNull Executor executor) {
        this.executor = executor;
    }

    public void enable() {
        if (enabled) return;
        enabled = true;
    }

    public void disable() {
        if (!enabled) return;
        enabled = false;
    }

    public void refresh() {
        for (WrapperEntity entity : tracked.values()) {
            for (UUID viewer : entity.getViewers()) {
                if (!canSpawnFor(viewer, entity)) {
                    entity.removeViewer(viewer);
                }
            }
        }
    }

    public @NotNull Executor getExecutor() {
        return executor;
    }

    public void setExecutor(@NotNull Executor executor) {
        this.executor = executor;
    }

    public void track(@NotNull WrapperEntity entity) {
        tracked.put(entity.getEntityId(), entity);
    }

    public void untrack(@NotNull WrapperEntity entity) {
        tracked.remove(entity.getEntityId());
    }

    public void clearTracked() {
        tracked.clear();
    }

    public boolean canSpawnFor(@NotNull User user, @NotNull WrapperEntity entity) {
        return entity.getViewerRules().stream().allMatch(r -> r.shouldSee(user))
            && globalRules.stream().allMatch(r -> r.shouldSee(user));
    }

    public boolean canSpawnFor(@NotNull UUID userId, @NotNull WrapperEntity entity) {
        return entity.getViewerRules().stream().allMatch(r -> true)
            && globalRules.stream().allMatch(r -> true);
    }

    public @UnmodifiableView Collection<WrapperEntity> getTracked() {
        return Collections.unmodifiableCollection(tracked.values());
    }

    Map<Integer, WrapperEntity> getTracked0() {
        return tracked;
    }

    public void addViewerRule(@NotNull ViewerRule rule) {
        globalRules.add(rule);
    }

    public void removeViewerRule(@NotNull ViewerRule rule) {
        globalRules.remove(rule);
    }

    public void removeViewerRule(int index) {
        globalRules.remove(index);
    }

    public void clearViewerRules() {
        globalRules.clear();
    }

    public @UnmodifiableView Collection<ViewerRule> getViewerRules() {
        return Collections.unmodifiableCollection(globalRules);
    }

    public @Nullable ViewerRule getViewerRule(int index) {
        if (index < 0 || index >= globalRules.size()) return null;
        return globalRules.get(index);
    }

    private final class PacketListener extends PacketListenerAbstract {

        @Override
        public void onPacketSend(PacketSendEvent event) {
            PacketTypeCommon type = event.getPacketType();
            if (type == PacketType.Play.Server.UNLOAD_CHUNK) {
                exec(event, e -> {
                    var packet = new WrapperPlayServerUnloadChunk(e);
                    int cx = packet.getChunkX();
                    int cz = packet.getChunkZ();
                    for (WrapperEntity entity : tracked.values()) {
                        if (inChunk(entity.getLocation(), cx, cz)) {
                            entity.removeViewer(e.getUser().getUUID());
                        }
                    }
                });
            } else if (type == PacketType.Play.Server.CHUNK_DATA) {
                exec(event, e -> {
                    var packet = new WrapperPlayServerChunkData(e);
                    int cx = packet.getColumn().getX();
                    int cz = packet.getColumn().getZ();
                    for (WrapperEntity entity : tracked.values()) {
                        if (!inChunk(entity.getLocation(), cx, cz)) continue;
                        if (entity.hasViewer(e.getUser().getUUID())) continue;
                        entity.addViewer(e.getUser().getUUID());
                    }
                });
            }
        }

        private void exec(PacketSendEvent event, java.util.function.Consumer<PacketSendEvent> runnable) {
            PacketSendEvent copy = event.clone();
            executor.execute(() -> {
                runnable.accept(copy);
                copy.cleanUp();
            });
        }

        private boolean inChunk(com.github.retrooper.packetevents.protocol.world.Location loc, int chunkX, int chunkZ) {
            return ((int) Math.floor(loc.getX())) >> 4 == chunkX
                && ((int) Math.floor(loc.getZ())) >> 4 == chunkZ;
        }
    }

}
