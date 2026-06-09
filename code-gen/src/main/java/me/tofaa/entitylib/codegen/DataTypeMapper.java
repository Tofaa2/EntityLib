package me.tofaa.entitylib.codegen;

import com.github.retrooper.packetevents.protocol.component.builtin.item.ItemProfile;
import com.github.retrooper.packetevents.protocol.entity.armadillo.ArmadilloState;
import com.github.retrooper.packetevents.protocol.entity.cat.CatSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cat.CatVariant;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariant;
import com.github.retrooper.packetevents.protocol.entity.data.struct.CopperGolemState;
import com.github.retrooper.packetevents.protocol.entity.data.struct.WeatheringCopperState;
import com.github.retrooper.packetevents.protocol.entity.frog.FrogVariant;
import com.github.retrooper.packetevents.protocol.entity.nautilus.ZombieNautilusVariant;
import com.github.retrooper.packetevents.protocol.entity.pig.PigSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.pig.PigVariant;
import com.github.retrooper.packetevents.protocol.entity.pose.EntityPose;
import com.github.retrooper.packetevents.protocol.entity.sniffer.SnifferState;
import com.github.retrooper.packetevents.protocol.entity.villager.VillagerData;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariant;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.particle.Particle;
import com.github.retrooper.packetevents.protocol.player.HumanoidArm;
import com.github.retrooper.packetevents.protocol.world.BlockFace;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariant;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.util.Vector3i;
import net.kyori.adventure.text.Component;

import java.util.*;

public class DataTypeMapper {

