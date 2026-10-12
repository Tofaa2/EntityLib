package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

abstract class AbstractHologram implements Hologram {

    protected final List<WrapperEntity> lines = new ArrayList<>(3);
    protected final Set<UUID> viewers = ConcurrentHashMap.newKeySet();
    protected Location location;
    protected boolean spawned;

    AbstractHologram(@NotNull Location location) {
        this.location = location;
    }

    protected abstract @NotNull WrapperEntity createLine(@NotNull Component line);

    protected abstract void setText(@NotNull WrapperEntity entity, @NotNull Component line);

    protected abstract @Nullable Component getText(@NotNull WrapperEntity entity);

    protected abstract void layout();

    protected abstract void setViewerText(@NotNull WrapperEntity entity, @NotNull UUID viewer, @NotNull Component line);

    @Override
    public synchronized void show() {
        spawned = true;
        for (WrapperEntity line : lines) {
            if (!line.isSpawned()) {
                line.spawn(location);
            }
        }
        layout();
    }

    @Override
    public synchronized void hide() {
        for (WrapperEntity line : lines) {
            line.despawn();
        }
        spawned = false;
    }

    @Override
    public synchronized void teleport(@NotNull Location location) {
        this.location = location;
        if (spawned) {
            layout();
        }
    }

    @Override
    public synchronized @Nullable Component getLine(int index) {
        if (index < 0 || index >= lines.size()) {
            return null;
        }
        return getText(lines.get(index));
    }

    @Override
    public synchronized boolean updateLineContent(int index, @NotNull Component line) {
        if (index < 0 || index >= lines.size()) {
            return false;
        }
        setText(lines.get(index), line);
        return true;
    }

    @Override
    public synchronized void setLines(@NotNull List<Component> newLines) {
        for (int i = lines.size() - 1; i >= newLines.size(); i--) {
            lines.remove(i).remove();
        }
        for (int i = 0; i < newLines.size(); i++) {
            Component line = newLines.get(i) == null ? Component.empty() : newLines.get(i);
            if (i < lines.size()) {
                setText(lines.get(i), line);
            } else {
                append(line);
            }
        }
        if (spawned) {
            layout();
        }
    }

    @Override
    public synchronized int length() {
        return lines.size();
    }

    @Override
    public synchronized void setLine(int index, @Nullable Component line) {
        Component text = line == null ? Component.empty() : line;
        if (index >= 0 && index < lines.size()) {
            setText(lines.get(index), text);
            return;
        }
        append(text);
        if (spawned) {
            layout();
        }
    }

    @Override
    public synchronized void removeLine(int index) {
        if (index < 0 || index >= lines.size()) {
            return;
        }
        lines.remove(index).remove();
        if (spawned && !lines.isEmpty()) {
            layout();
        }
    }

    @Override
    public synchronized void addLine(@Nullable Component line) {
        setLine(lines.size(), line);
    }

    @Override
    public synchronized void setLine(@NotNull UUID viewer, int index, @Nullable Component line) {
        if (index < 0 || index >= lines.size()) {
            return;
        }
        setViewerText(lines.get(index), viewer, line == null ? Component.empty() : line);
    }

    @Override
    public synchronized void resetLines(@NotNull UUID viewer) {
        for (WrapperEntity line : lines) {
            line.clearViewerMetadata(viewer);
        }
    }

    @Override
    public synchronized void addViewer(@NotNull UUID viewer) {
        viewers.add(viewer);
        for (WrapperEntity line : lines) {
            line.addViewer(viewer);
        }
    }

    @Override
    public synchronized void removeViewer(@NotNull UUID viewer) {
        viewers.remove(viewer);
        for (WrapperEntity line : lines) {
            line.removeViewer(viewer);
        }
    }

    @Override
    public synchronized @NotNull Location getLocation() {
        return location;
    }

    @Override
    public synchronized @Nullable WrapperEntity getEntity() {
        return lines.isEmpty() ? null : lines.get(0);
    }

    private void append(Component line) {
        WrapperEntity entity = createLine(line);
        for (UUID viewer : viewers) {
            entity.addViewer(viewer);
        }
        lines.add(entity);
        if (spawned) {
            entity.spawn(location);
        }
    }

}
