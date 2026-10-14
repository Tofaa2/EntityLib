package me.tofaa.entitylib.gui;

import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.math.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class GuiElement {

    static final double LAYER_DEPTH = 0.004;

    private final List<DisplayElement> displays = new ArrayList<>();
    private volatile double x;
    private volatile double y;
    private volatile double width;
    private volatile double height;
    private volatile int layer;
    private volatile Gui gui;

    protected GuiElement(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double width() {
        return width;
    }

    public double height() {
        return height;
    }

    public int layer() {
        return layer;
    }

    public @NotNull GuiElement at(double x, double y) {
        this.x = x;
        this.y = y;
        refresh();
        return this;
    }

    public @NotNull GuiElement size(double width, double height) {
        this.width = width;
        this.height = height;
        refresh();
        return this;
    }

    public @NotNull GuiElement layer(int layer) {
        this.layer = layer;
        refresh();
        return this;
    }

    public boolean contains(double pointX, double pointY) {
        return Math.abs(pointX - x) <= width / 2 && Math.abs(pointY - y) <= height / 2;
    }

    public boolean interactive() {
        return false;
    }

    protected void onHover(@NotNull UUID viewer, boolean hovered) {
    }

    protected void onClick(@NotNull UUID viewer, @NotNull GuiClick click) {
    }

    protected abstract void build(@NotNull List<DisplayElement> displays);

    protected abstract void layout(@NotNull List<DisplayElement> displays);

    protected @NotNull Vec3 position(int depth) {
        return new Vec3(x, y, (layer + depth) * LAYER_DEPTH);
    }

    protected Gui gui() {
        return gui;
    }

    protected @NotNull List<DisplayElement> displays() {
        return displays;
    }

    protected void refresh() {
        Gui current = gui;
        if (current != null) {
            layout(displays);
            current.group().update();
        }
    }

    void attach(Gui gui) {
        this.gui = gui;
        if (displays.isEmpty()) {
            build(displays);
        }
        layout(displays);
        for (DisplayElement display : displays) {
            gui.group().add(display);
        }
    }

    void detach(Gui gui) {
        for (DisplayElement display : displays) {
            gui.group().remove(display);
        }
        this.gui = null;
    }

}
