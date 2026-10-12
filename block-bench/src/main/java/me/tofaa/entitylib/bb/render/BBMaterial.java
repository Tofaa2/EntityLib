package me.tofaa.entitylib.bb.render;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import com.github.retrooper.packetevents.protocol.world.states.type.StateType;
import me.tofaa.entitylib.bb.math.Vec3;
import me.tofaa.entitylib.bb.model.BBCube;
import me.tofaa.entitylib.bb.model.BBModel;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public final class BBMaterial {

    private interface Factory {
        @Nullable WrapperEntity create(BBModel model, @Nullable BBCube cube);
    }

    private static final BBMaterial HIDDEN = new BBMaterial((model, cube) -> null, false, 1, Vec3.ZERO);

    private final Factory factory;
    private final boolean centered;
    private final double scale;
    private final Vec3 offset;

    private BBMaterial(Factory factory, boolean centered, double scale, Vec3 offset) {
        this.factory = factory;
        this.centered = centered;
        this.scale = scale;
        this.offset = offset;
    }

    public static @NotNull BBMaterial block(@NotNull StateType type) {
        return new BBMaterial((model, cube) -> blockDisplay(WrappedBlockState.getDefaultState(type)), false, 1, Vec3.ZERO);
    }

    public static @NotNull BBMaterial block(@NotNull WrappedBlockState state) {
        return new BBMaterial((model, cube) -> blockDisplay(state), false, 1, Vec3.ZERO);
    }

    public static @NotNull BBMaterial palette(@NotNull BlockPalette palette) {
        return new BBMaterial((model, cube) ->
            blockDisplay(WrappedBlockState.getDefaultState(cube == null ? palette.fallback() : palette.typeFor(model, cube))), false, 1, Vec3.ZERO);
    }

    public static @NotNull BBMaterial item(@NotNull ItemStack item) {
        return new BBMaterial((model, cube) -> {
            WrapperEntity entity = new WrapperEntity(EntityTypes.ITEM_DISPLAY);
            entity.getMetadata().set(MetaFields.ItemDisplay.ITEM_STACK, item);
            return entity;
        }, true, 1, Vec3.ZERO);
    }

    public static @NotNull BBMaterial custom(@NotNull Supplier<WrapperEntity> entity, boolean centered) {
        return new BBMaterial((model, cube) -> entity.get(), centered, 1, Vec3.ZERO);
    }

    public static @NotNull BBMaterial hidden() {
        return HIDDEN;
    }

    public @NotNull BBMaterial scale(double scale) {
        return new BBMaterial(factory, centered, scale, offset);
    }

    public @NotNull BBMaterial offset(double x, double y, double z) {
        return new BBMaterial(factory, centered, scale, new Vec3(x, y, z));
    }

    public @Nullable WrapperEntity create(@NotNull BBModel model, @Nullable BBCube cube) {
        return factory.create(model, cube);
    }

    public boolean centered() {
        return centered;
    }

    public double scale() {
        return scale;
    }

    public @NotNull Vec3 offset() {
        return offset;
    }

    private static WrapperEntity blockDisplay(WrappedBlockState state) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.BLOCK_DISPLAY);
        entity.getMetadata().set(MetaFields.BlockDisplay.BLOCK_STATE, state);
        return entity;
    }

}
