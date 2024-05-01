package me.tofaa.entitylib.extras.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;

import java.util.List;
import java.util.UUID;

/**
 * Represents a interface that fetches the skin of a player.
 * This class is non static, you should create and store an instance of it.
 * Creating one should be done using the builder. SkinFetcher is synchronous. You must handle that yourself.
 */
public interface SkinFetcher {

    static SkinFetcherBuilder builder() {
        return new SFBImpl();
    }


    List<TextureProperty> getSkin(String playerName);

    List<TextureProperty> getSkin(UUID uuid);

    List<TextureProperty> getSkinOrDefault(String playerName, List<TextureProperty> defaults);

    List<TextureProperty> getSkinOrDefault(UUID uuid, List<TextureProperty> defaults);

}
