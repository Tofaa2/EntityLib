package me.tofaa.entitylib.codegen;

public record TypeMapping(TypeToken typeToken, String packetEventsDataType, boolean isExcluded) {

    public TypeMapping(TypeToken typeToken, String dataType) {
        this(typeToken, dataType, false);
    }
}