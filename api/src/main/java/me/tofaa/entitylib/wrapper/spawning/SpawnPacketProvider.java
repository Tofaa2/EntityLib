package me.tofaa.entitylib.wrapper.spawning;

import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import me.tofaa.entitylib.wrapper.WrapperEntity;

@FunctionalInterface
public interface SpawnPacketProvider<T extends PacketWrapper<T>> extends SpawnPacketProviders {

    T provide(User user, WrapperEntity entity);

}
