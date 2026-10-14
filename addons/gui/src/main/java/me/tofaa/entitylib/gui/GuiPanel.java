package me.tofaa.entitylib.gui;

import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class GuiPanel extends GuiElement {

    static final double BACKGROUND_WIDTH = 0.125;
    static final double BACKGROUND_HEIGHT = 0.275;
    static final Vec3 BACKGROUND_PIVOT = new Vec3(0.0125, BACKGROUND_HEIGHT / 2, 0);

    private volatile int color;

    public GuiPanel(double width, double height, int argb) {
        super(width, height);
        this.color = argb;
    }

    public int color() {
        return color;
    }

    public @NotNull GuiPanel color(int argb) {
        this.color = argb;
        if (!displays().isEmpty()) {
            displays().get(0).entity().setMetadata(MetaFields.TextDisplay.BACKGROUND_COLOR, argb);
        }
        return this;
    }

    public @NotNull GuiPanel color(@NotNull UUID viewer, int argb) {
        if (!displays().isEmpty()) {
            displays().get(0).entity().setViewerMetadata(viewer, MetaFields.TextDisplay.BACKGROUND_COLOR, argb);
        }
        return this;
    }

    public @NotNull GuiPanel resetColor(@NotNull UUID viewer) {
        if (!displays().isEmpty()) {
            displays().get(0).entity().clearViewerMetadata(viewer);
        }
        return this;
    }

    @Override
    protected void build(@NotNull List<DisplayElement> displays) {
        displays.add(background(color));
    }

    @Override
    protected void layout(@NotNull List<DisplayElement> displays) {
        place(displays.get(0), position(0), width(), height());
    }

    static DisplayElement background(int argb) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.TEXT_DISPLAY);
        entity.getMetadata().set(MetaFields.TextDisplay.TEXT, Component.text(" "));
        entity.getMetadata().set(MetaFields.TextDisplay.BACKGROUND_COLOR, argb);
        return new DisplayElement(entity, BACKGROUND_PIVOT);
    }

    static void place(DisplayElement display, Vec3 position, double width, double height) {
        display.position(position).scale(new Vec3(width / BACKGROUND_WIDTH, height / BACKGROUND_HEIGHT, 1));
    }

}
