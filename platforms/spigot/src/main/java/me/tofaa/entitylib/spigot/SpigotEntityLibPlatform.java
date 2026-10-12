package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.player.EquipmentSlot;
import io.github.retrooper.packetevents.bstats.bukkit.Metrics;
import io.github.retrooper.packetevents.bstats.charts.SimplePie;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.utils.ELVersions;
import me.tofaa.entitylib.meta.MetaClass;
import me.tofaa.entitylib.PacketEventsPlatform;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class SpigotEntityLibPlatform extends PacketEventsPlatform {

    private final JavaPlugin plugin;
    private Supplier<Integer> entityIds;

    public SpigotEntityLibPlatform(@NotNull JavaPlugin plugin) {
        this(plugin, PacketEvents.getAPI());
    }

    public SpigotEntityLibPlatform(@NotNull JavaPlugin plugin, @NotNull PacketEventsAPI<?> packetEvents) {
        super(packetEvents, plugin.getLogger());
        this.plugin = plugin;
        setUserLocaleProvider(new SpigotPlayerLocaleProvider());
    }

    @Override
    public void setup(@NotNull APIConfig config) {
        if (config.shouldUseBstats()) {
            Metrics metrics = new Metrics((Plugin) packetEvents.getPlugin(), 21916);
            metrics.addCustomChart(new SimplePie("entitylib-version", () -> ELVersions.RAW));
        }
    }

    public @NotNull JavaPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void sendPacket(@NotNull UUID user, @NotNull PacketWrapper<?> packet) {
        Player player = Bukkit.getPlayer(user);
        if (player != null) {
            packetEvents.getPlayerManager().sendPacket(player, packet);
        }
    }

    @Override
    public String getWorld(@NotNull UUID user) {
        Player player = Bukkit.getPlayer(user);
        return player == null ? null : player.getWorld().getName();
    }

    @Override
    public int getProtocolVersion(@NotNull UUID user) {
        return getServerProtocolVersion();
    }

    @Override
    public synchronized int nextEntityId() {
        if (entityIds == null) {
            entityIds = SpigotEntityIds.detect(packetEvents.getServerManager().getVersion());
        }
        return entityIds.get();
    }

    public @NotNull WrapperEntity cloneEntity(@NotNull Entity entity) {
        EntityType type = SpigotConversionUtil.fromBukkitEntityType(entity.getType());
        Location location = SpigotConversionUtil.fromBukkitLocation(entity.getLocation());
        int id = nextEntityId();
        WrapperEntity wrapper;
        if (entity instanceof Player) {
            wrapper = new WrapperPlayer(id, ExtraConversionUtil.getProfileFromBukkitPlayer((Player) entity), location);
        } else if (entity instanceof LivingEntity) {
            wrapper = new WrapperLivingEntity(id, entity.getUniqueId(), type, location);
        } else {
            wrapper = new WrapperEntity(id, entity.getUniqueId(), type, location);
        }

        wrapper.setWorld(entity.getWorld().getName());
        int protocolVersion = getServerProtocolVersion();
        MetaClass metaClass = MetaFields.metaClass(type, protocolVersion);
        if (metaClass != null) {
            List<EntityData<?>> entityData = SpigotConversionUtil.getEntityMetadata(entity);
            wrapper.getMetadata().decode(metaClass, protocolVersion, entityData);
        }
        if (entity instanceof LivingEntity) {
            EntityEquipment equipment = ((LivingEntity) entity).getEquipment();
            if (equipment != null) {
                WrapperLivingEntity living = (WrapperLivingEntity) wrapper;
                living.getEquipment().setNotifyChanges(false);
                if (packetEvents.getServerManager().getVersion().isNewerThanOrEquals(ServerVersion.V_1_9)) {
                    living.getEquipment().setItem(EquipmentSlot.MAIN_HAND, SpigotConversionUtil.fromBukkitItemStack(equipment.getItemInMainHand()));
                    living.getEquipment().setItem(EquipmentSlot.OFF_HAND, SpigotConversionUtil.fromBukkitItemStack(equipment.getItemInOffHand()));
                } else {
                    living.getEquipment().setItem(EquipmentSlot.MAIN_HAND, SpigotConversionUtil.fromBukkitItemStack(equipment.getItemInHand()));
                }
                living.getEquipment().setItem(EquipmentSlot.HELMET, SpigotConversionUtil.fromBukkitItemStack(equipment.getHelmet()));
                living.getEquipment().setItem(EquipmentSlot.CHEST_PLATE, SpigotConversionUtil.fromBukkitItemStack(equipment.getChestplate()));
                living.getEquipment().setItem(EquipmentSlot.LEGGINGS, SpigotConversionUtil.fromBukkitItemStack(equipment.getLeggings()));
                living.getEquipment().setItem(EquipmentSlot.BOOTS, SpigotConversionUtil.fromBukkitItemStack(equipment.getBoots()));
                living.getEquipment().setNotifyChanges(true);
            }
        }
        return wrapper;
    }

}
