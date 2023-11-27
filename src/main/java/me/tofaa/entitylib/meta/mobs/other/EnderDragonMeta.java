package me.tofaa.entitylib.meta.mobs.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.MobMeta;
import org.jetbrains.annotations.NotNull;

public class EnderDragonMeta extends MobMeta {

    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;


    public EnderDragonMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public Phase getPhase() {
        return Phase.VALUES[super.metadata.getIndex(OFFSET, 0)];
    }

    public void setPhase(@NotNull Phase value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.INT, value.ordinal());
    }

    public enum Phase {
        CIRCLING,
        STRAFING,
        FLYING_TO_THE_PORTAL,
        LANDING_ON_THE_PORTAL,
        TAKING_OFF_FROM_THE_PORTAL,
        BREATH_ATTACK,
        LOOKING_FOR_BREATH_ATTACK_PLAYER,
        ROAR,
        CHARGING_PLAYER,
        FLYING_TO_THE_PORTAL_TO_DIE,
        HOVERING_WITHOUT_AI;

        private final static Phase[] VALUES = values();
    }

}
