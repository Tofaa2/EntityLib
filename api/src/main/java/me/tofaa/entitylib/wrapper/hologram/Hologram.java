package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3f;
import me.tofaa.entitylib.WorldWrapper;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import me.tofaa.entitylib.meta.types.DisplayMeta;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public interface Hologram<W> {

    static <C> Hologram.@NotNull Legacy<C> legacy(@NotNull WorldWrapper<C> world, @NotNull Location location) {
        return new LegacyHologram<>(world, location);
    }

    static <C> Hologram.@NotNull Legacy<C> legacy(@NotNull WorldWrapper<C> world, @NotNull Location location, List<Component> lines) {
        return new LegacyHologram<>(world, location, lines);
    }


    @NotNull Location getLocation();

    @NotNull WorldWrapper<W> getWorld();

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
