package me.tofaa.entitylib.gui;

import org.jetbrains.annotations.NotNull;

public final class GuiLayout {

    private GuiLayout() {
    }

    public static void row(double centerX, double y, double spacing, @NotNull GuiElement... elements) {
        double total = spacing * Math.max(0, elements.length - 1);
        for (GuiElement element : elements) {
            total += element.width();
        }
        double cursor = centerX - total / 2;
        for (GuiElement element : elements) {
            element.at(cursor + element.width() / 2, y);
            cursor += element.width() + spacing;
        }
    }

    public static void column(double x, double centerY, double spacing, @NotNull GuiElement... elements) {
        double total = spacing * Math.max(0, elements.length - 1);
        for (GuiElement element : elements) {
            total += element.height();
        }
        double cursor = centerY + total / 2;
        for (GuiElement element : elements) {
            element.at(x, cursor - element.height() / 2);
            cursor -= element.height() + spacing;
        }
    }

    public static void grid(double centerX, double centerY, int columns, double cellWidth, double cellHeight,
                            @NotNull GuiElement... elements) {
        int rows = (elements.length + columns - 1) / columns;
        for (int i = 0; i < elements.length; i++) {
            int column = i % columns;
            int row = i / columns;
            elements[i].at(centerX + (column - (columns - 1) / 2.0) * cellWidth,
                centerY + ((rows - 1) / 2.0 - row) * cellHeight);
        }
    }

}
