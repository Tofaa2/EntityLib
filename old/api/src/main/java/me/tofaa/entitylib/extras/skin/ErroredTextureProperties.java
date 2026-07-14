package me.tofaa.entitylib.extras.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import me.tofaa.entitylib.extras.MojangApiError;

import java.util.List;
import java.util.UUID;

final class ErroredTextureProperties {

    UUID uuid;
    private MojangApiError error;
    private List<TextureProperty> textureProperties;

    ErroredTextureProperties(MojangApiError error) {
        this.error = error;
    }

    ErroredTextureProperties(List<TextureProperty> textureProperties) {
        this.textureProperties = textureProperties;
    }

    boolean didError() {
        return error != null;
    }

    MojangApiError getError() {
        return error;
    }

    List<TextureProperty> getTextureProperties() {
        return textureProperties;
    }

}
