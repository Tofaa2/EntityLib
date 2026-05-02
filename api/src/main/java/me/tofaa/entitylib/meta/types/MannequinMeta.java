package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.component.builtin.item.ItemProfile;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import me.tofaa.entitylib.meta.Metadata;
import net.kyori.adventure.text.Component;

import java.util.Collections;
import java.util.Optional;

public class MannequinMeta extends AvatarMeta {

    public static final byte OFFSET = AvatarMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public MannequinMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
        isVersionNewer(ServerVersion.V_1_21_8);
    }

    public ItemProfile getProfile() {
        return super.metadata.getIndex(OFFSET, new ItemProfile(null, null, Collections.emptyList()));
    }

    public void setProfile(ItemProfile value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.RESOLVABLE_PROFILE, value);
    }

    public boolean getImmovable() {
        return super.metadata.getIndex(offset(OFFSET, 1), false);
    }

    public void setImmovable(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.BOOLEAN, value);
    }

    public Optional<Component> getDescription() {
        return super.metadata.getIndex(offset(OFFSET, 2), Optional.empty());
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public void setDescription(Optional<Component> value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.OPTIONAL_ADV_COMPONENT, value);
    }
}
