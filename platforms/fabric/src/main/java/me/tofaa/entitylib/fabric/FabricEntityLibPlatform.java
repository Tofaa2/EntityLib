package me.tofaa.entitylib.fabric;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import me.tofaa.entitylib.PacketEventsPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.IntSupplier;
import java.util.logging.Logger;

public class FabricEntityLibPlatform extends PacketEventsPlatform {

    private final String modId;
    private IntSupplier entityIds;
    private boolean entityIdsResolved;

    public FabricEntityLibPlatform(@NotNull String modId) {
        this(modId, PacketEvents.getAPI());
    }

    public FabricEntityLibPlatform(@NotNull String modId, @NotNull PacketEventsAPI<?> packetEvents) {
        super(packetEvents, Logger.getLogger("EntityLib"));
        this.modId = modId;
    }

    public @NotNull String getModId() {
        return modId;
    }

    public boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public int getProtocolVersion(@NotNull UUID user) {
        return getServerProtocolVersion();
    }

    @Override
    public synchronized int nextEntityId() {
        if (!entityIdsResolved) {
            entityIdsResolved = true;
            entityIds = FabricEntityIds.detect();
            if (entityIds == null) {
                logger.warning("Could not find the entity id counter, falling back to an internal one");
            }
        }
        return entityIds != null ? entityIds.getAsInt() : super.nextEntityId();
    }

}
