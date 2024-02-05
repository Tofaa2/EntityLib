package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.common.AbstractWorldWrapper;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import me.tofaa.entitylib.meta.types.PlayerMeta;
import me.tofaa.entitylib.utils.Check;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpigotWorld extends AbstractWorldWrapper<World> {


    SpigotWorld(World world) {
        super(world.getUID(), world, SpigotConversionUtil.fromBukkitWorld(world));
    }


    @Override
    public <T extends WrapperEntity> @NotNull T cloneEntity(@NotNull Object platformEntity, @NotNull Location location) {
        Check.stateCondition(!(platformEntity instanceof Entity), "Entity must be a Bukkit entity");
        Entity e = (Entity) platformEntity;
        EntityMeta meta = EntityMeta.createMeta(e.getEntityId(), SpigotConversionUtil.fromBukkitEntityType(e.getType()));
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
        return null; // TODO;
    }

    @Override
    public WrappedBlockState getBlock(int x, int y, int z) {
        return SpigotConversionUtil.fromBukkitBlockData(getHandle().getBlockData(new org.bukkit.Location(getHandle(), x, y, z)));
    }
}
