package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.*;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoRemove;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoUpdate;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnPlayer;
import me.tofaa.entitylib.meta.EntityMeta;
import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.List;

public class WrapperPlayer extends WrapperLivingEntity {

    private final UserProfile profile;
    private GameMode gameMode = GameMode.CREATIVE;
    private Component displayName;
    private boolean tablist = true;

    public WrapperPlayer(UserProfile profile, int entityId) {
        super(entityId, profile.getUUID(), EntityTypes.PLAYER, EntityMeta.createMeta(entityId, EntityTypes.PLAYER));
        this.profile = profile;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        sendPacketsToViewers(new WrapperPlayServerPlayerInfo(
                WrapperPlayServerPlayerInfo.Action.UPDATE_GAME_MODE,
                new WrapperPlayServerPlayerInfo.PlayerData(displayName, profile, gameMode, null, -1)));
    }

    public void setDisplayName(Component displayName) {
        this.displayName = displayName;
        sendPacketsToViewers(new WrapperPlayServerPlayerInfo(
                WrapperPlayServerPlayerInfo.Action.UPDATE_DISPLAY_NAME,
                new WrapperPlayServerPlayerInfo.PlayerData(displayName, profile, gameMode, null, -1)));
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

    public GameMode getGameMode() {
        return gameMode;
    }

    @Override
    public void addViewer(User user) {
        //user.sendPacket(createAddPacket());
        sendJoiningPackets();
        super.addViewer(user);
    }

    @Override
    public void removeViewer(User user) {
        user.sendPacket(createRemovePacket());
        super.removeViewer(user);
    }

    @Override
    public boolean spawn(Location location) {
        this.setLocation(location);
        WrapperPlayServerSpawnPlayer packet = new WrapperPlayServerSpawnPlayer(getEntityId(), getUuid(), location, getEntityMeta());
        sendPacketsToViewers(packet);
        return true;
        //return super.spawn(location);
    }

    private void sendJoiningPackets() {
        List<WrapperPlayServerPlayerInfo.PlayerData> data = new ArrayList<>();
        data.add(new WrapperPlayServerPlayerInfo.PlayerData(displayName, profile, gameMode, null, -1));
        WrapperPlayServerPlayerInfo p1 = new WrapperPlayServerPlayerInfo(
                WrapperPlayServerPlayerInfo.Action.ADD_PLAYER,
                data
        );
        sendPacketsToViewers(p1);
    }

    private WrapperPlayServerPlayerInfoUpdate createAddPacket() {
        return new WrapperPlayServerPlayerInfoUpdate(
                WrapperPlayServerPlayerInfoUpdate.Action.ADD_PLAYER,
                new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(
                        profile,
                        true, -1, gameMode, displayName, null
                )
        );
    }

    private WrapperPlayServerPlayerInfoRemove createRemovePacket() {
        return new WrapperPlayServerPlayerInfoRemove(getUuid());
    }



}
