package me.tofaa.entitylib.codegen;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

import java.util.LinkedHashMap;
import java.util.Map;

public final class TypeMapper {

    private static final Map<String, TypeInfo> TYPES = new LinkedHashMap<>();
    private static final TypeName OBJECT = ClassName.get("java.lang", "Object");

    static {
        add("Byte", ClassName.get("java.lang", "Byte"), "BYTE");
        add("Integer", ClassName.get("java.lang", "Integer"), "INT");
        add("Boolean", ClassName.get("java.lang", "Boolean"), "BOOLEAN");
        add("Float", ClassName.get("java.lang", "Float"), "FLOAT");
        add("Short", ClassName.get("java.lang", "Short"), "SHORT");
        add("String", ClassName.get("java.lang", "String"), "STRING");
        add("Long", ClassName.get("java.lang", "Long"), "LONG");

        add("Component", OBJECT, "ADV_COMPONENT");
        add("Optional<Component>", OBJECT, "OPTIONAL_ADV_COMPONENT");

        add("Pose", OBJECT, "ENTITY_POSE");
        add("BlockPos", OBJECT, "BLOCK_POSITION");
        add("Optional<BlockPos>", OBJECT, "OPTIONAL_BLOCK_POSITION");
        add("Optional<UUID>", OBJECT, "OPTIONAL_UUID");

        add("ItemStack", OBJECT, "ITEMSTACK");
        add("BlockState", OBJECT, "BLOCK_STATE");

        add("Vector3f", OBJECT, "VECTOR3F");
        add("Quaternionf", OBJECT, "QUATERNION");

        add("Direction", OBJECT, "INT");
        add("ParticleOptions", OBJECT, "INT");
        add("List<ParticleOptions>", OBJECT, "INT");

        add("OptionalInt", OBJECT, "OPTIONAL_INT");
        add("CompoundTag", OBJECT, "NBT");
        add("VillagerData", OBJECT, "BYTE");

        add("Sniffer.State", OBJECT, "INT");
        add("Armadillo.ArmadilloState", OBJECT, "INT");
        add("Rotations", OBJECT, "ROTATION");
        add("Display.BillboardConstraints", OBJECT, "BYTE");
        add("ItemDisplayContext", OBJECT, "BYTE");
        add("EnderDragonPhase", OBJECT, "INT");
        add("Rabbit.Variant", OBJECT, "INT");
        add("Salmon.Variant", OBJECT, "INT");
        add("MushroomCow.Variant", OBJECT, "STRING");
    }

    private static void add(String kennyType, TypeName javaType, String dataTypeField) {
        TYPES.put(kennyType, new TypeInfo(javaType, dataTypeField));
    }

    public static TypeInfo map(String typeString) {
        TypeInfo mapped = TYPES.get(typeString);
        if (mapped != null) return mapped;

        if (typeString.contains("Optional<") || typeString.contains("Holder<") || typeString.contains("List<")) {
            return new TypeInfo(OBJECT, "INT");
        }

        return new TypeInfo(OBJECT, "BYTE");
    }

    public record TypeInfo(TypeName javaType, String dataTypeField) {}
}
