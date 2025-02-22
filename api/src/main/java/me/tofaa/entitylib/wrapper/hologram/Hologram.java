package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface Hologram {

    static  Hologram.@NotNull Legacy legacy(@NotNull Location location) {
        return new LegacyHologram(location);
    }

    static  Hologram.@NotNull Legacy legacy(@NotNull Location location, List<Component> lines) {
        return new LegacyHologram(location, lines);
    }


    static  Hologram.@NotNull Modern modern(@NotNull Location location) {
        return new ModernHologram(location);
    }

    static  Hologram.@NotNull Modern modern(@NotNull Location location, List<Component> lines) {
        return new ModernHologram(location, lines);
    }

    @NotNull Location getLocation();


    void show();

    void hide();

    void teleport(Location location);

    @Nullable Component getLine(int index);

    int length();

    void setLine(int index, @Nullable Component line);

    void removeLine(int index);

    void addLine(@Nullable Component line);

    void addViewer(@NotNull UUID viewer);
    default void addViewer(@NotNull User user) {
        addViewer(user.getUUID());
    }

    interface Modern extends Hologram {

        // I got too lazy
        void setModifier(@NotNull Consumer<TextDisplayMeta> consumer);

    }
    interface Legacy extends Hologram {

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
