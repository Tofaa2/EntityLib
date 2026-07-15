package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.spawn.SpawnPacketProvider;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WrapperPlayer extends WrapperLivingEntity {

    public static final int MODERN_SPAWN_PROTOCOL = 761;

    private UserProfile profile;
    private GameMode gameMode = GameMode.CREATIVE;
    private Component displayName;
    private boolean tablist = true;
    private int latency;

    public WrapperPlayer(int entityId, @NotNull UserProfile profile, @NotNull Location location) {
        super(entityId, profile.getUUID(), EntityTypes.PLAYER, location);
        this.profile = profile;
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

    public void setTextureProperties(@NotNull List<TextureProperty> textures) {
        profile.setTextureProperties(textures);
        if (!isSpawned()) return;
        sendPacketToViewers(new WrapperPlayServerPlayerInfoRemove(getUuid()));
        sendPacketToViewers(new WrapperPlayServerDestroyEntities(getEntityId()));
        sendPacketToViewers(tabListPacket());
        for (UUID viewer : List.copyOf(getViewers())) {
            removeViewer(viewer);
            addViewer(viewer);
        }
    }

    public @NotNull GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(@NotNull GameMode gameMode) {
        this.gameMode = gameMode;
        if (isSpawned()) {
            sendPacketToViewers(new WrapperPlayServerPlayerInfoUpdate(
                WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_GAME_MODE, createInfo()
            ));
        }
    }

    public @Nullable Component getDisplayName() {
        return displayName;
    }

    public void setDisplayName(@Nullable Component displayName) {
        this.displayName = displayName;
        if (isSpawned()) {
            sendPacketToViewers(new WrapperPlayServerPlayerInfoUpdate(
                WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_DISPLAY_NAME, createInfo()
            ));
        }
    }

    public boolean isInTablist() {
        return tablist;
    }

    public void setInTablist(boolean tablist) {
        this.tablist = tablist;
        if (isSpawned()) {
            sendPacketToViewers(tabListPacket());
        }
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
        if (isSpawned()) {
            sendPacketToViewers(new WrapperPlayServerPlayerInfoUpdate(
                WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LATENCY, createInfo()
            ));
        }
    }

    @Override
    public void spawn(@NotNull Location location) {
        sendPacketToViewers(tabListPacket());
        super.spawn(location);
    }

    @Override
    protected void sendSpawnPackets(@NotNull UUID user) {
        int proto = EntityLib.get().getConfig().getPlatform().getProtocolVersion(user);
        var packet = getSpawnProvider().provide(this, proto);
        sendPacket(user, packet);
        sendPacket(user, new WrapperPlayServerEntityHeadLook(getEntityId(), getLocation().getYaw()));
        sendMetadata(user);
    }

    @Override
    protected @NotNull SpawnPacketProvider getSpawnProvider() {
        return (entity, proto) -> {
            if (proto < MODERN_SPAWN_PROTOCOL) {
                var loc = entity.getLocation();
                return new WrapperPlayServerSpawnPlayer(
                    entity.getEntityId(),
                    entity.getUuid(),
                    loc,
                    List.of()
                );
            }
            var loc = entity.getLocation();
            return new WrapperPlayServerSpawnEntity(
                entity.getEntityId(),
                Optional.of(entity.getUuid()),
                EntityTypes.PLAYER,
                loc.getPosition(),
                loc.getPitch(),
                loc.getYaw(),
                loc.getYaw(),
                entity.getSpawnData(),
                Optional.of(entity.getVelocity())
            );
        };
    }

    private WrapperPlayServerPlayerInfoUpdate tabListPacket() {
        return new WrapperPlayServerPlayerInfoUpdate(
            EnumSet.of(
                WrapperPlayServerPlayerInfoUpdate.Action.ADD_PLAYER,
                WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED
            ),
            createInfo()
        );
    }

    private WrapperPlayServerPlayerInfoUpdate.PlayerInfo createInfo() {
        return new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(
            profile, tablist, latency, gameMode, displayName, null
        );
    }

}
