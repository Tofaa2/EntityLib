package me.tofaa.entitylib.meta.wrapper.impl;

import me.tofaa.entitylib.meta.EntityMetadata;
import me.tofaa.entitylib.meta.types.AxolotlMetaProperties;
import me.tofaa.entitylib.meta.wrapper.ChronologicalProtocolEnum;
import me.tofaa.entitylib.meta.wrapper.WrapperVarIntEnum;
import org.jetbrains.annotations.NotNull;

/**
 * Represents {@link AxolotlMetaProperties#VARIANT}
 */
public class WrapperAxolotlVariant extends WrapperVarIntEnum<WrapperAxolotlVariant.Variant> {

    // https://minecraft.wiki/w/Java_Edition_protocol/Entity_metadata#Axolotl
    public enum Variant implements ChronologicalProtocolEnum {
        LUCY,
        WILD,
        GOLD,
        CYAN,
        BLUE
    }

    public WrapperAxolotlVariant(@NotNull EntityMetadata store) {
        super(store, AxolotlMetaProperties.VARIANT, Variant.class, Variant.LUCY);
    }

}

