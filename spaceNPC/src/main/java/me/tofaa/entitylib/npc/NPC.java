package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.protocol.world.Location;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityHeadLook;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.other.ArmorStandMeta;
import me.tofaa.entitylib.meta.types.PlayerMeta;
import me.tofaa.entitylib.npc.path.NPCPath;
import me.tofaa.entitylib.npc.skin.NPCSkin;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import me.tofaa.entitylib.wrapper.hologram.Hologram;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NPC {

    private static final String TEAM_NAME = "spacenpcs";
    private final String id;
    private final EntityType entityType;
    private final Map<UUID, PerPlayerData> perPlayerData;
    private final NPCOptions options;
    private final NPCPath path;
    private WrapperEntity entity;
    private WrapperEntity sittingEntity;
    private Hologram hologram;
    private String name;
    private NPCSkin skin;
    private boolean spawned;
    private boolean hologramPassenger;
    private Location spawnLocation;
    private String worldName;
    private String teamEntry;

    public NPC(String id, EntityType entityType) {
        this.id = id;
        this.entityType = entityType;
        this.perPlayerData = new ConcurrentHashMap<>();
        this.options = new NPCOptions();
        this.path = new NPCPath();
        this.name = "";
    }

    public @NotNull String getId() {
        return id;
    }

    public @NotNull EntityType getEntityType() {
        return entityType;
    }

    public void setName(@NotNull String name) {
        this.name = name;
        if (hologram != null) {
            updateHologram();
        }
    }

    public @NotNull String getName() {
        return name;
    }

    public void setSkin(@Nullable NPCSkin skin) {
        this.skin = skin;
        getEntity().ifPresent(e -> {
            e.consumeEntityMeta(PlayerMeta.class, meta -> {
                meta.setLeftSleeveEnabled(true);
                meta.setRightSleeveEnabled(true);
                meta.setCapeEnabled(true);
            });
        });
    }

    public @Nullable NPCSkin getSkin() {
        return skin;
    }

    public void setPosition(@NotNull Location location) {
        if (spawned) {
            entity.teleport(location);
        }
        this.spawnLocation = location;
    }

    public @NotNull World getWorld() {
        return Objects.requireNonNull(worldName != null ? Bukkit.getWorld(worldName) : null);
    }

    public void setWorld(@NotNull World world) {
        this.worldName = world.getName();
    }

    public @NotNull String getWorldName() {
        return worldName;
    }

    public void setWorldName(@NotNull String name) {
        this.worldName = name;
    }

    public @NotNull Location getPosition() {
        if (spawned && entity != null) {
            return entity.getLocation();
        }
        return spawnLocation;
    }

    public void setHologramVisible(boolean visible) {
        if (hologram != null) {
            if (visible) {
                hologram.show();
            } else {
                hologram.hide();
            }
        }
    }

    public void spawn(@NotNull Location location) {
        if (spawned) return;

        this.spawnLocation = location;

        if (
            entityType ==
            EntityTypes.PLAYER
        ) {
            UserProfile profile = new UserProfile(
                java.util.UUID.randomUUID(),
                name
            );
            if (skin != null) {
                profile.setTextureProperties(skin.getTextureProperties());
            }
            WrapperPlayer wrapperPlayer = new WrapperPlayer(
                profile,
                EntityLib.getPlatform()
                    .getEntityIdProvider()
                    .provide(profile.getUUID(), entityType)
            );
            wrapperPlayer.setInTablist(true);
            wrapperPlayer.setGameMode(
                GameMode.SURVIVAL
            );
            entity = wrapperPlayer;
            Bukkit.getLogger().info(
                "[NPC] Created WrapperPlayer with UUID: " +
                    profile.getUUID() +
                    ", name: " +
                    name
            );
        } else {
            if (EntityMeta.isLivingEntity(entityType)) {
                entity = new WrapperLivingEntity(entityType);
            }
            else {
                entity = new WrapperEntity(entityType);
            }
            Bukkit.getLogger().info(
                "[NPC] Created WrapperEntity with type: " + entityType
            );
        }
        entity.setLocation(location);

        if (entityType == com.github.retrooper.packetevents.protocol.entity.type.EntityTypes.PLAYER) {
            entity.getEntityMeta().setCustomNameVisible(false);
            registerScoreboardTeam();
        } else if (options.hasDisplayName()) {
            entity.getEntityMeta().setCustomName(options.getDisplayName());
            entity.getEntityMeta().setCustomNameVisible(true);
        }

        entity.spawn(location);

        if (options.isSwimming()) {
            entity.getEntityMeta().setSwimming(true);
        }
        if (options.isCrouching()) {
            entity.getEntityMeta().setSneaking(true);
        }

        World npcWorld = getWorld();

        if (options.isSitting()) {
            Location sittingLoc = new Location(
                location.getX(),
                location.getY(),
                location.getZ(),
                location.getYaw(),
                location.getPitch()
            );
            sittingEntity = new WrapperEntity(EntityTypes.ARMOR_STAND);
            sittingEntity.setLocation(sittingLoc);
            sittingEntity.spawn(sittingLoc);

            ArmorStandMeta meta = (ArmorStandMeta) sittingEntity.getEntityMeta();
            meta.setSmall(true);
            meta.setInvisible(true);

            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getWorld() != npcWorld) continue;
                sittingEntity.addViewer(player.getUniqueId());
            }
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld() != npcWorld) continue;
            entity.addViewer(player.getUniqueId());
        }

        if (options.isSitting()) {
            sittingEntity.addPassenger(entity);
        }

        NPCRegistry.registerEntityId(this);

        if (options.isShowNameTag()) {
            createHologramWithViewers();
        }

        spawned = true;
    }

    private void registerScoreboardTeam() {
        if (entity == null) return;
        
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(TEAM_NAME);
        if (team == null) {
            team = scoreboard.registerNewTeam(TEAM_NAME);
            team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
            team.setOption(Team.Option.DEATH_MESSAGE_VISIBILITY, Team.OptionStatus.NEVER);
        }
        
        if (!team.hasEntry(name)) {
            team.addEntry(name);
        }
        teamEntry = name;
    }

    private void createHologramWithViewers() {
        createHologram();
        if (hologram != null) {
            World npcWorld = getWorld();
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getWorld() != npcWorld) continue;
                hologram.addViewer(player.getUniqueId());
            }
        }
    }

    public void despawn() {
        if (!spawned) return;

        if (teamEntry != null) {
            removeScoreboardTeamEntry();
        }

        if (hologram != null) {
            hologram.hide();
            hologram = null;
        }

        if (sittingEntity != null) {
            sittingEntity.remove();
            sittingEntity = null;
        }

        entity.remove();
        entity = null;
        spawned = false;
    }

    private void removeScoreboardTeamEntry() {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team team = scoreboard.getTeam(TEAM_NAME);
            if (team != null && teamEntry != null) {
                team.removeEntry(teamEntry);
            }
    }

    public void remove() {
        despawn();
        NPCRegistry.unregister(this);
    }

    private void createHologram() {
        Location loc = getPosition();
        double yOffset = options.isSitting() ? 2.76 : 2.26;
        Location hologramLoc = new Location(
            loc.getX(),
            loc.getY() + yOffset,
            loc.getZ(),
            loc.getYaw(),
            loc.getPitch()
        );

        int protocolVersion = EntityLib.getApi()
            .getPacketEvents()
            .getServerManager()
            .getVersion()
            .getProtocolVersion();

        Hologram hologram;
        if (protocolVersion >= 760) {
            hologram = Hologram.modern(hologramLoc);
        } else {
            hologram = Hologram.legacy(hologramLoc);
        }

        hologram.addLine(
            options.getDisplayName() != null
                ? options.getDisplayName()
                : Component.text(name)
        );
        hologram.show();
//        if (hologram.getEntity().getEntityMeta() instanceof AbstractDisplayMeta displayMeta) {
////            displayMeta.setTranslation(new Vector3f(0, 0.5f, 0));
//        }

        this.hologram = hologram;
    }

    private void updateHologram() {
        if (hologram != null) {
            hologram.setLine(
                0,
                options.getDisplayName() != null
                    ? options.getDisplayName()
                    : Component.text(name)
            );
        }
    }

    public void updateHeadRotationForViewers(Location npcLocation) {
        if (entity == null || !spawned) return;

        PacketEventsAPI<?> api = me.tofaa.entitylib.EntityLib.getApi().getPacketEvents();

        for (UUID viewerId : entity.getViewers()) {
            org.bukkit.entity.Player player = org.bukkit.Bukkit.getPlayer(
                viewerId
            );
            if (player == null) continue;

            double dx = player.getLocation().getX() - npcLocation.getX();
            double dz = player.getLocation().getZ() - npcLocation.getZ();
            float yaw = (float) Math.toDegrees(Math.atan2(dz, dx));

            WrapperPlayServerEntityHeadLook headPacket =
                new WrapperPlayServerEntityHeadLook(
                    entity.getEntityId(),
                    yaw
                );

            Object channel = api.getProtocolManager().getChannel(viewerId);
            if (channel != null) {
                api.getProtocolManager().sendPacket(channel, headPacket);
            }
        }
    }

    public @NotNull Collection<UUID> getViewers() {
        if (entity == null) return Collections.emptyList();
        return entity.getViewers();
    }

    public void addViewer(@NotNull UUID playerId) {
        if (entity != null) {
            entity.addViewer(playerId);
        }
    }

    public void removeViewer(@NotNull UUID playerId) {
        if (entity != null) {
            entity.removeViewer(playerId);
        }
    }

    public @NotNull Optional<WrapperEntity> getEntity() {
        return Optional.ofNullable(entity);
    }

    public @NotNull Optional<Hologram> getHologram() {
        return Optional.ofNullable(hologram);
    }

    public @NotNull NPCOptions getOptions() {
        return options;
    }

    public @NotNull NPCPath getPath() {
        return path;
    }

    public boolean isHologramPassenger() {
        return hologramPassenger;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public @NotNull Map<UUID, PerPlayerData> getPerPlayerData() {
        return perPlayerData;
    }

    public @Nullable PerPlayerData getPerPlayerData(UUID playerId) {
        return perPlayerData.get(playerId);
    }

    public void setPerPlayerData(UUID playerId, PerPlayerData data) {
        perPlayerData.put(playerId, data);
    }

    public void removePerPlayerData(UUID playerId) {
        perPlayerData.remove(playerId);
    }

    public void moveTo(@NotNull Location target) {
        NPCPath path = getPath();
        path.clearWaypoints();
        path.addWaypoint(target);
        NPCMovement.startPathFollowing(this);
    }

    public void stopMoving() {
        if (entity != null) {
            NPCMovement.stop(this);
            getPath().reset();
        }
    }

    public boolean isMoving() {
        return NPCMovement.isMoving(this);
    }

    public static class PerPlayerData {

        private final UUID playerId;
        private Component customName;
        private boolean hidden;

        public PerPlayerData(UUID playerId) {
            this.playerId = playerId;
        }

        public @NotNull UUID getPlayerId() {
            return playerId;
        }

        public void setCustomName(@Nullable Component name) {
            this.customName = name;
        }

        public @Nullable Component getCustomName() {
            return customName;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }

        public boolean isHidden() {
            return hidden;
        }
    }


}

