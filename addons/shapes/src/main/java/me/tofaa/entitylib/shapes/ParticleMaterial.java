package me.tofaa.entitylib.shapes;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.world.states.type.StateType;
import me.tofaa.entitylib.display.DisplayElement;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.enums.BillboardConstraints;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ParticleMaterial {

    @NotNull DisplayElement create();

    static @NotNull ParticleMaterial block(@NotNull StateType type) {
        return () -> DisplayElement.block(type);
    }

    static @NotNull ParticleMaterial item(@NotNull ItemStack item) {
        return () -> {
            DisplayElement element = DisplayElement.item(item);
            element.entity().getMetadata().set(MetaFields.Display.BILLBOARD_RENDER_CONSTRAINTS, BillboardConstraints.CENTER);
            return element;
        };
    }

    static @NotNull ParticleMaterial color(int rgb) {
        return glyph("■", rgb);
    }

    static @NotNull ParticleMaterial glyph(@NotNull String glyph, int rgb) {
        return () -> {
            DisplayElement element = DisplayElement.text(Component.text(glyph, TextColor.color(rgb)));
            Metadata metadata = element.entity().getMetadata();
            metadata.set(MetaFields.Display.BILLBOARD_RENDER_CONSTRAINTS, BillboardConstraints.CENTER);
            metadata.set(MetaFields.TextDisplay.BACKGROUND_COLOR, 0);
            return element;
        };
    }

}
