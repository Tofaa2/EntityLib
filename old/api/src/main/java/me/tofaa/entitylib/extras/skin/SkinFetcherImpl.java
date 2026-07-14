package me.tofaa.entitylib.extras.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import me.tofaa.entitylib.extras.MojangApiError;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

final class SkinFetcherImpl implements SkinFetcher {

    private final Consumer<MojangApiError> rateLimitErrorConsumer;

    public SkinFetcherImpl(Consumer<MojangApiError> rateLimitErrorConsumer) {
        this.rateLimitErrorConsumer = rateLimitErrorConsumer;
    }

    @Override
    public List<TextureProperty> getSkin(String playerName) {
        ErroredTextureProperties p = SFUtils.getTextures(playerName);
        if (p.didError()) {
            rateLimitErrorConsumer.accept(p.getError());
            return Collections.emptyList();
        }
        return p.getTextureProperties();
    }

    @Override
    public List<TextureProperty> getSkin(UUID uuid) {
        ErroredTextureProperties p = SFUtils.getTextures(uuid);
        if (p.didError()) {
            rateLimitErrorConsumer.accept(p.getError());
            return Collections.emptyList();
        }
        return p.getTextureProperties();
    }

    @Override
    public List<TextureProperty> getSkinOrDefault(String playerName, List<TextureProperty> defaults) {
        ErroredTextureProperties p = SFUtils.getTextures(playerName);
        if (p.didError()) {
            rateLimitErrorConsumer.accept(p.getError());
            return defaults;
        }
        return p.getTextureProperties();
    }

    @Override
    public List<TextureProperty> getSkinOrDefault(UUID uuid, List<TextureProperty> defaults) {
        ErroredTextureProperties p = SFUtils.getTextures(uuid);
        if (p.didError()) {
            rateLimitErrorConsumer.accept(p.getError());
            return defaults;
        }
        return p.getTextureProperties();
    }

}
