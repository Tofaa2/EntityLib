package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.entity.WrapperEntity;
import me.tofaa.entitylib.entity.WrapperLivingEntity;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.other.ArmorStandMeta;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.UUID;

public class TestEntityCommand implements CommandExecutor {

    private WrapperLivingEntity entity;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
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
        ItemStack held = player.getInventory().getItemInMainHand();
        if (held != null && !held.getType().isAir()) {
            entity.getEquipment().setBoots(SpigotConversionUtil.fromBukkitItemStack(held));
        }
        EntityMeta meta = entity.getMeta();
        meta.setOnFire(!meta.isOnFire());
        meta.setHasGlowingEffect(!meta.hasGlowingEffect());

        meta.setCustomNameVisible(!meta.isCustomNameVisible());
        meta.setCustomName(Component.text("test"));

        player.sendMessage("on fire: " + meta.isOnFire());
        player.sendMessage("glowing: " + meta.hasGlowingEffect());


        WrapperEntity e = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.ARMOR_STAND);
        int entityId = e.getEntityId(); // You can set the entityId provider to change this, WrapperEntity#ID_PROVIDER
        if (e == null) {
            throw new RuntimeException("Error creating entity meta"); // Only happens if the entity meta is null/invalid.
        }
        ArmorStandMeta m = (ArmorStandMeta) e.getMeta();
        m.setInvisible(true);
        e.spawn(new Location(1, 2, 3, 4, 5));
        e.addViewer(player.getUniqueId());

        return false;
    }

}
