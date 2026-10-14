package me.tofaa.entitylib.structure;

import com.github.retrooper.packetevents.protocol.nbt.NBT;
import com.github.retrooper.packetevents.protocol.nbt.NBTByteArray;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.nbt.NBTLimiter;
import com.github.retrooper.packetevents.protocol.nbt.NBTNumber;
import com.github.retrooper.packetevents.protocol.nbt.serializer.DefaultNBTSerializer;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class SchematicReader {

    private SchematicReader() {
    }

    public static @NotNull BlockStructure read(@NotNull Path file) throws IOException {
        try (InputStream stream = Files.newInputStream(file)) {
            return read(stream);
        }
    }

    public static @NotNull BlockStructure read(@NotNull InputStream stream) throws IOException {
        NBT root;
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new GZIPInputStream(stream)))) {
            root = DefaultNBTSerializer.INSTANCE.deserializeTag(NBTLimiter.noop(), input, true);
        }
        if (!(root instanceof NBTCompound)) {
            throw new IOException("Schematic root is not a compound tag");
        }
        NBTCompound schematic = (NBTCompound) root;
        NBTCompound nested = schematic.getCompoundTagOrNull("Schematic");
        if (nested != null) {
            schematic = nested;
        }
        int width = number(schematic, "Width");
        int height = number(schematic, "Height");
        int length = number(schematic, "Length");

        NBTCompound container = schematic.getCompoundTagOrNull("Blocks");
        NBTCompound paletteTag;
        NBTByteArray data;
        if (container != null) {
            paletteTag = container.getCompoundTagOrNull("Palette");
            data = container.getTagOfTypeOrNull("Data", NBTByteArray.class);
        } else {
            paletteTag = schematic.getCompoundTagOrNull("Palette");
            data = schematic.getTagOfTypeOrNull("BlockData", NBTByteArray.class);
        }
        if (paletteTag == null || data == null) {
            throw new IOException("Schematic has no block palette or block data; only Sponge schematics (.schem) are supported");
        }

        String[] palette = new String[paletteTag.getTags().size()];
        for (Map.Entry<String, NBT> entry : paletteTag.getTags().entrySet()) {
            int id = ((NBTNumber) entry.getValue()).getAsInt();
            if (id < 0 || id >= palette.length) {
                throw new IOException("Schematic palette id " + id + " is out of range");
            }
            palette[id] = entry.getKey();
        }

        int[] blocks = new int[width * height * length];
        byte[] bytes = data.getValue();
        int position = 0;
        for (int i = 0; i < blocks.length; i++) {
            int value = 0;
            int shift = 0;
            while (true) {
                if (position >= bytes.length) {
                    throw new IOException("Schematic block data ends early");
                }
                byte current = bytes[position++];
                value |= (current & 0x7F) << shift;
                if ((current & 0x80) == 0) {
                    break;
                }
                shift += 7;
            }
            blocks[i] = value;
        }
        return new BlockStructure(width, height, length, palette, blocks);
    }

    private static int number(NBTCompound compound, String key) throws IOException {
        Number value = compound.getNumberTagValueOrNull(key);
        if (value == null) {
            throw new IOException("Schematic is missing " + key);
        }
        return value.intValue() & 0xFFFF;
    }

}
