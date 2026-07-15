package me.tofaa.entitylib.spawn;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface SpawnPacketProvider {

    @NotNull PacketWrapper<?> provide(@NotNull WrapperEntity entity, int protocolVersion);

}
