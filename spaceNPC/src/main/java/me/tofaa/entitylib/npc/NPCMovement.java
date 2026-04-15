package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3f;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityHeadLook;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.display.AbstractDisplayMeta;
import me.tofaa.entitylib.movement.MovementEngine;
import me.tofaa.entitylib.movement.MovementEngine.MovementSettings;
import me.tofaa.entitylib.movement.MovementEngine.Path;
import me.tofaa.entitylib.movement.MovementEngine.PathfindSettings;
import me.tofaa.entitylib.movement.SpigotMovementEngine;
import me.tofaa.entitylib.npc.path.NPCPath;
import me.tofaa.entitylib.npc.NPCRegistry;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NPCMovement {

    private static SpigotMovementEngine engine;
    private static BukkitTask tickTask;
    private static BukkitTask rotationTask;
    private static BukkitTask viewerSyncTask;
    private static final Map<Integer, PathFollowing> activeFollowers =
        new ConcurrentHashMap<>();

    public static void init(org.bukkit.plugin.java.JavaPlugin plugin) {
        if (engine == null) {
            engine = new SpigotMovementEngine();
        }

        if (tickTask == null) {
            tickTask =
                org.bukkit.Bukkit.getScheduler().runTaskTimerAsynchronously(
                    plugin,
                    () -> {
                        engine.tick();
                        processPathFollowing();
                    },
                    1L,
                    1L
                );
        }

        if (rotationTask == null) {
            rotationTask =
                org.bukkit.Bukkit.getScheduler().runTaskTimerAsynchronously(
                    plugin,
                    () -> processAllNPCHeadRotation(),
                    1L,
                    2L
                );
        }

        if (viewerSyncTask == null) {
            viewerSyncTask =
                org.bukkit.Bukkit.getScheduler().runTaskTimerAsynchronously(
                    plugin,
                    () -> processViewerSync(),
                    1L,
                    10L
                );
        }
    }

    public static void shutdown() {
        if (tickTask != null) {
            tickTask.cancel();
            tickTask = null;
        }
        if (rotationTask != null) {
            rotationTask.cancel();
            rotationTask = null;
        }
        if (viewerSyncTask != null) {
            viewerSyncTask.cancel();
            viewerSyncTask = null;
        }
        activeFollowers.clear();
    }

    private static void processViewerSync() {
        for (NPC npc : NPCRegistry.getAll()) {
            if (!npc.isSpawned() || !npc.getEntity().isPresent()) continue;

            WrapperEntity entity = npc.getEntity().get();
            World npcWorld = npc.getWorld();
            if (npcWorld == null) continue;

            Location npcLocation = entity.getLocation();

            npc.getHologram().ifPresent(hologram -> {
                double yOffset = npc.getOptions().isSitting() ? 2.76 : 2.26;
                Location holoLoc = new Location(
                    npcLocation.getX(),
                    npcLocation.getY() + yOffset,
                    npcLocation.getZ(),
                    npcLocation.getYaw(),
                    npcLocation.getPitch()
                );
                hologram.teleport(holoLoc);
            });

            boolean permanentlyVisible = npc.getOptions().isPermanentlyVisible();
            double viewDistance = npc.getOptions().getViewDistance();

            for (org.bukkit.entity.Player player : org.bukkit.Bukkit.getOnlinePlayers()) {
                if (player.getWorld() != npcWorld) continue;

                UUID playerId = player.getUniqueId();
                boolean isViewer = entity.getViewers().contains(playerId);
                boolean shouldSee = permanentlyVisible || isPlayerInRange(player, npcLocation, viewDistance);

                if (shouldSee && !isViewer) {
                    entity.addViewer(playerId);
                    npc.getHologram().ifPresent(h -> h.addViewer(playerId));
                } else if (!shouldSee && isViewer) {
                    entity.removeViewer(playerId);
                    npc.getHologram().ifPresent(h -> h.removeViewer(playerId));
                }
            }
        }
    }

    private static boolean isPlayerInRange(Player player, Location npcLocation, double range) {
        org.bukkit.Location playerLoc = player.getLocation();
        double dx = playerLoc.getX() - npcLocation.getX();
        double dy = playerLoc.getY() - npcLocation.getY();
        double dz = playerLoc.getZ() - npcLocation.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz) <= range;
    }

    private static void processAllNPCHeadRotation() {
        for (NPC npc : NPCRegistry.getAll()) {
            if (!npc.isSpawned() || !npc.getEntity().isPresent()) continue;

            WrapperEntity entity = npc.getEntity().get();
            Location npcLocation = entity.getLocation();
            org.bukkit.World world = npc.getWorld();
            if (world == null) continue;

            float yaw;
            if (npc.getOptions().isLookAtPlayersPerPlayer()) {
                updatePerPlayerHeadRotation(npc, entity, npcLocation.getYaw());
                continue;
            } else if (npc.getOptions().isLookAtPlayers()) {
                Player nearest = findNearestPlayer(npcLocation, world);
                if (nearest != null) {
                    yaw = (float) (Math.toDegrees(
                        Math.atan2(
                            nearest.getLocation().getZ() - npcLocation.getZ(),
                            nearest.getLocation().getX() - npcLocation.getX()
                        )
                    ) - 90);
                } else {
                    yaw = npcLocation.getYaw();
                }
            } else if (npc.getOptions().isLookAtPath()) {
                yaw = npcLocation.getYaw();
            } else {
                continue;
            }

            PacketEventsAPI<?> api = EntityLib.getApi().getPacketEvents();
            for (UUID viewerId : entity.getViewers()) {
                Player player = org.bukkit.Bukkit.getPlayer(viewerId);
                if (player == null || player.getWorld() != world) continue;

                WrapperPlayServerEntityHeadLook headPacket = new WrapperPlayServerEntityHeadLook(
                    entity.getEntityId(),
                    yaw
                );

                Object channel = api.getProtocolManager().getChannel(viewerId);
                if (channel != null) {
                    api.getProtocolManager().sendPacket(channel, headPacket);
                }
            }
        }
    }

    private static void processPathFollowing() {
        for (PathFollowing follower : activeFollowers.values()) {
            NPC npc = follower.npc;
            NPCPath path = npc.getPath();

            if (path.isPaused() || path.isFinished()) {
                continue;
            }

            Location target = path.getCurrentWaypoint();
            if (target == null) {
                continue;
            }

            npc
                .getEntity()
                .ifPresent(entity -> {
                    Location current = entity.getLocation();
                    double distance = Math.sqrt(
                        Math.pow(target.getX() - current.getX(), 2) +
                            Math.pow(target.getY() - current.getY(), 2) +
                            Math.pow(target.getZ() - current.getZ(), 2)
                    );

                    if (distance < 0.5) {
                        path.advanceToNext();
                    } else {
                        double speed =
                            npc.getOptions().getMovementSpeed() * 0.1;
                        double dx = target.getX() - current.getX();
                        double dy = target.getY() - current.getY();
                        double dz = target.getZ() - current.getZ();
                        double len = Math.sqrt(dx * dx + dy * dy + dz * dz);

                        dx /= len;
                        dy /= len;
                        dz /= len;

                        // float yaw = (float) Math.toDegrees(Math.atan2(dz, dx));
                        float yaw = getYawTowards(
                            target,
                            new org.bukkit.Location(
                                null,
                                target.getX(),
                                target.getY(),
                                target.getZ(),
                                target.getYaw(),
                                target.getPitch()
                            )
                        );

                        double newY = current.getY() + dy * speed;
                        double newX = current.getX() + dx * speed;
                        double newZ = current.getZ() + dz * speed;

                        if (npc.getOptions().isClampToGround()) {
                            World world = npc.getWorld();
                            if (world != null) {
                                int cx = (int) Math.floor(newX);
                                int cz = (int) Math.floor(newZ);
                                int cy = (int) Math.floor(current.getY());

                                Block feet = world.getBlockAt(
                                    cx,
                                    cy,
                                    cz
                                );
                                Block below = world.getBlockAt(
                                    cx,
                                    cy - 1,
                                    cz
                                );

                                if (
                                    below.getType() == Material.AIR
                                ) {
                                    newY = newY - 1;
                                }

                                if (
                                    target.getY() > current.getY() + 0.1 &&
                                    feet.getType() != org.bukkit.Material.AIR
                                ) {
                                    newY = current.getY() + 0.5;
                                }
                            }
                        }

                        Location newLoc = new Location(
                            newX,
                            newY,
                            newZ,
                            yaw,
                            0
                        );

                        entity.teleport(newLoc);

                        entity.rotateHead(yaw, 0);
                    }
                });
        }
    }

    private static void updateGlobalHeadRotation(
        NPC npc,
        WrapperEntity entity,
        float pathYaw
    ) {
        World world = npc.getWorld();
        if (world == null) return;

        Location npcLocation = entity.getLocation();
        Player nearest = findNearestPlayer(npcLocation, world);
        float yaw = nearest != null
            ? (float) (Math.toDegrees(
                Math.atan2(
                    nearest.getLocation().getZ() - npcLocation.getZ(),
                    nearest.getLocation().getX() - npcLocation.getX()
                )
            ) - 90)
            : pathYaw;

        PacketEventsAPI<?> api = EntityLib.getApi().getPacketEvents();
        for (UUID viewerId : entity.getViewers()) {
            Player player = org.bukkit.Bukkit.getPlayer(viewerId);
            if (player == null || player.getWorld() != world) continue;

            WrapperPlayServerEntityHeadLook headPacket = new WrapperPlayServerEntityHeadLook(
                entity.getEntityId(),
                yaw
            );

            Object channel = api.getProtocolManager().getChannel(viewerId);
            if (channel != null) {
                api.getProtocolManager().sendPacket(channel, headPacket);
            }
        }
    }

    private static void updatePerPlayerHeadRotation(
        NPC npc,
        me.tofaa.entitylib.wrapper.WrapperEntity entity,
        float pathYaw
    ) {
        World world = npc.getWorld();

        Location npcLocation = entity.getLocation();
        PacketEventsAPI<?> api = EntityLib.getApi().getPacketEvents();

        for (UUID viewerId : entity.getViewers()) {
            Player player = org.bukkit.Bukkit.getPlayer(viewerId);
            if (player == null || player.getWorld() != world) continue;

            Player nearest = findNearestPlayer(player, npcLocation, world);
            float yaw;
            if (nearest != null) {
                org.bukkit.Location playerLoc = nearest.getLocation();
                yaw = (float) (Math.toDegrees(
                    Math.atan2(
                        playerLoc.getZ() - npcLocation.getZ(),
                        playerLoc.getX() - npcLocation.getX()
                    )
                ) - 90);
            } else {
                yaw = pathYaw;
            }

            WrapperPlayServerEntityHeadLook headPacket = new WrapperPlayServerEntityHeadLook(
                entity.getEntityId(),
                yaw
            );

            Object channel = api.getProtocolManager().getChannel(viewerId);
            if (channel != null) {
                api.getProtocolManager().sendPacket(channel, headPacket);
            }
        }
    }

    private static Player findNearestPlayer(Location npcLocation, World world) {
        if (world == null) return null;
        Player nearest = null;
        double minDist = Double.MAX_VALUE;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld() != world) continue;
            double dist = player.getLocation().distance(
                new org.bukkit.Location(
                    world,
                    npcLocation.getX(),
                    npcLocation.getY(),
                    npcLocation.getZ()
                )
            );
            if (dist < minDist) {
                minDist = dist;
                nearest = player;
            }
        }
        return nearest;
    }

    private static Player findNearestPlayer(Player exclude, Location npcLocation, World world) {
        if (world == null) return null;
        Player nearest = null;
        double minDist = Double.MAX_VALUE;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.equals(exclude)) continue;
            if (player.getWorld() != world) continue;
            double dist = player.getLocation().distance(
                new org.bukkit.Location(
                    world,
                    npcLocation.getX(),
                    npcLocation.getY(),
                    npcLocation.getZ()
                )
            );
            if (dist < minDist) {
                minDist = dist;
                nearest = player;
            }
        }
        return nearest;
    }

    private static float getYawTowards(
        Location loc,
        org.bukkit.Location bukkitLoc
    ) {
        double dx = bukkitLoc.getX() - loc.getX();
        double dz = bukkitLoc.getZ() - loc.getZ();
        return (float) (Math.toDegrees(Math.atan2(dz, dx)) - 90);
    }

    private static double getGroundY(
        org.bukkit.World world,
        double x,
        double y,
        double z
    ) {
        int cx = (int) Math.floor(x);
        int cz = (int) Math.floor(z);
        for (int cy = (int) Math.floor(y); cy >= 0; cy--) {
            org.bukkit.block.Block block = world.getBlockAt(cx, cy, cz);
            if (block.getType() != org.bukkit.Material.AIR) {
                return cy + 1;
            }
        }
        return y;
    }

    public static void startPathFollowing(NPC npc) {
        NPCPath path = npc.getPath();
        if (path.getWaypointCount() == 0) {
            return;
        }

        path.setStarted(true);
        activeFollowers.put(npc.hashCode(), new PathFollowing(npc));
    }

    public static void stop(NPC npc) {
        activeFollowers.remove(npc.hashCode());
        npc.getPath().setStarted(false);
        npc.getEntity().ifPresent(engine::stopMovement);
    }

    public static boolean isMoving(NPC npc) {
        return activeFollowers.containsKey(npc.hashCode());
    }

    public static @NotNull MovementEngine getEngine() {
        return engine;
    }

    public static class PathFollowing {

        private final NPC npc;
        private final long startTime;

        public PathFollowing(NPC npc) {
            this.npc = npc;
            this.startTime = System.currentTimeMillis();
        }

        public @NotNull NPC getNpc() {
            return npc;
        }

        public long getStartTime() {
            return startTime;
        }
    }
}
