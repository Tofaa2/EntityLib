package me.tofaa.entitylib.meta.wrapper;

public interface ProtocolEnum {

    /**
     * @return the protocol value used by the protocol for this enum constant (most likely but not always {@link Enum#ordinal()}.
     */
    int getProtocolValue();

}
