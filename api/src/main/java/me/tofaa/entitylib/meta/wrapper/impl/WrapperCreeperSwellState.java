package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.CreeperMetaProperties;
import me.tofaa.entitylib.meta.wrapper.ProtocolEnum;
import me.tofaa.entitylib.meta.wrapper.WrapperVarIntEnum;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link CreeperMetaProperties#SWELL_DIR}
 */
public class WrapperCreeperSwellState extends WrapperVarIntEnum<WrapperCreeperSwellState.State> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Creeper
    public enum State implements ProtocolEnum {
        IDLE(-1),
        FUSE(1);

        private final int value;

        State(int value) {
            this.value = value;
        }

        @Override
        public int getProtocolValue() {
            return this.value;
        }
    }

    public WrapperCreeperSwellState(@NotNull EntityMetadata store) {
        super(store, CreeperMetaProperties.SWELL_DIR, State.class, State.IDLE);
    }

}
