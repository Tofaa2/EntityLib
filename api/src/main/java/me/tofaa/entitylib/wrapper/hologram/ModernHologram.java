package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

final class ModernHologram<W> implements Hologram.Modern<W> {

    private Location location;
    private List<WrapperEntity> lines = new ArrayList<>(3);
    private Consumer<TextDisplayMeta> modifier;

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
        if (lines.isEmpty()) return;
        WrapperEntity first = lines.get(0);
        first.teleport(location);
        for (WrapperEntity e : lines) {
            if (e.getUuid().equals(first.getUuid())) continue;
            first.addPassenger(e);
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
        WrapperEntity e = EntityLib.getApi().spawnEntity(EntityTypes.TEXT_DISPLAY, location);
        TextDisplayMeta meta = (TextDisplayMeta) e.getEntityMeta();
        meta.setInvisible(true);
        meta.setHasNoGravity(true);
        meta.setText(line);
        this.modifier.accept(meta);
        this.lines.set(index, e);
        e.spawn(location);
        teleport(location);
    }

    @Override
    public void addLine(@Nullable Component line) {
        setLine(lines.size(), line);
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
    public void setModifier(@NotNull Consumer<TextDisplayMeta> consumer) {
        this.modifier = consumer;
    }
}
