package me.tofaa.entitylib.gui;

import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.meta.MetaFields;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuiProgressBar extends GuiElement {

    private volatile double progress;
    private volatile int backgroundColor = 0xC0202020;
    private volatile int fillColor = 0xFF55FF55;

    public GuiProgressBar(double width, double height) {
        super(width, height);
    }

    public double progress() {
        return progress;
    }

    public @NotNull GuiProgressBar progress(double progress) {
        this.progress = Math.max(0, Math.min(1, progress));
        refresh();
        return this;
    }

    public @NotNull GuiProgressBar colors(int backgroundArgb, int fillArgb) {
        this.backgroundColor = backgroundArgb;
        this.fillColor = fillArgb;
        if (!displays().isEmpty()) {
            displays().get(0).entity().setMetadata(MetaFields.TextDisplay.BACKGROUND_COLOR, backgroundArgb);
            displays().get(1).entity().setMetadata(MetaFields.TextDisplay.BACKGROUND_COLOR, fillArgb);
        }
        return this;
    }

    @Override
    protected void build(@NotNull List<DisplayElement> displays) {
        displays.add(GuiPanel.background(backgroundColor));
        displays.add(GuiPanel.background(fillColor));
    }

    @Override
    protected void layout(@NotNull List<DisplayElement> displays) {
        GuiPanel.place(displays.get(0), position(0), width(), height());
        double filled = width() * progress;
        Vec3 fillPosition = position(1).add(new Vec3((filled - width()) / 2, 0, 0));
        GuiPanel.place(displays.get(1), fillPosition, filled, height());
        displays.get(1).visible(filled > 0);
    }

}
