package me.tofaa.entitylib.codegen;

public final class VersionCheck {

    private int from;
    private int to;
    private byte offset;

    public VersionCheck(int from, int to, byte offset) {
        this.from = from;
        this.to = to;
        this.offset = offset;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public byte offset() {
        return offset;
    }
}
