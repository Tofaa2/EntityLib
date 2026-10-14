package me.tofaa.entitylib.gui;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.enums.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class GuiIcon extends GuiElement {

    private static final double DEPTH = 0.01;

    private volatile ItemStack item;

    public GuiIcon(@NotNull ItemStack item, double size) {
        super(size, size);
        this.item = item;
    }

    public @NotNull GuiIcon item(@NotNull ItemStack item) {
        this.item = item;
        if (!displays().isEmpty()) {
            displays().get(0).entity().setMetadata(MetaFields.ItemDisplay.ITEM_STACK, item);
        }
        return this;
    }

    public @NotNull GuiIcon item(@NotNull UUID viewer, @NotNull ItemStack item) {
        if (!displays().isEmpty()) {
            displays().get(0).entity().setViewerMetadata(viewer, MetaFields.ItemDisplay.ITEM_STACK, item);
        }
        return this;
    }

    @Override
    protected void build(@NotNull List<DisplayElement> displays) {
        DisplayElement display = DisplayElement.item(item);
        display.entity().getMetadata().set(MetaFields.ItemDisplay.ITEM_DISPLAY, ItemDisplayContext.GUI);
        displays.add(display);
    }

    @Override
    protected void layout(@NotNull List<DisplayElement> displays) {
        displays.get(0).position(position(0)).scale(new Vec3(width(), height(), DEPTH));
    }

}
