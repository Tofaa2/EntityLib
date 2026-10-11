package me.tofaa.entitylib.standalone;

import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.PacketEventsPlatform;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class StandaloneEntityLibPlatform extends PacketEventsPlatform {

    public StandaloneEntityLibPlatform(@NotNull PacketEventsAPI<?> packetEvents) {
        this(packetEvents, Logger.getLogger("EntityLib"));
    }

    public StandaloneEntityLibPlatform(@NotNull PacketEventsAPI<?> packetEvents, @NotNull Logger logger) {
        super(packetEvents, logger);
    }

}
