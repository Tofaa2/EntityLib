package me.tofaa.entitylib.structure;

import org.jetbrains.annotations.NotNull;

public final class BlockStructure {

    private final int width;
    private final int height;
    private final int length;
    private final String[] palette;
    private final int[] blocks;

    public BlockStructure(int width, int height, int length, @NotNull String[] palette, @NotNull int[] blocks) {
        if (blocks.length != width * height * length) {
            throw new IllegalArgumentException("Expected " + (width * height * length) + " blocks but got " + blocks.length);
        }
        this.width = width;
        this.height = height;
        this.length = length;
        this.palette = palette;
        this.blocks = blocks;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int length() {
        return length;
    }

    public @NotNull String[] palette() {
        return palette;
    }

    public boolean contains(int x, int y, int z) {
        return x >= 0 && y >= 0 && z >= 0 && x < width && y < height && z < length;
    }

    public int index(int x, int y, int z) {
        return x + z * width + y * width * length;
    }

    public int paletteIndexAt(int x, int y, int z) {
        return contains(x, y, z) ? blocks[index(x, y, z)] : -1;
    }

    public @NotNull String stateAt(int x, int y, int z) {
        int index = paletteIndexAt(x, y, z);
        return index < 0 || index >= palette.length ? "minecraft:air" : palette[index];
    }

}
