package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.*;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoRemove;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoUpdate;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.EntityMeta;
import net.kyori.adventure.text.Component;

import java.util.List;

public class WrapperPlayer extends WrapperLivingEntity {

    private final UserProfile profile;
    private GameMode gameMode = GameMode.CREATIVE;
    private Component displayName;


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
        super.addViewer(user);
        user.sendPacket(createAddPacket());
    }

    @Override
    public void removeViewer(User user) {
        super.removeViewer(user);
        user.sendPacket(createRemovePacket());
    }

    private WrapperPlayServerPlayerInfoUpdate createAddPacket() {
        return new WrapperPlayServerPlayerInfoUpdate(
                WrapperPlayServerPlayerInfoUpdate.Action.ADD_PLAYER,
                new WrapperPlayServerPlayerInfoUpdate.PlayerInfo(
                        profile,
                        true, -1, gameMode, null, null
                )
        );
    }

    private WrapperPlayServerPlayerInfoRemove createRemovePacket() {
        return new WrapperPlayServerPlayerInfoRemove(getUuid());
    }

}
