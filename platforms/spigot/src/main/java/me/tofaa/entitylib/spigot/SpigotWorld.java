package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.common.AbstractWorldWrapper;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import me.tofaa.entitylib.meta.types.PlayerMeta;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SpigotWorld extends AbstractWorldWrapper<World> {


    SpigotWorld(World world) {
        super(world.getUID(), world, SpigotConversionUtil.fromBukkitWorld(world));
    }


    @Override
    public <T extends WrapperEntity> @NotNull T cloneEntity(@NotNull Object platformEntity, @NotNull Location location) {
        Check.stateCondition(!(platformEntity instanceof Entity), "Entity must be a Bukkit entity");
        Entity e = (Entity) platformEntity;
        EntityType type = SpigotConversionUtil.fromBukkitEntityType(e.getType());
        EntityMeta meta = EntityMeta.createMeta(e.getEntityId(), type);
        meta.setHasNoGravity(!e.hasGravity());
        meta.setCustomNameVisible(e.isCustomNameVisible());
        meta.setCustomName(LegacyComponentSerializer.legacyAmpersand().deserialize(e.getCustomName()));
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
            entity = new WrapperPlayer(ExtraConversionUtil.fromBukkitPlayerProfile(p.getPlayerProfile()), id);
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
    public WrappedBlockState getBlock(int x, int y, int z) {
        return SpigotConversionUtil.fromBukkitBlockData(getHandle().getBlockData(new org.bukkit.Location(getHandle(), x, y, z)));
    }
}
