package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface Hologram {

    static Hologram.@NotNull Legacy legacy(@NotNull Location location) {
        return new LegacyHologram(location);
    }

    static Hologram.@NotNull Legacy legacy(@NotNull Location location, @NotNull List<Component> lines) {
        LegacyHologram hologram = new LegacyHologram(location);
        hologram.setLines(lines);
        return hologram;
    }

    static Hologram.@NotNull Modern modern(@NotNull Location location) {
        return new ModernHologram(location);
    }

    static Hologram.@NotNull Modern modern(@NotNull Location location, @NotNull List<Component> lines) {
        ModernHologram hologram = new ModernHologram(location);
        hologram.setLines(lines);
        return hologram;
    }

    @NotNull Location getLocation();

    @Nullable WrapperEntity getEntity();

    void show();

    void hide();

    void teleport(@NotNull Location location);

    @Nullable Component getLine(int index);

    boolean updateLineContent(int index, @NotNull Component line);

    void setLines(@NotNull List<Component> lines);

    int length();

    void setLine(int index, @Nullable Component line);

    void removeLine(int index);

    void addLine(@Nullable Component line);

    void addViewer(@NotNull UUID viewer);

    default void addViewer(@NotNull User user) {
        addViewer(user.getUUID());
    }

    void removeViewer(@NotNull UUID viewer);

    default void removeViewer(@NotNull User user) {
        removeViewer(user.getUUID());
    }

    void setParent(@NotNull WrapperEntity parent);

    interface Modern extends Hologram {

        void setModifier(@NotNull Consumer<Metadata> consumer);

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
