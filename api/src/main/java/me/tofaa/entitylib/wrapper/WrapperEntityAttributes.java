package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.attribute.Attribute;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateAttributes;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public final class WrapperEntityAttributes {


    public static final WrapperPlayServerUpdateAttributes.PropertyModifier.Operation ADDITION = WrapperPlayServerUpdateAttributes.PropertyModifier.Operation.ADDITION;
    public static final WrapperPlayServerUpdateAttributes.PropertyModifier.Operation MULTIPLY_BASE = WrapperPlayServerUpdateAttributes.PropertyModifier.Operation.MULTIPLY_BASE;
    public static final WrapperPlayServerUpdateAttributes.PropertyModifier.Operation MULTIPLY_TOTAL = WrapperPlayServerUpdateAttributes.PropertyModifier.Operation.MULTIPLY_TOTAL;

    private final WrapperEntity entity;
    private final List<WrapperPlayServerUpdateAttributes.Property> properties;

    public WrapperEntityAttributes(WrapperEntity entity) {
        this.entity = entity;
        this.properties = new CopyOnWriteArrayList<>();
    }

    public void setAttribute(Attribute attribute, double value, List<WrapperPlayServerUpdateAttributes.PropertyModifier> modifiers) {
        this.properties.stream()
                .filter(property -> property.getAttribute() == attribute)
                .findFirst().ifPresent(properties::remove);
        this.properties.add(new WrapperPlayServerUpdateAttributes.Property(attribute, value, modifiers));
        refresh();
    }

    public void setAttribute(Attribute attribute, double value, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        setAttribute(attribute, value, Collections.singletonList(modifier));
    }

    public void setAttribute(Attribute attribute, double value) {
        setAttribute(attribute, value, Collections.emptyList());
    }

    public List<WrapperPlayServerUpdateAttributes.Property> getProperties() {
        return new ArrayList<>(properties);
    }

    public void forEach(Consumer<WrapperPlayServerUpdateAttributes.Property> action) {
        properties.forEach(action);
    }

    public void clear() {
        properties.clear();
        refresh();
    }

    public void removeAttribute(Attribute attribute, WrapperPlayServerUpdateAttributes.PropertyModifier modifier) {
        this.properties.stream()
                .filter(property -> property.getAttribute() == attribute)
                .findFirst().ifPresent(property -> {
                    property.getModifiers().remove(modifier);
                    if (property.getModifiers().isEmpty()) {
                        properties.remove(property);
                    }
                });
        refresh();
    }

    public void removeAttribute(Attribute attribute) {
        this.properties.stream()
                .filter(property -> property.getAttribute() == attribute)
                .findFirst().ifPresent(properties::remove);
        refresh();
    }


    public void refresh() {
        entity.sendPacketToViewers(createPacket());
    }

    public WrapperPlayServerUpdateAttributes createPacket() {
        return new WrapperPlayServerUpdateAttributes(entity.getEntityId(), properties);
    }

}
