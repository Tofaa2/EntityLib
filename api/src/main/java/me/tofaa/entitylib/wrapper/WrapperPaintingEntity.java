package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Direction;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.PaintingType;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariant;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariants;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.MetaFields;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;

public class WrapperPaintingEntity extends WrapperEntity {

    private PaintingVariant variant;
    private Direction paintingDirection;

    public WrapperPaintingEntity(int entityId, @NotNull UUID uuid, @NotNull Location location) {
        super(entityId, uuid, EntityTypes.PAINTING, location);
        setVariant(PaintingVariants.KEBAB);
    }

    public WrapperPaintingEntity(@NotNull Location location) {
        this(EntityLib.get().getPlatform().nextEntityId(), UUID.randomUUID(), location);
    }

    public WrapperPaintingEntity() {
        this(new Location(0, 0, 0, 0, 0));
    }

    public @NotNull PaintingVariant getVariant() {
        return variant;
    }

    public void setVariant(@NotNull PaintingVariant variant) {
        this.variant = variant;
        metadata.set(MetaFields.Painting.PAINTING_VARIANT, variant);
        respawn();
    }

    public @NotNull PaintingType getLegacyType() {
        return legacyType(variant);
    }

    public @NotNull Direction getPaintingDirection() {
        return paintingDirection != null ? paintingDirection : getDirection();
    }

    public void setPaintingDirection(@NotNull Direction direction) {
        this.paintingDirection = direction;
        respawn();
    }

    @Override
    public int getSpawnData() {
        return getPaintingDirection().ordinal();
    }

    public static @NotNull PaintingType legacyType(@NotNull PaintingVariant variant) {
        String name = variant.getName().getKey().toUpperCase(Locale.ROOT);
        if (name.equals("PIGSCENE")) {
            return PaintingType.PIG_SCENE;
        }
        try {
            return PaintingType.valueOf(name);
        } catch (IllegalArgumentException unknown) {
            return PaintingType.KEBAB;
        }
    }

}
