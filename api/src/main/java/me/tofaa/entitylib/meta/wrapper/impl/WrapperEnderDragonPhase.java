package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.EnderDragonMetaProperties;
import me.tofaa.entitylib.meta.wrapper.ChronologicalProtocolEnum;
import me.tofaa.entitylib.meta.wrapper.WrapperVarIntEnum;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link EnderDragonMetaProperties#PHASE}
 */
public class WrapperEnderDragonPhase extends WrapperVarIntEnum<WrapperEnderDragonPhase.Phase> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Ender_Dragon
    public enum Phase implements ChronologicalProtocolEnum {
        CIRCLING,
        STRAFING,
        FLYING_TO_PORTAL,
        TAKING_OFF_FROM_PORTAL,
        LANDED_PERFORM_ATTACK,
        LANDED_LOOKING_FOR_PLAYER,
        LANDED_ROAR,
        CHARGING_PLAYER,
        FLYING_TO_PORTAL_TO_DIE,
        HOVERING_NO_AI;
    }

    public WrapperEnderDragonPhase(@NotNull EntityMetadata store) {
        super(store, EnderDragonMetaProperties.PHASE, Phase.class, Phase.HOVERING_NO_AI);
    }
}
