package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.enums.BillboardConstraints;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.Consumer;

final class ModernHologram extends AbstractHologram implements Hologram.Modern {

    private Consumer<Metadata> modifier;
    private WrapperEntity parent;

    ModernHologram(@NotNull Location location) {
        super(location);
    }

    @Override
    protected @NotNull WrapperEntity createLine(@NotNull Component line) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.TEXT_DISPLAY, location);
        Metadata metadata = entity.getMetadata();
        metadata.setFlag(MetaFields.Entity.INVISIBLE, true);
        metadata.set(MetaFields.Entity.NO_GRAVITY, true);
        metadata.set(MetaFields.TextDisplay.TEXT, line);
        metadata.set(MetaFields.Display.BILLBOARD_RENDER_CONSTRAINTS, BillboardConstraints.CENTER);
        if (modifier != null) {
            modifier.accept(metadata);
        }
        return entity;
    }

    @Override
    protected void setText(@NotNull WrapperEntity entity, @NotNull Component line) {
        entity.setMetadata(MetaFields.TextDisplay.TEXT, line);
    }

    @Override
    protected @Nullable Component getText(@NotNull WrapperEntity entity) {
        return entity.getMetadata().get(MetaFields.TextDisplay.TEXT);
    }

    @Override
    protected void setViewerText(@NotNull WrapperEntity entity, @NotNull UUID viewer, @NotNull Component line) {
        entity.setViewerMetadata(viewer, MetaFields.TextDisplay.TEXT, line);
    }

    @Override
    protected void layout() {
        if (lines.isEmpty()) {
            return;
        }
        WrapperEntity first = lines.get(0);
        if (parent == null) {
            first.teleport(location);
        }
        for (int i = 1; i < lines.size(); i++) {
            first.addPassenger(lines.get(i));
        }
    }

    @Override
    public synchronized void setParent(@NotNull WrapperEntity parent) {
        this.parent = parent;
        if (lines.isEmpty()) {
            return;
        }
        WrapperEntity first = lines.get(0);
        for (int i = 1; i < lines.size(); i++) {
            first.addPassenger(lines.get(i));
        }
        parent.addPassenger(first);
    }

    @Override
    public synchronized void setModifier(@NotNull Consumer<Metadata> consumer) {
        this.modifier = consumer;
    }

}
