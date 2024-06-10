package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.other.ArmorStandMeta;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

final class LegacyHologram implements Hologram.Legacy {

    private Location location;
    private final List<WrapperEntity> lines = new ArrayList<>(3);
    private float lineOffset = -0.9875f;
    private float markerOffset = -0.40625f;
    private boolean marker;

    LegacyHologram(@NotNull Location location) {
        this.location = location;
    }

    LegacyHologram(@NotNull Location location, List<Component> lines) {
        this(location);
        for (Component line : lines) {
            addLine(line);
        }
    }

    @Override
    public void addViewer(@NotNull UUID viewer) {
        for (WrapperEntity line : lines) {
            line.addViewer(viewer);
        }
    }

    @Override
    public boolean isMarker() {
        return marker;
    }

    @Override
    public void setMarker(boolean marker) {
        this.marker = true;
        if (lines.isEmpty()) return;
        teleport(location); // refresh
    }

    @Override
    public void show() {
        for (WrapperEntity line : lines) {
            line.spawn(location);
        }
        teleport(location);
    }

    @Override
    public void hide() {
        for (WrapperEntity line : lines) {
            line.despawn();
        }
    }

    @Override
    public void teleport(Location location) {
        this.location = location;
        // reversed order
        for (int i = lines.size() - 1; i >= 0; i--) {
            WrapperEntity line = lines.get(i);
            double y;
            if (marker) {
                y = location.getY() + markerOffset;
            } else {
                y = location.getY() + (i * lineOffset);
            }
            ArmorStandMeta meta = (ArmorStandMeta) line.getEntityMeta();
            meta.setMarker(marker);
            Location l = new Location(location.getX(), y, location.getZ(), location.getYaw(), location.getPitch());
            line.teleport(l, false);
        }
    }

    @Override
    public @Nullable Component getLine(int index) {
        if (index < 0 || index >= lines.size()) {
            return null;
        }
        return lines.get(index).getEntityMeta().getCustomName();
    }

    @Override
    public void setLine(int index, @Nullable Component line) {
        WrapperEntity e = EntityLib.getApi().spawnEntity(EntityTypes.ARMOR_STAND, location);
        ArmorStandMeta meta = (ArmorStandMeta) e.getEntityMeta();
        meta.setCustomName(line);
        meta.setCustomNameVisible(true);
        meta.setInvisible(true);
        meta.setHasNoGravity(true);
        meta.setSmall(true);
        meta.setMarker(marker);
        Check.arrayLength(lines, index, e);
        e.spawn(location);
        teleport(location);
    }

    @Override
    public void addLine(@Nullable Component line) {
        setLine(lines.size(), line);
    }

    @Override
    public float getLineOffset(boolean marker) {
        return marker ? markerOffset : lineOffset;
    }

    @Override
    public int length() {
        return lines.size();
    }

    @Override
    public void setLineOffset(boolean marker, float value) {
        if (marker) {
            markerOffset = value;
        } else {
            lineOffset = value;
        }
    }

    @Override
    public @NotNull Location getLocation() {
        return location;
    }

}
