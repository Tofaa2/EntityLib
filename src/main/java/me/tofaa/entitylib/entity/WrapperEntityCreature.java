package me.tofaa.entitylib.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.EntityLib;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Represents a {@link WrapperEntity} with goals, AI and pathfinding.
 * <p>
 *     To create a new {@link WrapperEntityCreature} use {@link EntityLib#createEntityCreature(int, UUID, EntityType)} or {@link EntityLib#createEntityCreature(UUID, EntityType)}.
 *     <br>
 *     Creature entities require some sort of ticking mechanism on your server to work properly. They need to be dynamically updated every tick.
 *     Goal and Target selectors are grouped into AIGroups, which are then added to the entity. The AIGroups are then updated every tick.
 *     <br>
 *     The {@link WrapperEntityCreature} can be inherited to create custom entities.
 * </p>
 */
public class WrapperEntityCreature extends WrapperLivingEntity{

    public WrapperEntityCreature(int entityId, @NotNull UUID uuid, EntityType entityType, EntityMeta meta) {
        super(entityId, uuid, entityType, meta);
    }
}
