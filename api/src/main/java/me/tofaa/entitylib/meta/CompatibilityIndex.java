package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataType;

public interface CompatibilityIndex {

    byte getOffSet(byte latestOffset, EntityDataType<?> type);

}
