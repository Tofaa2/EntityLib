package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Location;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.common.AbstractEntityLibAPI;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import me.tofaa.entitylib.meta.types.PlayerMeta;
import me.tofaa.entitylib.tick.TickContainer;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.logging.Level;

public class SpigotEntityLibAPI extends AbstractEntityLibAPI<JavaPlugin, BukkitTask> {


    SpigotEntityLibAPI(SpigotEntityLibPlatform platform, APIConfig settings) {
        super(platform, settings);
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {

    }

    @Override
    public <T extends WrapperEntity> @NotNull T cloneEntity(@NotNull Object platformEntity, @NotNull Location location) {
        Check.stateCondition(!(platformEntity instanceof Entity), "Entity must be a Bukkit entity");
        Entity e = (Entity) platformEntity;
        EntityType type = SpigotConversionUtil.fromBukkitEntityType(e.getType());
        EntityMeta meta = EntityMeta.createMeta(e.getEntityId(), type);
        meta.setHasNoGravity(!e.hasGravity());
        meta.setCustomNameVisible(e.isCustomNameVisible());
        String customName = e.getCustomName();
        if (customName != null) meta.setCustomName(LegacyComponentSerializer.legacyAmpersand().deserialize(customName));
        meta.setPose(ExtraConversionUtil.fromBukkitPose(e.getPose()));
        meta.setOnFire(e.getFireTicks() > 0);
        meta.setSilent(e.isSilent());
        meta.setHasGlowingEffect(e.isGlowing());
        if (e instanceof LivingEntity) {
            LivingEntity le = (LivingEntity) e;
            LivingEntityMeta lm = (LivingEntityMeta) meta;
            lm.setHealth((float) le.getHealth());
            lm.setFlyingWithElytra(le.isGliding());
        }
        if (e instanceof Player) {
            Player p = (Player) e;
            PlayerMeta pm = (PlayerMeta) meta;
            pm.setSneaking(p.isSneaking());
            pm.setSprinting(p.isSprinting());
            pm.setSwimming(p.isSwimming());
            pm.setActiveHand(ExtraConversionUtil.fromBukkitHand(p.getMainHand()));
        }
        WrapperEntity entity;
        int id = EntityLib.getPlatform().getEntityIdProvider().provide(e.getUniqueId(), type);
        UUID uuid = e.getUniqueId();
        if (meta instanceof PlayerMeta) {
            Player p = (Player) e;
            entity = new WrapperPlayer(ExtraConversionUtil.getProfileFromBukkitPlayer(p), id);
        }
        else if (meta instanceof LivingEntityMeta) {
            entity = new WrapperLivingEntity(id, uuid, type, meta);
        }
        else {
            entity = new WrapperEntity(id, uuid, type, meta);
        }
        if (entity == null) {
            throw new IllegalArgumentException("Could not clone entity");
        }
        return (T) this.spawnEntity(entity, location);
    }

    @Override
    public void addTickContainer(@NotNull TickContainer<?, BukkitTask> tickContainer) {
        if (!settings.shouldTickTickables()) {
            if (settings.isDebugMode()) {
                platform.getLogger().log(Level.WARNING, "Tried to add a TickContainer when ticking tickables is disabled!");
            }
            return;
        }
        tickContainers.add(tickContainer);
        if (settings.isDebugMode()) {
            platform.getLogger().log(Level.CONFIG, "Registering new tick container...");
        }
        getTickContainers().add(tickContainer);
        BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously(platform.getHandle(), () -> tickContainer.tick(System.currentTimeMillis()), 1L, 1L);
        tickContainer.setHandle(task);
    }
}
