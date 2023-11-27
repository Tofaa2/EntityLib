package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.mobs.passive.SheepMeta;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

public class TestCommand implements CommandExecutor {

    private int entityId = -1;
    private BukkitTask task;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (entityId == -1) {
            createEntity(player);
        }
        SheepMeta meta = EntityLib.getMeta(entityId, SheepMeta.class);
        if (task == null || task.isCancelled()) {
            this.task = Bukkit.getScheduler().runTaskTimer(EntityLibPlugin.instance, () -> {
                byte randomColor = (byte) (Math.random() * 15);
                meta.setColor(randomColor);
                meta.setSheared(!meta.isSheared());
                WrapperPlayServerEntityMetadata packet = meta.createPacket();
                packet.getEntityMetadata().forEach(s -> player.sendMessage(s.getValue().toString()));
                PacketEvents.getAPI().getPlayerManager().getUser(player).sendPacket(packet);
                player.sendMessage("Color is now " + meta.getColor() + " (" + randomColor + ")");
            }, 0L, 4L);
        }
        else {
            task.cancel();
            task = null;
        }
        return true;
    }

    void createEntity(Player player) {
        entityId = (int) (Math.random() * 99999);
        Optional<UUID> uuid = Optional.of(UUID.randomUUID());
        Optional<Vector3d> velocity = Optional.empty();
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(
                entityId,
                uuid,
                EntityTypes.SHEEP,
                new Vector3d(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()),
                player.getLocation().getPitch(),
                player.getLocation().getYaw(),
                90,
                0,
                velocity
        );
        PacketEvents.getAPI().getPlayerManager().getUser(player).sendPacket(packet);
        EntityMeta meta = EntityLib.createMeta(entityId, EntityTypes.SHEEP);
        player.sendMessage("Meta class is " + meta.getClass().getSimpleName());
    }
}
