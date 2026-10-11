package me.tofaa.entitylib.extras.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;

import java.util.List;
import java.util.UUID;

public interface SkinFetcher {
    static SkinFetcherBuilder builder() {
        return new SFBImpl();
    }

    List<TextureProperty> getSkin(String playerName);

    List<TextureProperty> getSkin(UUID uuid);

    List<TextureProperty> getSkinOrDefault(String playerName, List<TextureProperty> defaults);

    List<TextureProperty> getSkinOrDefault(UUID uuid, List<TextureProperty> defaults);

}
