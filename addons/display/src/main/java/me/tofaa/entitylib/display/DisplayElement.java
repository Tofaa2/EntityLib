package me.tofaa.entitylib.display;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import com.github.retrooper.packetevents.protocol.world.states.type.StateType;
import me.tofaa.entitylib.display.math.Quat;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class DisplayElement {

    private final WrapperEntity entity;
    private final Vec3 pivot;
    private volatile Vec3 position = Vec3.ZERO;
    private volatile Quat rotation = Quat.IDENTITY;
    private volatile Vec3 scale = Vec3.ONE;
    private volatile boolean visible = true;

    public DisplayElement(@NotNull WrapperEntity entity, @NotNull Vec3 pivot) {
        this.entity = entity;
        this.pivot = pivot;
    }

    public static @NotNull DisplayElement block(@NotNull WrappedBlockState state) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.BLOCK_DISPLAY);
        entity.getMetadata().set(MetaFields.BlockDisplay.BLOCK_STATE, state);
        return new DisplayElement(entity, new Vec3(0.5, 0.5, 0.5));
    }

    public static @NotNull DisplayElement block(@NotNull StateType type) {
        return block(WrappedBlockState.getDefaultState(type));
    }

    public static @NotNull DisplayElement blockCorner(@NotNull WrappedBlockState state) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.BLOCK_DISPLAY);
        entity.getMetadata().set(MetaFields.BlockDisplay.BLOCK_STATE, state);
        return new DisplayElement(entity, Vec3.ZERO);
    }

    public static @NotNull DisplayElement item(@NotNull ItemStack item) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.ITEM_DISPLAY);
        entity.getMetadata().set(MetaFields.ItemDisplay.ITEM_STACK, item);
        return new DisplayElement(entity, Vec3.ZERO);
    }

    public static @NotNull DisplayElement text(@NotNull Component text) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.TEXT_DISPLAY);
        entity.getMetadata().set(MetaFields.TextDisplay.TEXT, text);
        return new DisplayElement(entity, Vec3.ZERO);
    }

    public @NotNull WrapperEntity entity() {
        return entity;
    }

    public @NotNull Vec3 pivot() {
        return pivot;
    }

    public @NotNull Vec3 position() {
        return position;
    }

    public @NotNull DisplayElement position(@NotNull Vec3 position) {
        this.position = position;
        return this;
    }

    public @NotNull DisplayElement position(double x, double y, double z) {
        return position(new Vec3(x, y, z));
    }

    public @NotNull Quat rotation() {
        return rotation;
    }

    public @NotNull DisplayElement rotation(@NotNull Quat rotation) {
        this.rotation = rotation;
        return this;
    }

    public @NotNull Vec3 scale() {
        return scale;
    }

    public @NotNull DisplayElement scale(@NotNull Vec3 scale) {
        this.scale = scale;
        return this;
    }

    public @NotNull DisplayElement scale(double scale) {
        return scale(new Vec3(scale, scale, scale));
    }

    public boolean visible() {
        return visible;
    }

    public @NotNull DisplayElement visible(boolean visible) {
        this.visible = visible;
        return this;
    }

}
