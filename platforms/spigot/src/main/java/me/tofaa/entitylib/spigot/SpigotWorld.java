package me.tofaa.entitylib.spigot;

import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.common.AbstractWorldWrapper;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public class SpigotWorld extends AbstractWorldWrapper<World> {


    SpigotWorld(World world) {
        super(world.getUID(), world, SpigotConversionUtil.fromBukkitWorld(world));
    }


    @Override
    public <T extends WrapperEntity> @NotNull T cloneEntity(@NotNull Object platformEntity, @NotNull Location location) {
        return null;
    }

    @Override
    public WrappedBlockState getBlock(int x, int y, int z) {
        return SpigotConversionUtil.fromBukkitBlockData(getHandle().getBlockData(new org.bukkit.Location(getHandle(), x, y, z)));
    }
}
