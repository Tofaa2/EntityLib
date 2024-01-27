package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public interface EntityIdProvider {

    int provide(@NotNull UUID entityUUID, @NotNull EntityType entityType);

    class DefaultEntityIdProvider implements EntityIdProvider {

        private final AtomicInteger integer = new AtomicInteger();

        @Override
        public int provide(@NotNull UUID entityUUID, @NotNull EntityType entityType) {
            return integer.incrementAndGet();
        }
    }

}
