package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public interface Hologram<W> {

    static <C> Hologram.@NotNull Legacy<C> legacy(@NotNull Location location) {
        return new LegacyHologram<>(location);
    }

    static <C> Hologram.@NotNull Legacy<C> legacy(@NotNull Location location, List<Component> lines) {
        return new LegacyHologram<>(location, lines);
    }

    static <C> Hologram.@NotNull Modern<C> modern(@NotNull Location location) {
        return new ModernHologram<>(location);
    }

    static <C> Hologram.@NotNull Modern<C> modern(@NotNull Location location, List<Component> lines) {
        return new ModernHologram<>(location, lines);
    }

    @NotNull Location getLocation();


    void show();

    void hide();

    void teleport(Location location);

    @Nullable Component getLine(int index);

    int length();

    void setLine(int index, @Nullable Component line);

    void addLine(@Nullable Component line);

    interface Modern<W> extends Hologram<W> {

        // I got too lazy
        void setModifier(@NotNull Consumer<TextDisplayMeta> consumer);

    }
    interface Legacy<W> extends Hologram<W> {

        float getLineOffset(boolean marker);

        void setLineOffset(boolean marker, float value);

        default float getLineOffset() {
            return getLineOffset(false);
        }

        default void setLineOffset(float value) {
            setLineOffset(false, value);
        }

        boolean isMarker();

        void setMarker(boolean marker);

    }

}
