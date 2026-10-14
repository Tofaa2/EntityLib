package me.tofaa.entitylib.bb.model;

public record BBFace(Direction direction, double u1, double v1, double u2, double v2, int texture) {

    public enum Direction {
        NORTH, EAST, SOUTH, WEST, UP, DOWN
    }

    public boolean hasTexture() {
        return texture >= 0;
    }

}
