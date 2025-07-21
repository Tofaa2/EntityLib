package me.tofaa.entitylib.utils;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import me.tofaa.entitylib.EntityLib;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.translation.GlobalTranslator;

public class PacketUtil {
    private PacketUtil() {
    }

    public static void renderPacket(UUID user, WrapperPlayServerEntityMetadata metadata) {
        Locale locale = EntityLib.getApi().getUserLocaleProvider().locale(user);
        for (final EntityData<?> entityData : metadata.getEntityMetadata()) {
            if (entityData.getType() == EntityDataTypes.ADV_COMPONENT) {
                Component component = (Component) entityData.getValue();
                final Component rendered = GlobalTranslator.render(component, locale);
                ((EntityData<Component>) entityData).setValue(rendered);
            } else if (entityData.getType() == EntityDataTypes.OPTIONAL_ADV_COMPONENT) {
                final Optional<Component> optional = (Optional<Component>) entityData.getValue();
                if (optional.isPresent()) {
                    final Component component = optional.get();
                    final Component rendered = GlobalTranslator.render(component, locale);
                    ((EntityData<Optional<Component>>) entityData).setValue(Optional.of(rendered));
                }
            }
        }
    }
}
