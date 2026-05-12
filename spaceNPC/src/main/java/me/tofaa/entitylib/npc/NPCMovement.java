package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.world.Location;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityHeadLook;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.movement.MovementEngine;
import me.tofaa.entitylib.movement.SpigotMovementEngine;
import me.tofaa.entitylib.npc.path.NPCPath;
import me.tofaa.entitylib.npc.NPCRegistry;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
                hologram.setParent(npc.getEntity().get());
            });

            boolean permanentlyVisible = npc.getOptions().isPermanentlyVisible();
            double viewDistance = npc.getOptions().getViewDistance();
            boolean isSitting = npc.getSittingEntity().isPresent();

            for (org.bukkit.entity.Player player : org.bukkit.Bukkit.getOnlinePlayers()) {
                if (player.getWorld() != npcWorld) continue;

                UUID playerId = player.getUniqueId();
                boolean isViewer = entity.getViewers().contains(playerId);
                boolean shouldSee = permanentlyVisible || isPlayerInRange(player, npcLocation, viewDistance);

                if (shouldSee && !isViewer) {
                    if (isSitting) {
                        npc.getSittingEntity().ifPresent(sitting -> sitting.addViewer(playerId));
                    }
                    entity.addViewer(playerId);
                    npc.getHologram().ifPresent(h -> h.addViewer(playerId));
                    if (entity instanceof me.tofaa.entitylib.wrapper.WrapperPlayer) {
                        npc.doStupidDogshitForOldClients(player);
                    }
                } else if (!shouldSee && isViewer) {
                    entity.removeViewer(playerId);
                    if (isSitting) {
                        npc.getSittingEntity().ifPresent(sitting -> sitting.removeViewer(playerId));
                    }
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
                // Gets handled by the movement itself
                continue;
            } else {
                continue;
            }

            entity.rotateHead(yaw, 0);
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

                    // Use horizontal (XZ) distance for waypoint arrival check
                    double hDistSq =
                        Math.pow(target.getX() - current.getX(), 2) +
                        Math.pow(target.getZ() - current.getZ(), 2);

                    if (hDistSq < 0.25 && Math.abs(target.getY() - current.getY()) < 1.5) {
                        path.advanceToNext();
                        return;
                    }

                    double speed = npc.getOptions().getMovementSpeed() * 0.1;

                    // --- Horizontal movement (XZ only) ---
                    double dx = target.getX() - current.getX();
                    double dz = target.getZ() - current.getZ();
                    double hLen = Math.sqrt(dx * dx + dz * dz);

                    double newX, newZ;
                    if (hLen > 0.01) {
                        dx /= hLen;
                        dz /= hLen;
                        newX = current.getX() + dx * speed;
                        newZ = current.getZ() + dz * speed;
                    } else {
                        newX = current.getX();
                        newZ = current.getZ();
                        dx = 0;
                        dz = 0;
                    }

                    // --- Vertical movement (jump + gravity physics) ---
                    double newY = current.getY();

                    if (npc.getOptions().isClampToGround()) {
                        World world = npc.getWorld();
                        if (world != null) {
                            int bx = (int) Math.floor(newX);
                            int bz = (int) Math.floor(newZ);
                            int feetY = (int) Math.floor(current.getY());

                            // Check if there's a solid block ahead at feet level (obstacle)
                            Block blockAtFeet = world.getBlockAt(bx, feetY, bz);
                            Block blockAboveFeet = world.getBlockAt(bx, feetY + 1, bz);

                            boolean obstacleAhead = !blockAtFeet.isPassable()
                                && blockAboveFeet.isPassable();

                            // If we hit a 1-block obstacle, and we're on the ground, jump
                            if (obstacleAhead && follower.isOnGround()) {
                                follower.jump();
                            }

                            // Apply vertical physics (gravity + velocity)
                            newY = follower.applyVerticalPhysics(current.getY());

                            // Resolve ground collision: find solid ground below new position
                            int newFeetY = (int) Math.floor(newY);
                            double groundLevel = findGroundLevel(world, bx, newFeetY, bz, feetY + 2);

                            if (newY <= groundLevel) {
                                // Landed on ground
                                newY = groundLevel;
                                follower.land(groundLevel);
                            } else {
                                // Still airborne
                                follower.setOnGround(false);
                            }

                            // If jumping into a ceiling (block above head), stop upward velocity
                            int headY = (int) Math.floor(newY + 1.8);
                            var blockAtHead = world.getBlockAt(bx, headY, bz);
                            if (!blockAtHead.isPassable() && follower.verticalVelocity > 0) {
                                follower.verticalVelocity = 0;
                            }

                            // If obstacle is 2+ blocks tall, don't move horizontally into it
                            if (!blockAtFeet.isPassable() && !blockAboveFeet.isPassable()) {
                                newX = current.getX();
                                newZ = current.getZ();
                            }
                        }
                    } else {
                        // No ground clamping: use linear Y interpolation (original behavior)
                        double dy = target.getY() - current.getY();
                        double fullLen = Math.sqrt(dx * dx + dy * dy + dz * dz);
                        if (fullLen > 0.01) {
                            newY = current.getY() + (dy / fullLen) * speed;
                        }
                    }

                    float yaw = npc.getOptions().isLookAtPath() ? npc.getPath().getYaw() : current.getYaw();
                    Location newLoc = new Location(
                        newX,
                        newY,
                        newZ,
                        yaw,
                        0
                    );

                    entity.teleport(newLoc);
                    entity.rotateHead(yaw, 0);
                });
        }
    }

    /**
     * Finds the Y level of the ground (top of highest solid block) at the given XZ,
     * searching downward from startY. Returns the Y on top of the first solid block found.
     * If no solid block is found down to y=minY or world min, returns startY (no change).
     */
    private static double findGroundLevel(org.bukkit.World world, int bx, int startY, int bz, int maxY) {
        // Don't search too far down - limit to 4 blocks below current position
        int minSearch = Math.max(world.getMinHeight(), startY - 4);
        for (int y = startY; y >= minSearch; y--) {
            var block = world.getBlockAt(bx, y, bz);
            if (!block.isPassable()) {
                // Ground found: NPC stands on top of this block
                return y + 1;
            }
        }
        // No ground found within search range, keep falling
        return startY;
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

        private static final double GRAVITY = 0.08;
        private static final double JUMP_VELOCITY = 0.42;

        private final NPC npc;
        private final long startTime;
        private double verticalVelocity = 0.0;
        private boolean onGround = true;

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

        public void jump() {
            if (onGround) {
                verticalVelocity = JUMP_VELOCITY;
                onGround = false;
            }
        }

        public double applyVerticalPhysics(double currentY) {
            if (onGround && verticalVelocity <= 0) {
                verticalVelocity = 0;
                return currentY;
            }
            verticalVelocity -= GRAVITY;
            double newY = currentY + verticalVelocity;
            return newY;
        }

        public void land(double groundY) {
            onGround = true;
            verticalVelocity = 0.0;
        }

        public boolean isOnGround() {
            return onGround;
        }

        public void setOnGround(boolean onGround) {
            this.onGround = onGround;
        }
    }
}
