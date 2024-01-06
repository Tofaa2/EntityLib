package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.entity.WrapperEntityEquipment;
import me.tofaa.entitylib.entity.WrapperLivingEntity;
import me.tofaa.entitylib.meta.EntityMeta;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TestEntityCommand implements CommandExecutor {

    private WrapperLivingEntity entity;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player )) return false;
        Player player = (Player) sender;
        if (entity == null) {
            entity = (WrapperLivingEntity) EntityLib.createEntity(UUID.randomUUID(), EntityTypes.ZOMBIE);
            if (entity == null) {
                player.sendMessage("idk");
                return false;
            }
            entity.addViewer(player.getUniqueId());
            entity.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
        }
        equipItems(player);
        EntityMeta meta = entity.getMeta();

        meta.setCustomNameVisible(!meta.isCustomNameVisible());
        meta.setCustomName(Component.text("test"));

        entity.refresh();
        return false;
    }

    private void equipItems(Player player) {
        ItemStack held = player.getInventory().getItemInMainHand();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();
        WrapperEntityEquipment equipment = entity.getEquipment();

        if (helmet != null && !helmet.getType().isAir()) equipment.setHelmet(SpigotConversionUtil.fromBukkitItemStack(helmet));
        if (chestplate != null && !chestplate.getType().isAir()) equipment.setChestplate(SpigotConversionUtil.fromBukkitItemStack(chestplate));
        if (leggings != null && !leggings.getType().isAir()) equipment.setLeggings(SpigotConversionUtil.fromBukkitItemStack(leggings));
        if (boots != null && !boots.getType().isAir()) equipment.setBoots(SpigotConversionUtil.fromBukkitItemStack(boots));
        if (!held.getType().isAir()) equipment.setMainHand(SpigotConversionUtil.fromBukkitItemStack(held));
    }

}
