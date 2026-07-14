package me.tofaa.entitylib.npc.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class NPCSkin {

    private final String texture;
    private final @Nullable String signature;

    public NPCSkin(@NotNull String texture, @Nullable String signature) {
        this.texture = texture;
        this.signature = signature;
    }

    public @NotNull String getTexture() {
        return texture;
    }

    public @Nullable String getSignature() {
        return signature;
    }

    public @NotNull List<TextureProperty> getTextureProperties() {
        return Collections.singletonList(new TextureProperty("textures", texture, signature));
    }
}
