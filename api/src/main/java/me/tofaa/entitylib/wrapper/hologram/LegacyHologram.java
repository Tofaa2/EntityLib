package me.tofaa.entitylib.wrapper.hologram;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

final class LegacyHologram extends AbstractHologram implements Hologram.Legacy {

    private float lineOffset = -0.3f;
    private float markerOffset = -0.25f;
    private boolean marker;

    LegacyHologram(@NotNull Location location) {
        super(location);
    }

    @Override
    protected @NotNull WrapperEntity createLine(@NotNull Component line) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.ARMOR_STAND, location);
        Metadata metadata = entity.getMetadata();
        metadata.set(MetaFields.Entity.CUSTOM_NAME, Optional.of(line));
        metadata.set(MetaFields.Entity.CUSTOM_NAME_VISIBLE, true);
        metadata.set(MetaFields.Entity.NO_GRAVITY, true);
        metadata.setFlag(MetaFields.Entity.INVISIBLE, true);
        metadata.setFlag(MetaFields.ArmorStand.SMALL, true);
        metadata.setFlag(MetaFields.ArmorStand.MARKER, marker);
        return entity;
    }

    @Override
    protected void setText(@NotNull WrapperEntity entity, @NotNull Component line) {
        entity.setMetadata(MetaFields.Entity.CUSTOM_NAME, Optional.of(line));
    }

    @Override
    protected @Nullable Component getText(@NotNull WrapperEntity entity) {
        Optional<Component> name = entity.getMetadata().get(MetaFields.Entity.CUSTOM_NAME);
        return name == null ? null : name.orElse(null);
    }

    @Override
    protected void layout() {
        float offset = marker ? markerOffset : lineOffset;
        for (int i = 0; i < lines.size(); i++) {
            double y = location.getY() + (i * offset);
            lines.get(i).teleport(new Location(location.getX(), y, location.getZ(), location.getYaw(), location.getPitch()), false);
        }
    }

    @Override
    public boolean isMarker() {
        return marker;
    }

    @Override
    public void setMarker(boolean marker) {
        this.marker = marker;
        for (WrapperEntity line : lines) {
            line.setFlag(MetaFields.ArmorStand.MARKER, marker);
        }
        if (spawned) {
            layout();
        }
    }

    @Override
    public float getLineOffset(boolean marker) {
        return marker ? markerOffset : lineOffset;
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
        if (lines.isEmpty()) {
            return;
        }
        parent.addPassenger(lines.get(0));
    }

}
