package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoRemove;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoUpdate;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.spawn.SpawnPacketProvider;
import me.tofaa.entitylib.spawn.SpawnPacketProviders;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class WrapperPlayer extends WrapperLivingEntity {

    public static final int MODERN_PLAYER_INFO_PROTOCOL = 761;

    private UserProfile profile;
    private GameMode gameMode = GameMode.CREATIVE;
    private Component displayName;
    private boolean tablist = true;
    private int latency = -1;

    public WrapperPlayer(int entityId, @NotNull UserProfile profile, @NotNull Location location) {
        super(entityId, profile.getUUID(), EntityTypes.PLAYER, location);
        this.profile = profile;
    }

    public WrapperPlayer(@NotNull UserProfile profile, int entityId) {
        this(entityId, profile, new Location(0, 0, 0, 0, 0));
    }

    public WrapperPlayer(@NotNull UserProfile profile) {
        this(profile, EntityLib.get().getPlatform().nextEntityId());
    }

    public @NotNull UserProfile getProfile() {
        return profile;
    }

    public void setProfile(@NotNull UserProfile profile) {
        this.profile = profile;
    }

    public @NotNull String getUsername() {
        return profile.getName();
    }

    public @NotNull List<TextureProperty> getTextureProperties() {
        return profile.getTextureProperties();
    }

    public @NotNull List<TextureProperty> getTextures() {
        return profile.getTextureProperties();
    }

    public void setTextureProperties(@NotNull List<TextureProperty> textures) {
        profile.setTextureProperties(textures);
        if (!isSpawned()) return;
        for (UUID viewer : List.copyOf(getViewers())) {
            sendDespawnPackets(viewer);
            sendSpawnPackets(viewer);
        }
    }

    public @NotNull GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(@NotNull GameMode gameMode) {
        this.gameMode = gameMode;
        broadcastInfo(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_GAME_MODE,
            WrapperPlayServerPlayerInfo.Action.UPDATE_GAME_MODE);
    }

    public @Nullable Component getDisplayName() {
        return displayName;
    }

    public void setDisplayName(@Nullable Component displayName) {
        this.displayName = displayName;
        broadcastInfo(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_DISPLAY_NAME,
            WrapperPlayServerPlayerInfo.Action.UPDATE_DISPLAY_NAME);
    }

    public boolean isInTablist() {
        return tablist;
    }

    public void setInTablist(boolean tablist) {
        this.tablist = tablist;
        if (!isSpawned()) return;
        for (UUID viewer : getViewers()) {
            if (isModern(viewer)) {
                sendPacket(viewer, new WrapperPlayServerPlayerInfoUpdate(
                    WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED, createInfo()));
            } else {
                sendPacket(viewer, new WrapperPlayServerPlayerInfo(
                    tablist ? WrapperPlayServerPlayerInfo.Action.ADD_PLAYER : WrapperPlayServerPlayerInfo.Action.REMOVE_PLAYER,
                    createLegacyInfo()));
            }
        }
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
        broadcastInfo(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LATENCY,
            WrapperPlayServerPlayerInfo.Action.UPDATE_LATENCY);
    }

    public @NotNull PacketWrapper<?> tabListPacket(int protocolVersion) {
        if (protocolVersion >= MODERN_PLAYER_INFO_PROTOCOL) {
            return new WrapperPlayServerPlayerInfoUpdate(
                EnumSet.of(
                    WrapperPlayServerPlayerInfoUpdate.Action.ADD_PLAYER,
                    WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED,
                    WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_GAME_MODE,
                    WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LATENCY,
                    WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_DISPLAY_NAME
                ),
                createInfo()
            );
        }
        return new WrapperPlayServerPlayerInfo(WrapperPlayServerPlayerInfo.Action.ADD_PLAYER, createLegacyInfo());
    }

    public @NotNull PacketWrapper<?> tabListRemovePacket(int protocolVersion) {
        if (protocolVersion >= MODERN_PLAYER_INFO_PROTOCOL) {
            return new WrapperPlayServerPlayerInfoRemove(getUuid());
        }
        return new WrapperPlayServerPlayerInfo(WrapperPlayServerPlayerInfo.Action.REMOVE_PLAYER, createLegacyInfo());
    }

    @Override
    protected void collectSpawnPackets(@NotNull UUID user, int protocolVersion, @NotNull List<PacketWrapper<?>> packets) {
        packets.add(tabListPacket(protocolVersion));
        super.collectSpawnPackets(user, protocolVersion, packets);
        packets.add(new WrapperPlayServerEntityRotation(getEntityId(), getYaw(), getPitch(), isOnGround()));
    }

    @Override
    protected void collectDespawnPackets(@NotNull UUID user, int protocolVersion, @NotNull List<PacketWrapper<?>> packets) {
        packets.add(tabListRemovePacket(protocolVersion));
        super.collectDespawnPackets(user, protocolVersion, packets);
    }

    @Override
    protected @NotNull SpawnPacketProvider getSpawnProvider() {
        return SpawnPacketProviders.PLAYER;
    }

    private boolean isModern(UUID viewer) {
        return EntityLib.get().getPlatform().getProtocolVersion(viewer) >= MODERN_PLAYER_INFO_PROTOCOL;
    }

    private void broadcastInfo(WrapperPlayServerPlayerInfoUpdate.Action modern, WrapperPlayServerPlayerInfo.Action legacy) {
        if (!isSpawned()) return;
        for (UUID viewer : getViewers()) {
            if (isModern(viewer)) {
                sendPacket(viewer, new WrapperPlayServerPlayerInfoUpdate(modern, createInfo()));
            } else {
                sendPacket(viewer, new WrapperPlayServerPlayerInfo(legacy, createLegacyInfo()));
            }
        }
    }

    private WrapperPlayServerPlayerInfoUpdate.PlayerInfo createInfo() {
        return new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(
            profile, tablist, latency, gameMode, displayName, null
        );
    }

    private WrapperPlayServerPlayerInfo.PlayerData createLegacyInfo() {
        return new WrapperPlayServerPlayerInfo.PlayerData(displayName, profile, gameMode, latency);
    }

}
