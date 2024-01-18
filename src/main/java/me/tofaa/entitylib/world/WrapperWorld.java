package me.tofaa.entitylib.world;

import com.github.retrooper.packetevents.protocol.player.User;
import me.tofaa.entitylib.entity.WrapperEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class WrapperWorld {

    private final UUID uuid;
    private final Set<WrapperEntity> entities;
    private final Set<User> players;

    public WrapperWorld(UUID uuid) {
        this.uuid = uuid;
        this.entities = new HashSet<>();
        this.players = new HashSet<>();
    }

}
