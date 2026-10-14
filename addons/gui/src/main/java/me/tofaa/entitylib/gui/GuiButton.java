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
import java.util.function.BiConsumer;

public class GuiButton extends GuiElement {

    private static final double LINE_HEIGHT = 0.275;

    private volatile Component text;
    private volatile int color = 0xC0202020;
    private volatile int hoverColor = 0xC0505050;
    private volatile double textScale = 1;
    private volatile BiConsumer<UUID, GuiClick> handler = (viewer, click) -> {
    };

    public GuiButton(@NotNull Component text, double width, double height) {
        super(width, height);
        this.text = text;
    }

    public @NotNull GuiButton colors(int argb, int hoverArgb) {
        this.color = argb;
        this.hoverColor = hoverArgb;
        if (!displays().isEmpty()) {
            displays().get(0).entity().setMetadata(MetaFields.TextDisplay.BACKGROUND_COLOR, argb);
        }
        return this;
    }

    public @NotNull GuiButton text(@NotNull Component text) {
        this.text = text;
        if (!displays().isEmpty()) {
            displays().get(1).entity().setMetadata(MetaFields.TextDisplay.TEXT, text);
        }
        return this;
    }

    public @NotNull GuiButton text(@NotNull UUID viewer, @NotNull Component text) {
        if (!displays().isEmpty()) {
            displays().get(1).entity().setViewerMetadata(viewer, MetaFields.TextDisplay.TEXT, text);
        }
        return this;
    }

    public @NotNull GuiButton textScale(double textScale) {
        this.textScale = textScale;
        refresh();
        return this;
    }

    public @NotNull GuiButton onClick(@NotNull BiConsumer<UUID, GuiClick> handler) {
        this.handler = handler;
        return this;
    }

    @Override
    public boolean interactive() {
        return true;
    }

    @Override
    protected void onHover(@NotNull UUID viewer, boolean hovered) {
        if (displays().isEmpty()) {
            return;
        }
        WrapperEntity background = displays().get(0).entity();
        if (hovered) {
            background.setViewerMetadata(viewer, MetaFields.TextDisplay.BACKGROUND_COLOR, hoverColor);
        } else {
            background.clearViewerMetadata(viewer);
        }
    }

    @Override
    protected void onClick(@NotNull UUID viewer, @NotNull GuiClick click) {
        handler.accept(viewer, click);
    }

    @Override
    protected void build(@NotNull List<DisplayElement> displays) {
        displays.add(GuiPanel.background(color));
        WrapperEntity label = new WrapperEntity(EntityTypes.TEXT_DISPLAY);
        label.getMetadata().set(MetaFields.TextDisplay.TEXT, text);
        label.getMetadata().set(MetaFields.TextDisplay.BACKGROUND_COLOR, 0);
        displays.add(new DisplayElement(label, new Vec3(0, LINE_HEIGHT / 2, 0)));
    }

    @Override
    protected void layout(@NotNull List<DisplayElement> displays) {
        GuiPanel.place(displays.get(0), position(0), width(), height());
        displays.get(1).position(position(1)).scale(textScale);
    }

}
