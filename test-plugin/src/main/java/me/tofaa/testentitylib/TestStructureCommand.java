package me.tofaa.testentitylib;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.display.math.Vec3;
import me.tofaa.entitylib.structure.BlockStructure;
import me.tofaa.entitylib.structure.SchematicReader;
import me.tofaa.entitylib.structure.StructureDisplay;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class TestStructureCommand extends BukkitCommand {

    private final JavaPlugin plugin;
    private StructureDisplay display;

    public TestStructureCommand(JavaPlugin plugin) {
        super("teststructure");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (display != null) {
            display.remove();
            display = null;
        }
        if (strings.length == 0) {
            player.sendMessage("Usage: /teststructure <sample|file.schem|remove> [merge] [scale]");
            return true;
        }
        if (strings[0].equalsIgnoreCase("remove")) {
            return true;
        }
        try {
            BlockStructure structure = strings[0].equalsIgnoreCase("sample")
                ? sample()
                : SchematicReader.read(new File(plugin.getDataFolder(), strings[0]).toPath());
            boolean merge = strings.length > 1 && strings[1].equalsIgnoreCase("merge");
            display = StructureDisplay.builder(structure).merge(merge).centered(true).build();
            if (strings.length > 2) {
                display.group().setScale(Double.parseDouble(strings[2]));
            }
            display.addViewer(player.getUniqueId());
            display.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
            player.sendMessage("Spawned " + structure.width() + "x" + structure.height() + "x" + structure.length()
                + " structure as " + display.size() + " display entities");
        } catch (IOException | RuntimeException e) {
            player.sendMessage("Failed: " + e);
            e.printStackTrace();
        }
        return true;
    }

    private BlockStructure sample() {
        int size = 6;
        String[] palette = {"minecraft:air", "minecraft:stone_bricks", "minecraft:oak_planks", "minecraft:glass", "minecraft:glowstone"};
        int[] blocks = new int[size * size * size];
        BlockStructure shape = new BlockStructure(size, size, size, palette, blocks);
        for (int y = 0; y < size; y++) {
            for (int z = 0; z < size; z++) {
                for (int x = 0; x < size; x++) {
                    boolean edgeX = x == 0 || x == size - 1;
                    boolean edgeZ = z == 0 || z == size - 1;
                    int block = 0;
                    if (y == 0) {
                        block = 2;
                    } else if (y == size - 1) {
                        block = 1;
                    } else if (edgeX && edgeZ) {
                        block = 1;
                    } else if (edgeX || edgeZ) {
                        block = y == 2 || y == 3 ? 3 : 1;
                    } else if (y == 1 && x == size / 2 && z == size / 2) {
                        block = 4;
                    }
                    blocks[shape.index(x, y, z)] = block;
                }
            }
        }
        return shape;
    }

}
