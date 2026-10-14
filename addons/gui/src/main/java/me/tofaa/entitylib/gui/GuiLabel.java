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

public class GuiLabel extends GuiElement {

    private static final double LINE_HEIGHT = 0.275;

    private volatile Component text;
    private volatile double textScale = 1;

    public GuiLabel(@NotNull Component text) {
        super(0, LINE_HEIGHT);
        this.text = text;
    }

    public @NotNull Component text() {
        return text;
    }

    public @NotNull GuiLabel text(@NotNull Component text) {
        this.text = text;
        if (!displays().isEmpty()) {
            displays().get(0).entity().setMetadata(MetaFields.TextDisplay.TEXT, text);
        }
        return this;
    }

    public @NotNull GuiLabel text(@NotNull UUID viewer, @NotNull Component text) {
        if (!displays().isEmpty()) {
            displays().get(0).entity().setViewerMetadata(viewer, MetaFields.TextDisplay.TEXT, text);
        }
        return this;
    }

    public @NotNull GuiLabel resetText(@NotNull UUID viewer) {
        if (!displays().isEmpty()) {
            displays().get(0).entity().clearViewerMetadata(viewer);
        }
        return this;
    }

    public @NotNull GuiLabel textScale(double textScale) {
        this.textScale = textScale;
        refresh();
        return this;
    }

    @Override
    protected void build(@NotNull List<DisplayElement> displays) {
        WrapperEntity entity = new WrapperEntity(EntityTypes.TEXT_DISPLAY);
        entity.getMetadata().set(MetaFields.TextDisplay.TEXT, text);
        entity.getMetadata().set(MetaFields.TextDisplay.BACKGROUND_COLOR, 0);
        displays.add(new DisplayElement(entity, new Vec3(0, LINE_HEIGHT / 2, 0)));
    }

    @Override
    protected void layout(@NotNull List<DisplayElement> displays) {
        displays.get(0).position(position(0)).scale(textScale);
    }

}
