package me.tofaa.entitylib.extras;

import net.kyori.adventure.util.RGBLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/*
    @Deprecated: My PR for this was accepted a while ago into PacketEvents, 3.0 will convert to the packet events version of this class.
 */
@Deprecated
public final class Color implements RGBLike {

    private static final int BIT_MASK = 0xFF;

    private final int red, green, blue;

    public Color(@Range(from = 0L, to = 255L) int red, @Range(from = 0L, to = 255L) int green, @Range(from = 0L, to = 255L) int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(int rgb) {
        this((rgb >> 16) & BIT_MASK, (rgb >> 8) & BIT_MASK, rgb & BIT_MASK);
    }

    public @NotNull Color withRed(@Range(from = 0L, to = 255L) int red) {
        return new Color(red, green, blue);
    }

    public @NotNull Color withGreen(@Range(from = 0L, to = 255L) int green) {
        return new Color(red, green, blue);
    }

    public @NotNull Color withBlue(@Range(from = 0L, to = 255L) int blue) {
        return new Color(red, green, blue);
    }

    public int asRGB() {
        int rgb = red;
        rgb = (rgb << 8) + green;
        return (rgb << 8) + blue;
    }

    @Override
    public @Range(from = 0L, to = 255L) int red() {
        return red;
    }

    @Override
    public @Range(from = 0L, to = 255L) int green() {
        return green;
    }

    @Override
    public @Range(from = 0L, to = 255L) int blue() {
        return blue;
    }
}
