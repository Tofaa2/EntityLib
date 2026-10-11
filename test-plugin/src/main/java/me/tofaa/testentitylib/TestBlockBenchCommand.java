package me.tofaa.testentitylib;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.bb.BBModelEntity;
import me.tofaa.entitylib.bb.BBModelParser;
import me.tofaa.entitylib.bb.model.BBAnimation;
import me.tofaa.entitylib.bb.model.BBModel;
import me.tofaa.entitylib.bb.render.BBMaterial;
import me.tofaa.entitylib.bb.render.BBSkin;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.world.states.type.StateTypes;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestBlockBenchCommand extends BukkitCommand {

    private final JavaPlugin plugin;
    private BBModelEntity entity;
    private BukkitTask task;

    public TestBlockBenchCommand(JavaPlugin plugin) {
        super("testbb");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            player.sendMessage("Usage: /testbb <spawn [file|-] [palette|blocks|bone]|play <animation>|stop|scale <value>|remove>");
            return true;
        }
        try {
            switch (strings[0].toLowerCase()) {
                case "spawn":
                    remove();
                    BBModel model = load(strings.length > 1 && !strings[1].equals("-") ? strings[1] : null);
                    entity = BBModelEntity.create(model, skin(strings.length > 2 ? strings[2] : "palette"));
                    entity.setInterpolationTicks(2);
                    entity.addViewer(player.getUniqueId());
                    entity.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
                    player.sendMessage("Spawned " + model.name() + " with " + entity.getParts().size()
                        + " parts, animations: " + model.animations().keySet());
                    break;
                case "play":
                    if (entity == null || strings.length < 2) return true;
                    BBAnimation animation = entity.getModel().animation(strings[1]);
                    if (animation == null) {
                        player.sendMessage("Unknown animation");
                        return true;
                    }
                    stop();
                    long start = System.currentTimeMillis();
                    task = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin,
                        () -> entity.setPose(animation, (System.currentTimeMillis() - start) / 1000.0), 0L, 2L);
                    break;
                case "stop":
                    stop();
                    if (entity != null) entity.resetPose();
                    break;
                case "scale":
                    if (entity != null && strings.length > 1) entity.setScale(Float.parseFloat(strings[1]));
                    break;
                case "remove":
                    remove();
                    break;
                default:
                    break;
            }
        } catch (IOException | RuntimeException e) {
            player.sendMessage("Failed: " + e);
            e.printStackTrace();
        }
        return true;
    }

    private BBSkin skin(String name) {
        switch (name.toLowerCase()) {
            case "blocks":
                return BBSkin.builder()
                    .cube("head", BBMaterial.block(StateTypes.GLASS))
                    .cube("arm", BBMaterial.item(ItemStack.builder().type(ItemTypes.DIAMOND_BLOCK).build()))
                    .texture("sample.png", BBMaterial.block(StateTypes.OAK_PLANKS))
                    .build();
            case "bone":
                return BBSkin.builder()
                    .bone("head", BBMaterial.item(ItemStack.builder().type(ItemTypes.CARVED_PUMPKIN).build()).scale(0.5).offset(0, 4, 0))
                    .build();
            default:
                return BBSkin.palette();
        }
    }

    private BBModel load(String fileName) throws IOException {
        if (fileName != null) {
            return BBModelParser.parse(new File(plugin.getDataFolder(), fileName).toPath());
        }
        try (Reader reader = new InputStreamReader(plugin.getResource("sample.bbmodel"), StandardCharsets.UTF_8)) {
            return BBModelParser.parse(reader);
        }
    }

    private void stop() {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    private void remove() {
        stop();
        if (entity != null) {
            entity.remove();
            entity = null;
        }
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        List<String> options = new ArrayList<>();
        if (args.length == 1) {
            options.addAll(List.of("spawn", "play", "stop", "scale", "remove"));
        } else if (args.length == 2 && args[0].equalsIgnoreCase("play") && entity != null) {
            options.addAll(entity.getModel().animations().keySet());
        }
        return options;
    }

}
