package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface EntityUuidProvider {

    @NotNull UUID provide(EntityType entityType);


    class DefaultEntityUuidProvider implements EntityUuidProvider {

        @Override
        public @NotNull UUID provide(EntityType entityType) {
            return UUID.randomUUID();
        }
    }

}
