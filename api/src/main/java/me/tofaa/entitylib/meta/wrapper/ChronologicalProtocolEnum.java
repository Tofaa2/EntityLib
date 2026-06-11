package me.tofaa.entitylib.meta.wrapper;

/**
 * Represents a protocol enum where the protocol value is just {@link Enum#ordinal()}
 */
public interface ChronologicalProtocolEnum extends ProtocolEnum {

    @Override
    default int getProtocolValue() {
        return ((Enum<?>) this).ordinal();
    }

}
