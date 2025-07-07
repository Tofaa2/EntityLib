package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityHeadLook;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityRotation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoRemove;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoUpdate;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnPlayer;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class WrapperPlayer extends WrapperLivingEntity {

    private UserProfile profile;
    private GameMode gameMode = GameMode.CREATIVE;
    private Component displayName;
    private boolean tablist = true;
    private int latency = -1;

    public WrapperPlayer(UserProfile profile, int entityId) {
        super(entityId, profile.getUUID(), EntityTypes.PLAYER, EntityMeta.createMeta(entityId, EntityTypes.PLAYER));
        this.profile = profile;
    }

    @Override
    protected PacketWrapper<?> createSpawnPacket() {
        if (EntityLib.getApi().getPacketEvents().getServerManager().getVersion().isOlderThanOrEquals(ServerVersion.V_1_20_1)) {
            return new WrapperPlayServerSpawnPlayer(
                    getEntityId(),
                    profile.getUUID(),
                    getLocation(),
                    getEntityMeta().entityData()
            );
        }
        return super.createSpawnPacket();
    }

    @Override
    public @NotNull List<PacketWrapper<?>> createSpawnPackets() {
        final List<PacketWrapper<?>> packets = super.createSpawnPackets();
        packets.add(new WrapperPlayServerEntityRotation(getEntityId(), getYaw(), getPitch(), isOnGround()));
        packets.add(new WrapperPlayServerEntityHeadLook(getEntityId(), getYaw()));
        return packets;
    }

    public WrapperPlayServerPlayerInfoUpdate tabListPacket() {
        EnumSet<WrapperPlayServerPlayerInfoUpdate.Action> actions = EnumSet.of(
                WrapperPlayServerPlayerInfoUpdate.Action.ADD_PLAYER,
                WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED
        );
        return new WrapperPlayServerPlayerInfoUpdate(
                actions,
                createInfo()
        );
    }

    public List<TextureProperty> getTextures() {
        return profile.getTextureProperties();
    }

    public WrapperPlayServerPlayerInfoUpdate tabListRemovePacket() {
        return new WrapperPlayServerPlayerInfoUpdate(EnumSet.of(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LISTED), createInfo());
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        sendPacketsToViewersIfSpawned(new WrapperPlayServerPlayerInfoUpdate(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_GAME_MODE, createInfo()));
    }

    public void setDisplayName(Component displayName) {
        this.displayName = displayName;
        sendPacketsToViewersIfSpawned(new WrapperPlayServerPlayerInfoUpdate(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_DISPLAY_NAME, createInfo()));
    }

    public Component getDisplayName() {
        return displayName;
    }

    public String getUsername() {
        return profile.getName();
    }

    public List<TextureProperty> getTextureProperties() {
        return profile.getTextureProperties();
    }

    public void setTextureProperties(List<TextureProperty> textureProperties) {
        profile.setTextureProperties(textureProperties);
        if (!isSpawned()) return;
        WrapperPlayServerDestroyEntities destroyEntities = new WrapperPlayServerDestroyEntities(getEntityId());
        WrapperPlayServerPlayerInfoRemove removePacket = new WrapperPlayServerPlayerInfoRemove(getUuid());
        WrapperPlayServerPlayerInfoUpdate updatePacket = tabListPacket();
        {
            sendPacketToViewers(removePacket);
            sendPacketToViewers(destroyEntities);

            sendPacketToViewers(updatePacket);
            for (UUID viewer : viewers) {
                removeViewer(viewer);
                addViewer(viewer);
            }
        }
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public boolean isInTablist() {
        return tablist;
    }

    public void setInTablist(boolean tablist) {
        this.tablist = tablist;
        sendPacketsToViewersIfSpawned(tabListPacket());
//        if (!tablist) {
//            sendPacketsToViewersIfSpawned(tabListRemovePacket());
//        }
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
        sendPacketsToViewersIfSpawned(
                new WrapperPlayServerPlayerInfoUpdate(
                        WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_LATENCY,
                        createInfo()
                )
        );
    }

    protected WrapperPlayServerPlayerInfoUpdate.PlayerInfo createInfo() {
        return new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(
                profile,
                tablist,
                latency,
                gameMode,
                displayName,
                null
        );
    }


}
