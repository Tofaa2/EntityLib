package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.*;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.*;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import net.kyori.adventure.text.Component;

import java.util.*;

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

    public WrapperPlayServerPlayerInfoRemove tabListRemovePacket() {
        return new WrapperPlayServerPlayerInfoRemove(getUuid());
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        sendPacketsToViewers(new WrapperPlayServerPlayerInfoUpdate(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_GAME_MODE, createInfo()));
    }

    public void setDisplayName(Component displayName) {
        this.displayName = displayName;
        sendPacketsToViewers(new WrapperPlayServerPlayerInfoUpdate(WrapperPlayServerPlayerInfoUpdate.Action.UPDATE_DISPLAY_NAME, createInfo()));
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
        despawn();
        System.out.println("Despawning");
        EntityLib.getApi().runLater(() -> spawn(getLocation()), 2L);

    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public boolean isInTablist() {
        return tablist;
    }

    public void setInTablist(boolean tablist) {
        this.tablist = tablist;
        sendPacketToViewers(tabListPacket());
        if (!tablist) {
            sendPacketToViewers(tabListRemovePacket());
        }
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
        sendPacketsToViewers(
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