    public TypeMapping mapDataType(String rawDataType) {
        return switch (rawDataType) {
            // java lang
            case "Byte" -> new TypeMapping(new TypeToken("Byte", Byte.class), "BYTE");
            case "Integer" -> new TypeMapping(new TypeToken("Integer", Integer.class), "INT");
            case "Float" -> new TypeMapping(new TypeToken("Float", Float.class), "FLOAT");
            case "Long" -> new TypeMapping(new TypeToken("Long", Long.class), "LONG");
            case "Boolean" -> new TypeMapping(new TypeToken("Boolean", Boolean.class), "BOOLEAN");
            case "String" -> new TypeMapping(new TypeToken("String", String.class), "STRING");
            // regular UUID is not used anywhere in the regular protocol, that surprised me damn
            case "Optional<UUID>" ->
                    new TypeMapping(new TypeToken("Optional<UUID>", Optional.class, UUID.class), "OPTIONAL_UUID");
            case "OptionalInt" /*old mojang wtf*/, "Optional<Integer>" ->
                    new TypeMapping(new TypeToken("Optional<Integer>", Optional.class, Integer.class), "OPTIONAL_INT");

            // adventure
            case "Component" ->
                    new TypeMapping(new TypeToken("Component", Component.class), "ADV_COMPONENT");
            case "Optional<Component>" ->
                    new TypeMapping(new TypeToken("Optional<Component>", Optional.class, Component.class), "OPTIONAL_ADV_COMPONENT");

            // misc
            case "ParticleOptions" ->
                    new TypeMapping(new TypeToken("Particle<?>", Particle.class), "PARTICLE");
            case "List<ParticleOptions>" ->
                    new TypeMapping(new TypeToken("List<Particle<?>>", List.class, Particle.class), "PARTICLES");
            case "Pose" -> new TypeMapping(new TypeToken("EntityPose", EntityPose.class), "ENTITY_POSE");
            case "BlockState", "Optional<BlockState>" ->
                    new TypeMapping(new TypeToken("Integer", Integer.class), rawDataType.contains("Optional") ? "OPTIONAL_BLOCK_STATE" : "BLOCK_STATE");
            case "ResolvableProfile" ->
                    new TypeMapping(new TypeToken("ItemProfile", ItemProfile.class), "RESOLVABLE_PROFILE");
            case "CompoundTag" -> new TypeMapping(new TypeToken("NBTCompound", NBTCompound.class), "NBT");
            case "ItemStack" -> new TypeMapping(new TypeToken("ItemStack", ItemStack.class), "ITEMSTACK");
            case "Optional<EntityReference<LivingEntity>>" ->
                    new TypeMapping(new TypeToken("Optional<UUID>", Optional.class, UUID.class), "OPTIONAL_UUID");

            // math
            case "Rotations", "Vector3f", "Vector3fc" ->
                    new TypeMapping(new TypeToken("Vector3f", Vector3f.class), "VECTOR3F");
            case "BlockPos" ->
                    new TypeMapping(new TypeToken("Vector3i", Vector3i.class), "BLOCK_POSITION");
            case "Optional<BlockPos>" ->
                    new TypeMapping(new TypeToken("Optional<Vector3i>", Optional.class, Vector3i.class), "OPTIONAL_BLOCK_POSITION");
            case "Quaternionf", "Quaternionfc" ->
                    new TypeMapping(new TypeToken("Quaternion4f", Quaternion4f.class), "QUATERNION");

            // entity specific
            case "Sniffer.State" ->
                    new TypeMapping(new TypeToken("SnifferState", SnifferState.class), "SNIFFER_STATE");
            case "VillagerData" ->
                    new TypeMapping(new TypeToken("VillagerData", VillagerData.class), "VILLAGER_DATA");
            case "HumanoidArm" ->
                    new TypeMapping(new TypeToken("HumanoidArm", HumanoidArm.class), "HUMANOID_ARM");
            case "Direction" ->
                    new TypeMapping(new TypeToken("BlockFace", BlockFace.class), "BLOCK_FACE");
            case "CopperGolemState" ->
                    new TypeMapping(new TypeToken("CopperGolemState", CopperGolemState.class), "COPPER_GOLEM_STATE");
            case "WeatheringCopper.WeatherState" ->
                    new TypeMapping(new TypeToken("WeatheringCopperState", WeatheringCopperState.class), "WEATHERING_COPPER_STATE");
            case "Armadillo.ArmadilloState" ->
                    new TypeMapping(new TypeToken("ArmadilloState", ArmadilloState.class), "ARMADILLO_STATE");

            // entity variants
            case "FrogVariant", "Holder<FrogVariant>" ->
                    new TypeMapping(new TypeToken("FrogVariant", FrogVariant.class), "TYPED_FROG_VARIANT");
            case "CatVariant", "Holder<CatVariant>" ->
                    new TypeMapping(new TypeToken("CatVariant", CatVariant.class), "TYPED_CAT_VARIANT");
            case "Holder<ChickenVariant>" ->
                    new TypeMapping(new TypeToken("ChickenVariant", ChickenVariant.class), "CHICKEN_VARIANT");
            case "Holder<CowVariant>" ->
                    new TypeMapping(new TypeToken("CowVariant", CowVariant.class), "COW_VARIANT");
            case "Holder<PaintingVariant>" ->
                    new TypeMapping(new TypeToken("PaintingVariant", PaintingVariant.class), "PAINTING_VARIANT");
            case "Holder<PigVariant>" ->
                    new TypeMapping(new TypeToken("PigVariant", PigVariant.class), "PIG_VARIANT");
            case "Holder<WolfVariant>" ->
                    new TypeMapping(new TypeToken("WolfVariant", WolfVariant.class), "TYPED_WOLF_VARIANT");
            case "Holder<ZombieNautilusVariant>" ->
                    new TypeMapping(new TypeToken("ZombieNautilusVariant", ZombieNautilusVariant.class), "ZOMBIE_NAUTILUS_VARIANT");

            // sound variants
            case "Holder<WolfSoundVariant>" ->
                    new TypeMapping(new TypeToken("WolfSoundVariant", WolfSoundVariant.class), "WOLF_SOUND_VARIANT");
            case "Holder<CatSoundVariant>" ->
                    new TypeMapping(new TypeToken("CatSoundVariant", CatSoundVariant.class), "CAT_SOUND_VARIANT");
            case "Holder<PigSoundVariant>" ->
                    new TypeMapping(new TypeToken("PigSoundVariant", PigSoundVariant.class), "PIG_SOUND_VARIANT");
            case "Holder<ChickenSoundVariant>" ->
                    new TypeMapping(new TypeToken("ChickenSoundVariant", ChickenSoundVariant.class), "CHICKEN_SOUND_VARIANT");
            case "Holder<CowSoundVariant>" ->
                    new TypeMapping(new TypeToken("CowSoundVariant", CowSoundVariant.class), "COW_SOUND_VARIANT");

            default -> new TypeMapping(new TypeToken("Object", Object.class), null, true);
        };
    }
}