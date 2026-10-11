package me.tofaa.entitylib.meta;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class MetaFlag {

    private final MetaField<Byte> field;
    private final String name;
    private final List<Range> ranges = new ArrayList<>();

    MetaFlag(MetaField<Byte> field, String name) {
        this.field = field;
        this.name = name;
    }

    void addRange(int fromProtocol, int toProtocol, int mask) {
        ranges.add(new Range(fromProtocol, toProtocol, mask));
        ranges.sort((a, b) -> Integer.compare(a.fromProtocol, b.fromProtocol));
    }

    public @NotNull MetaField<Byte> field() {
        return field;
    }

    public @NotNull String name() {
        return name;
    }

    public int mask() {
        return ranges.get(ranges.size() - 1).mask;
    }

    public int maskAt(int protocolVersion) {
        for (Range range : ranges) {
            if (protocolVersion >= range.fromProtocol && protocolVersion < range.toProtocol) {
                return range.mask;
            }
        }
        return 0;
    }

    public boolean existsIn(int protocolVersion) {
        return maskAt(protocolVersion) != 0;
    }

    @Override
    public String toString() {
        return field + "#" + name;
    }

    private static final class Range {
        final int fromProtocol;
        final int toProtocol;
        final int mask;

        Range(int fromProtocol, int toProtocol, int mask) {
            this.fromProtocol = fromProtocol;
            this.toProtocol = toProtocol;
            this.mask = mask;
        }
    }
}
