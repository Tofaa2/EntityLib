package me.tofaa.entitylib.bb.render;

import com.github.retrooper.packetevents.protocol.world.states.type.StateType;
import com.github.retrooper.packetevents.protocol.world.states.type.StateTypes;
import me.tofaa.entitylib.bb.model.BBCube;
import me.tofaa.entitylib.bb.model.BBFace;
import me.tofaa.entitylib.bb.model.BBModel;
import me.tofaa.entitylib.bb.model.BBTexture;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class BlockPalette {

    private record Entry(StateType type, int red, int green, int blue) {
    }

    private final List<Entry> entries = new ArrayList<>();
    private final Map<BBTexture, Optional<BufferedImage>> images = new ConcurrentHashMap<>();
    private StateType fallback = StateTypes.WHITE_CONCRETE;

    public static @NotNull BlockPalette defaults() {
        return new BlockPalette()
            .add(StateTypes.WHITE_CONCRETE, 0xCFD5D6).add(StateTypes.ORANGE_CONCRETE, 0xE06101)
            .add(StateTypes.MAGENTA_CONCRETE, 0xA9309F).add(StateTypes.LIGHT_BLUE_CONCRETE, 0x2489C7)
            .add(StateTypes.YELLOW_CONCRETE, 0xF1AF15).add(StateTypes.LIME_CONCRETE, 0x5EA918)
            .add(StateTypes.PINK_CONCRETE, 0xD6658F).add(StateTypes.GRAY_CONCRETE, 0x373A3E)
            .add(StateTypes.LIGHT_GRAY_CONCRETE, 0x7D7D73).add(StateTypes.CYAN_CONCRETE, 0x157788)
            .add(StateTypes.PURPLE_CONCRETE, 0x64209C).add(StateTypes.BLUE_CONCRETE, 0x2D2F8F)
            .add(StateTypes.BROWN_CONCRETE, 0x603C20).add(StateTypes.GREEN_CONCRETE, 0x495B24)
            .add(StateTypes.RED_CONCRETE, 0x8E2121).add(StateTypes.BLACK_CONCRETE, 0x080A0F)
            .add(StateTypes.WHITE_TERRACOTTA, 0xD2B2A1).add(StateTypes.ORANGE_TERRACOTTA, 0xA25426)
            .add(StateTypes.MAGENTA_TERRACOTTA, 0x96586D).add(StateTypes.LIGHT_BLUE_TERRACOTTA, 0x716D8A)
            .add(StateTypes.YELLOW_TERRACOTTA, 0xBA8523).add(StateTypes.LIME_TERRACOTTA, 0x687635)
            .add(StateTypes.PINK_TERRACOTTA, 0xA24E4F).add(StateTypes.GRAY_TERRACOTTA, 0x3A2A24)
            .add(StateTypes.LIGHT_GRAY_TERRACOTTA, 0x876B62).add(StateTypes.CYAN_TERRACOTTA, 0x575B5B)
            .add(StateTypes.PURPLE_TERRACOTTA, 0x764656).add(StateTypes.BLUE_TERRACOTTA, 0x4A3C5B)
            .add(StateTypes.BROWN_TERRACOTTA, 0x4D3324).add(StateTypes.GREEN_TERRACOTTA, 0x4C532A)
            .add(StateTypes.RED_TERRACOTTA, 0x8F3D2F).add(StateTypes.BLACK_TERRACOTTA, 0x251710);
    }

    public @NotNull BlockPalette add(@NotNull StateType type, int rgb) {
        entries.add(new Entry(type, (rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF));
        return this;
    }

    public @NotNull StateType fallback() {
        return fallback;
    }

    public @NotNull BlockPalette fallback(@NotNull StateType type) {
        this.fallback = type;
        return this;
    }

    public @NotNull StateType nearest(int rgb) {
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        StateType best = fallback;
        long bestDistance = Long.MAX_VALUE;
        for (Entry entry : entries) {
            long dr = red - entry.red;
            long dg = green - entry.green;
            long db = blue - entry.blue;
            long distance = dr * dr + dg * dg + db * db;
            if (distance < bestDistance) {
                bestDistance = distance;
                best = entry.type;
            }
        }
        return best;
    }

    public @NotNull StateType typeFor(@NotNull BBModel model, @NotNull BBCube cube) {
        int color = averageColor(model, cube);
        return color < 0 ? fallback : nearest(color);
    }

    public int averageColor(@NotNull BBModel model, @NotNull BBCube cube) {
        long red = 0;
        long green = 0;
        long blue = 0;
        long count = 0;
        for (BBFace face : cube.faces()) {
            if (!face.hasTexture() || face.texture() >= model.textures().size()) {
                continue;
            }
            BufferedImage image = image(model.textures().get(face.texture()));
            if (image == null) {
                continue;
            }
            double scaleX = image.getWidth() / (double) Math.max(1, model.resolutionWidth());
            double scaleY = image.getHeight() / (double) Math.max(1, model.resolutionHeight());
            int x1 = clamp((int) Math.floor(Math.min(face.u1(), face.u2()) * scaleX), image.getWidth() - 1);
            int x2 = clamp((int) Math.ceil(Math.max(face.u1(), face.u2()) * scaleX), image.getWidth());
            int y1 = clamp((int) Math.floor(Math.min(face.v1(), face.v2()) * scaleY), image.getHeight() - 1);
            int y2 = clamp((int) Math.ceil(Math.max(face.v1(), face.v2()) * scaleY), image.getHeight());
            for (int y = y1; y < Math.max(y2, y1 + 1); y++) {
                for (int x = x1; x < Math.max(x2, x1 + 1); x++) {
                    int argb = image.getRGB(x, y);
                    if ((argb >>> 24) < 16) {
                        continue;
                    }
                    red += (argb >> 16) & 0xFF;
                    green += (argb >> 8) & 0xFF;
                    blue += argb & 0xFF;
                    count++;
                }
            }
        }
        if (count == 0) {
            return -1;
        }
        return (int) ((red / count) << 16 | (green / count) << 8 | (blue / count));
    }

    private BufferedImage image(BBTexture texture) {
        return images.computeIfAbsent(texture, key -> {
            if (key.image().length == 0) {
                return Optional.empty();
            }
            try {
                return Optional.ofNullable(ImageIO.read(new ByteArrayInputStream(key.image())));
            } catch (IOException unreadable) {
                return Optional.empty();
            }
        }).orElse(null);
    }

    private static int clamp(int value, int max) {
        return Math.max(0, Math.min(max, value));
    }

}
