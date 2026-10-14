package me.tofaa.testentitylib;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.display.DisplayGroup;
import me.tofaa.entitylib.display.math.Quat;
import me.tofaa.entitylib.shapes.ParticleMaterial;
import me.tofaa.entitylib.shapes.Shapes;
import me.tofaa.entitylib.shapes.Trail;
import com.github.retrooper.packetevents.protocol.world.states.type.StateTypes;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class TestShapeCommand extends BukkitCommand {

    private final JavaPlugin plugin;
    private DisplayGroup group;
    private Trail trail;
    private BukkitTask task;

    public TestShapeCommand(JavaPlugin plugin) {
        super("testshape");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        clear();
        if (strings.length == 0 || strings[0].equalsIgnoreCase("remove")) {
            player.sendMessage("Usage: /testshape <ring|sphere|helix|blocks|trail|remove>");
            return true;
        }
        switch (strings[0].toLowerCase()) {
            case "ring":
                group = Shapes.display(Shapes.ring(1.5, 24), ParticleMaterial.color(0xFF5555), 0.6);
                break;
            case "sphere":
                group = Shapes.display(Shapes.sphere(1.5, 80), ParticleMaterial.color(0x55FFFF), 0.5);
                break;
            case "helix":
                group = Shapes.display(Shapes.helix(1, 3, 3, 60), ParticleMaterial.color(0xFFFF55), 0.5);
                break;
            case "blocks":
                group = Shapes.display(Shapes.ring(2, 12), ParticleMaterial.block(StateTypes.DIAMOND_BLOCK), 0.3);
                break;
            case "trail":
                trail = new Trail(ParticleMaterial.color(0xFF55FF), 20, 0.8).interpolationTicks(2);
                trail.addViewer(player.getUniqueId());
                trail.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation().add(0, 1, 0)));
                task = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin,
                    () -> trail.advance(SpigotConversionUtil.fromBukkitLocation(player.getLocation().add(0, 1, 0))), 2L, 2L);
                return true;
            default:
                return true;
        }
        group.setInterpolationTicks(3);
        group.addViewer(player.getUniqueId());
        group.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation().add(0, 1.5, 0)));
        long start = System.currentTimeMillis();
        task = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            double seconds = (System.currentTimeMillis() - start) / 1000.0;
            group.setRotation(Quat.axisAngle(0, 1, 0, seconds * Math.PI).mul(Quat.axisAngle(1, 0, 0, seconds * 0.7)));
            group.update();
        }, 2L, 2L);
        return true;
    }

    private void clear() {
        if (task != null) {
            task.cancel();
            task = null;
        }
        if (group != null) {
            group.remove();
            group = null;
        }
        if (trail != null) {
            trail.remove();
            trail = null;
        }
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return Arrays.asList("ring", "sphere", "helix", "blocks", "trail", "remove");
    }

}
