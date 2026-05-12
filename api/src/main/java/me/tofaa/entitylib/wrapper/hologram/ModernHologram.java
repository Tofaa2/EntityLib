package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

final class ModernHologram implements Hologram.Modern {

    private Location location;
    private final List<WrapperEntity> lines = new ArrayList<>(3);
    private Consumer<TextDisplayMeta> modifier;
    private boolean spawned = false;
    private WrapperEntity parent;

    ModernHologram(@NotNull Location location) {
        this.location = location;
    }

    ModernHologram(@NotNull Location location, List<Component> lines) {
        this(location);
        for (Component line : lines) {
            addLine(line);
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
        if (lines.isEmpty()) return;
        
        if (parent != null) {
            return;
        }
        
        WrapperEntity first = lines.get(0);
        first.teleport(location);
        for (WrapperEntity e : lines) {
            if (e.getUuid().equals(first.getUuid())) continue;
            first.addPassenger(e);
        }
    }

    @Override
    public void setParent(@NotNull WrapperEntity parent) {
        this.parent = parent;
        if (lines.isEmpty()) return;
        
        WrapperEntity first = lines.get(0);
        for (WrapperEntity e : lines) {
            if (e.getUuid().equals(first.getUuid())) continue;
            try {
                first.addPassenger(e);
            } catch (Exception ignored) {}
        }
        try {
            parent.addPassenger(first);
        } catch (Exception ignored) {}
    }

    @Override
    public boolean updateLineContent(int index, @NotNull Component line) {
        if (index < 0 || index >= lines.size()) {
            return false;
        }
        TextDisplayMeta meta = (TextDisplayMeta) lines.get(index).getEntityMeta();
        meta.setText(line);
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
            TextDisplayMeta meta = (TextDisplayMeta) lines.get(i).getEntityMeta();
            meta.setText(newLines.get(i));
        }

        for (int i = existingCount - 1; i >= newCount; i--) {
            lines.get(i).remove();
            lines.remove(i);
        }

        for (int i = existingCount; i < newCount; i++) {
            WrapperEntity e = new WrapperEntity(EntityTypes.TEXT_DISPLAY);
            TextDisplayMeta meta = (TextDisplayMeta) e.getEntityMeta();
            meta.setInvisible(true);
            meta.setHasNoGravity(true);
            meta.setText(newLines.get(i));
            meta.setBillboardConstraints(me.tofaa.entitylib.meta.display.AbstractDisplayMeta.BillboardConstraints.CENTER);
            if (this.modifier != null) {
                this.modifier.accept(meta);
            }
            if (spawned) {
                e.spawn(location);
            }
            lines.add(e);
        }

        if (spawned && parent == null) {
            teleport(location);
        }
    }

    @Override
    public @Nullable Component getLine(int index) {
        if (index < 0 || index >= lines.size()) {
            return null;
        }
        TextDisplayMeta meta = (TextDisplayMeta) lines.get(index).getEntityMeta();
        return meta.getText();
    }

    @Override
    public void setLine(int index, @Nullable Component line) {
        WrapperEntity e = new WrapperEntity(EntityTypes.TEXT_DISPLAY);
        e.spawn(location);
        TextDisplayMeta meta = (TextDisplayMeta) e.getEntityMeta();
        meta.setInvisible(true);
        meta.setHasNoGravity(true);
        meta.setText(line);
        meta.setBillboardConstraints(me.tofaa.entitylib.meta.display.AbstractDisplayMeta.BillboardConstraints.CENTER);
        if (this.modifier != null) {
            this.modifier.accept(meta);
        }
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
    }

    @Override
    public void addLine(@Nullable Component line) {
        setLine(lines.size(), line);
    }

    @Override
    public void addViewer(@NotNull UUID viewer) {
        for (WrapperEntity line : lines) {
            line.addViewer(viewer);
        }
    }

    @Override
    public void removeViewer(@NotNull UUID viewer) {
        for (WrapperEntity line : lines) {
            line.removeViewer(viewer);
        }
    }


    @Override
    public int length() {
        return lines.size();
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
    public void setModifier(@NotNull Consumer<TextDisplayMeta> consumer) {
        this.modifier = consumer;
    }
}
