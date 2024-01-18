package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.entity.WrapperEntity;
import me.tofaa.entitylib.meta.mobs.FrogMeta;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class SpawnClickableFrogCommand implements CommandExecutor {

    private final Map<WrapperEntity, BukkitTask> updateTasks = new HashMap<>();
    private final FrogMeta.Variant[] variants = FrogMeta.Variant.values();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        WrapperEntity e = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.FROG);
        FrogMeta meta = (FrogMeta) e.getMeta();
        meta.setHasGlowingEffect(true);
        meta.setCustomNameVisible(true);
        meta.setCustomName(Component.text("CLICK ME!"));
        updateTasks.put(e, Bukkit.getScheduler().runTaskTimerAsynchronously(
                EntityLibPlugin.instance,
                new Runnable() {
                    int i = 0;
                    Random random = new Random();

                    @Override
                    public void run() {
                        if (!e.hasSpawned()) return;
                        int r = random.nextInt(2);
                        meta.setVariant(variants[r]);
                        meta.setCustomName(Component.text("CLICKED: " + i + " TIMES"));
                    }
                },
                20, 20));
        e.addViewer(player.getUniqueId());
        e.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
        return false;
    }
}
