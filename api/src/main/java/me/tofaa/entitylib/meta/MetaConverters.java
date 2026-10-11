package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.Optional;
import java.util.UUID;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public final class MetaConverters {

    private MetaConverters() {
    }

    public static <E> MetaConverter<E, Byte> enumByte(ToIntFunction<E> id, IntFunction<E> byId) {
        return MetaConverter.of(value -> (byte) id.applyAsInt(value), wire -> byId.apply(wire));
    }

    public static <E> MetaConverter<E, Short> enumShort(ToIntFunction<E> id, IntFunction<E> byId) {
        return MetaConverter.of(value -> (short) id.applyAsInt(value), wire -> byId.apply(wire));
    }

    public static <E> MetaConverter<E, Integer> enumInt(ToIntFunction<E> id, IntFunction<E> byId) {
        return MetaConverter.of(id::applyAsInt, byId::apply);
    }

    public static final MetaConverter<HumanoidArm, Byte> HUMANOID_ARM_BYTE = MetaConverter.of(
            arm -> (byte) (arm == HumanoidArm.RIGHT ? 1 : 0),
            id -> id == 1 ? HumanoidArm.RIGHT : HumanoidArm.LEFT
    );

    public static final MetaConverter<Boolean, Byte> BOOLEAN_BYTE = MetaConverter.of(
            value -> (byte) (value ? 1 : 0),
            wire -> wire != 0
    );

    public static final MetaConverter<Boolean, Byte> BABY_AGE_BYTE = MetaConverter.of(
            baby -> (byte) (baby ? -1 : 0),
            age -> age < 0
    );

    public static final MetaConverter<Integer, Byte> INT_BYTE = MetaConverter.of(Integer::byteValue, Byte::intValue);

    public static final MetaConverter<Integer, Short> INT_SHORT = MetaConverter.of(Integer::shortValue, Short::intValue);

    public static final MetaConverter<Byte, Integer> BYTE_INT = MetaConverter.of(value -> value & 0xFF, Integer::byteValue);

    public static final MetaConverter<Optional<UUID>, String> OPTIONAL_UUID_STRING = MetaConverter.of(
            uuid -> uuid.map(UUID::toString).orElse(""),
            text -> {
                try {
                    return text.isEmpty() ? Optional.<UUID>empty() : Optional.of(UUID.fromString(text));
                } catch (IllegalArgumentException notAUuid) {
                    return Optional.<UUID>empty();
                }
            }
    );

    public static final MetaConverter<Component, String> COMPONENT_LEGACY_TEXT = MetaConverter.of(
            component -> LegacyComponentSerializer.legacySection().serialize(component),
            text -> LegacyComponentSerializer.legacySection().deserialize(text)
    );

    public static final MetaConverter<Optional<Component>, String> OPTIONAL_COMPONENT_LEGACY_TEXT = MetaConverter.of(
            name -> name.map(component -> LegacyComponentSerializer.legacySection().serialize(component)).orElse(""),
            text -> text.isEmpty()
                    ? Optional.<Component>empty()
                    : Optional.<Component>of(LegacyComponentSerializer.legacySection().deserialize(text))
    );

    public static final MetaConverter<ItemStack, Optional<ItemStack>> ITEM_STACK_OPTIONAL = MetaConverter.of(
            item -> item.isEmpty() ? Optional.<ItemStack>empty() : Optional.of(item),
            wire -> wire.orElse(ItemStack.EMPTY)
    );

    public static final MetaConverter<Optional<Integer>, Integer> OPTIONAL_INT_ZERO_ABSENT = MetaConverter.of(
            value -> value.orElse(0),
            wire -> wire == 0 ? Optional.<Integer>empty() : Optional.of(wire)
    );

    public static final MetaConverter<Integer, String> MOOSHROOM_TYPE_NAME = named("red", "brown");

    public static final MetaConverter<Integer, String> SALMON_TYPE_NAME = named("small", "medium", "large");

    private static MetaConverter<Integer, String> named(String... names) {
        return MetaConverter.of(
                id -> names[id < 0 || id >= names.length ? 0 : id],
                name -> {
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equals(name)) {
                            return i;
                        }
                    }
                    return 0;
                }
        );
    }
}
