package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
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
    private float lineOffset = -0.3f;
    private float markerOffset = -0.25f;
    private boolean marker;
    private boolean spawned = false;

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
    public boolean updateLineContent(int index, @NotNull Component line) {
        if (index < 0 || index >= lines.size()) {
            return false;
        }
        ArmorStandMeta meta = (ArmorStandMeta) lines.get(index).getEntityMeta();
        meta.setCustomName(line);
        return true;
    }

    @Override
    public void setLines(List<Component> newLines) {
        int existingCount = lines.size();
        int newCount = newLines.size();

        if (newCount == 0) {
            for (WrapperEntity line : lines) {
                line.remove();
            }
            lines.clear();
            return;
        }

        for (int i = 0; i < Math.min(existingCount, newCount); i++) {
            ArmorStandMeta meta = (ArmorStandMeta) lines.get(i).getEntityMeta();
            meta.setCustomName(newLines.get(i));
        }

        for (int i = existingCount - 1; i >= newCount; i--) {
            lines.get(i).remove();
            lines.remove(i);
        }

        for (int i = existingCount; i < newCount; i++) {
            WrapperEntity e = new WrapperEntity(EntityTypes.ARMOR_STAND);
            ArmorStandMeta meta = (ArmorStandMeta) e.getEntityMeta();
            meta.setCustomName(newLines.get(i));
            meta.setCustomNameVisible(true);
            meta.setInvisible(true);
            meta.setHasNoGravity(true);
            meta.setSmall(true);
            meta.setMarker(marker);
            if (spawned) {
                e.spawn(location);
            }
            lines.add(e);
        }

        if (spawned) {
            teleport(location);
        }
    }

    @Override
    public void removeViewer(@NotNull UUID viewer) {
        for (WrapperEntity line : lines) {
            line.removeViewer(viewer);
        }
    }

@Override
    public @NotNull Location getLocation() {
        return location;
    }

    @Override
    public @NotNull WrapperEntity getEntity() {
        return lines.isEmpty() ? null : lines.get(0);
    }

    @Override
    public boolean isMarker() {
        return marker;
    }

    @Override
    public void setMarker(boolean marker) {
        this.marker = marker;
        for (WrapperEntity line : lines) {
            ArmorStandMeta meta = (ArmorStandMeta) line.getEntityMeta();
            meta.setMarker(marker);
        }
        if (spawned) {
            teleport(location);
        }
    }

    @Override
    public void show() {
        for (WrapperEntity line : lines) {
            line.spawn(location);
        }
        teleport(location);
        spawned = true;
    }

    @Override
    public void hide() {
        for (WrapperEntity line : lines) {
            line.despawn();
        }
        spawned = false;
    }

    @Override
    public void teleport(Location location) {
        this.location = location;
        for (int i = 0; i < lines.size(); i++) {
            WrapperEntity line = lines.get(i);
            if (!line.isSpawned()) {
                line.spawn(location);
                spawned = true;
            }
            double y;
            if (marker) {
                y = location.getY() + (i * markerOffset);
            } else {
                y = location.getY() + (i * lineOffset);
            }
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
        if (index >= 0 && index < lines.size()) {
            ArmorStandMeta meta = (ArmorStandMeta) lines.get(index).getEntityMeta();
            meta.setCustomName(line);
            return;
        }
        WrapperEntity e = new WrapperEntity(EntityTypes.ARMOR_STAND);
        ArmorStandMeta meta = (ArmorStandMeta) e.getEntityMeta();
        meta.setCustomName(line);
        meta.setCustomNameVisible(true);
        meta.setInvisible(true);
        meta.setHasNoGravity(true);
        meta.setSmall(true);
        meta.setMarker(marker);
        Check.arrayLength(lines, index, e);
        if (spawned) {
            e.spawn(location);
            teleport(location);
        }
    }

    @Override
    public void removeLine(int index) {
        if (index < 0 || index >= lines.size()) {
            return;
        }
        this.lines.get(index).remove();
        this.lines.remove(index);
        if (spawned && !lines.isEmpty()) {
            teleport(location);
        }
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
    public void setParent(@NotNull WrapperEntity parent) {
        if (lines.isEmpty()) return;

        WrapperEntity first = lines.get(0);
        if (!first.getUuid().equals(parent.getUuid())) {
            parent.addPassenger(first);
        }
    }

}
