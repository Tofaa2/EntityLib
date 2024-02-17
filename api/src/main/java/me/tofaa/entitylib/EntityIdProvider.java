package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a int provider that gives an id for each entity created. When using EntityLib with platform specific entities (Such as bukkit entities), make sure the id's do not
 * conflict with the platform's entity id's.
 * {@link DefaultEntityIdProvider} is a default implementation of this interface.
 */
public interface EntityIdProvider {

    int provide(@NotNull UUID entityUUID, @NotNull EntityType entityType);

    class DefaultEntityIdProvider implements EntityIdProvider {

        private final AtomicInteger integer = new AtomicInteger(100000);

        @Override
        public int provide(@NotNull UUID entityUUID, @NotNull EntityType entityType) {
            return integer.incrementAndGet();
        }
    }

}
