package me.tofaa.entitylib.structure;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.display.DisplayGroup;
import me.tofaa.entitylib.display.math.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class StructureDisplay {

    private static final int[][] NEIGHBOURS = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    private static final String[] PARTIAL_BLOCKS = {
        "glass", "leaves", "ice", "slab", "stairs", "fence", "wall", "door", "pane", "bars", "carpet", "torch",
        "sign", "banner", "button", "plate", "rail", "chain", "lantern", "head", "skull", "bed", "candle", "sapling",
        "flower", "grass", "fern", "vine", "water", "lava", "snow", "path", "farmland", "chest", "anvil", "hopper"
    };

    public static final class Builder {

        private final BlockStructure structure;
        private boolean merge;
        private boolean cullHidden = true;
        private boolean centered;

        private Builder(BlockStructure structure) {
            this.structure = structure;
        }

        public @NotNull Builder merge(boolean merge) {
            this.merge = merge;
            return this;
        }

        public @NotNull Builder cullHidden(boolean cullHidden) {
            this.cullHidden = cullHidden;
            return this;
        }

        public @NotNull Builder centered(boolean centered) {
            this.centered = centered;
            return this;
        }

        public @NotNull StructureDisplay build() {
            return new StructureDisplay(structure, merge, cullHidden, centered);
        }

    }

    private final BlockStructure structure;
    private final DisplayGroup group = new DisplayGroup();
    private final Map<Integer, DisplayElement> elements = new HashMap<>();
    private final WrappedBlockState[] states;
    private final boolean[] fullCube;

    private StructureDisplay(BlockStructure structure, boolean merge, boolean cullHidden, boolean centered) {
        this.structure = structure;
        String[] palette = structure.palette();
        this.states = new WrappedBlockState[palette.length];
        this.fullCube = new boolean[palette.length];
        for (int i = 0; i < palette.length; i++) {
            if (palette[i] == null) {
                continue;
            }
            try {
                WrappedBlockState state = WrappedBlockState.getByString(palette[i]);
                if (state != null && !state.getType().isAir()) {
                    states[i] = state;
                    fullCube[i] = isFullCube(palette[i], state);
                }
            } catch (RuntimeException unknownState) {
                states[i] = null;
            }
        }

        Vec3 offset = centered ? new Vec3(-structure.width() / 2.0, 0, -structure.length() / 2.0) : Vec3.ZERO;
        boolean[] done = new boolean[structure.width() * structure.height() * structure.length()];
        for (int y = 0; y < structure.height(); y++) {
            for (int z = 0; z < structure.length(); z++) {
                for (int x = 0; x < structure.width(); x++) {
                    int index = structure.index(x, y, z);
                    int paletteIndex = structure.paletteIndexAt(x, y, z);
                    if (done[index] || paletteIndex < 0 || paletteIndex >= states.length || states[paletteIndex] == null) {
                        continue;
                    }
                    if (cullHidden && hidden(x, y, z)) {
                        done[index] = true;
                        continue;
                    }
                    int sizeX = 1;
                    int sizeY = 1;
                    int sizeZ = 1;
                    if (merge && fullCube[paletteIndex]) {
                        while (mergeable(done, paletteIndex, x + sizeX, y, z, cullHidden)) {
                            sizeX++;
                        }
                        while (rowMergeable(done, paletteIndex, x, y, z + sizeZ, sizeX, cullHidden)) {
                            sizeZ++;
                        }
                        while (layerMergeable(done, paletteIndex, x, y + sizeY, z, sizeX, sizeZ, cullHidden)) {
                            sizeY++;
                        }
                    }
                    for (int dy = 0; dy < sizeY; dy++) {
                        for (int dz = 0; dz < sizeZ; dz++) {
                            for (int dx = 0; dx < sizeX; dx++) {
                                done[structure.index(x + dx, y + dy, z + dz)] = true;
                            }
                        }
                    }
                    DisplayElement element = DisplayElement.blockCorner(states[paletteIndex])
                        .position(new Vec3(x, y, z).add(offset))
                        .scale(new Vec3(sizeX, sizeY, sizeZ));
                    elements.put(index, element);
                    group.add(element);
                }
            }
        }
    }

    public static @NotNull Builder builder(@NotNull BlockStructure structure) {
        return new Builder(structure);
    }

    public static @NotNull StructureDisplay create(@NotNull BlockStructure structure) {
        return new Builder(structure).build();
    }

    public @NotNull BlockStructure structure() {
        return structure;
    }

    public @NotNull DisplayGroup group() {
        return group;
    }

    public int size() {
        return elements.size();
    }

    public @Nullable DisplayElement element(int x, int y, int z) {
        return structure.contains(x, y, z) ? elements.get(structure.index(x, y, z)) : null;
    }

    public void addViewer(@NotNull UUID viewer) {
        group.addViewer(viewer);
    }

    public void removeViewer(@NotNull UUID viewer) {
        group.removeViewer(viewer);
    }

    public void spawn(@NotNull Location location) {
        group.spawn(location);
    }

    public void teleport(@NotNull Location location) {
        group.teleport(location);
    }

    public void update() {
        group.update();
    }

    public void remove() {
        group.remove();
    }

    private boolean mergeable(boolean[] done, int paletteIndex, int x, int y, int z, boolean cullHidden) {
        if (!structure.contains(x, y, z) || done[structure.index(x, y, z)]) {
            return false;
        }
        return structure.paletteIndexAt(x, y, z) == paletteIndex && !(cullHidden && hidden(x, y, z));
    }

    private boolean rowMergeable(boolean[] done, int paletteIndex, int x, int y, int z, int sizeX, boolean cullHidden) {
        for (int dx = 0; dx < sizeX; dx++) {
            if (!mergeable(done, paletteIndex, x + dx, y, z, cullHidden)) {
                return false;
            }
        }
        return true;
    }

    private boolean layerMergeable(boolean[] done, int paletteIndex, int x, int y, int z, int sizeX, int sizeZ, boolean cullHidden) {
        for (int dz = 0; dz < sizeZ; dz++) {
            if (!rowMergeable(done, paletteIndex, x, y, z + dz, sizeX, cullHidden)) {
                return false;
            }
        }
        return true;
    }

    private boolean hidden(int x, int y, int z) {
        for (int[] neighbour : NEIGHBOURS) {
            int index = structure.paletteIndexAt(x + neighbour[0], y + neighbour[1], z + neighbour[2]);
            if (index < 0 || index >= fullCube.length || !fullCube[index]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFullCube(String name, WrappedBlockState state) {
        if (!state.getType().isSolid() || !state.getType().isBlocking() || name.indexOf('[') >= 0) {
            return false;
        }
        for (String partial : PARTIAL_BLOCKS) {
            if (name.contains(partial)) {
                return false;
            }
        }
        return true;
    }

}
