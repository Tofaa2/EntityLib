package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.mobs.*;
import me.tofaa.entitylib.meta.mobs.DonkeyMeta;
import me.tofaa.entitylib.meta.mobs.cuboid.MagmaCubeMeta;
import me.tofaa.entitylib.meta.mobs.cuboid.SlimeMeta;
import me.tofaa.entitylib.meta.mobs.golem.IronGolemMeta;
import me.tofaa.entitylib.meta.mobs.golem.ShulkerMeta;
import me.tofaa.entitylib.meta.mobs.golem.SnowGolemMeta;
import me.tofaa.entitylib.meta.mobs.horse.*;
import me.tofaa.entitylib.meta.mobs.monster.*;
import me.tofaa.entitylib.meta.mobs.monster.piglin.PiglinBruteMeta;
import me.tofaa.entitylib.meta.mobs.monster.piglin.PiglinMeta;
import me.tofaa.entitylib.meta.mobs.monster.raider.*;
import me.tofaa.entitylib.meta.mobs.monster.skeleton.SkeletonMeta;
import me.tofaa.entitylib.meta.mobs.monster.skeleton.StrayMeta;
import me.tofaa.entitylib.meta.mobs.monster.skeleton.WitherSkeletonMeta;
import me.tofaa.entitylib.meta.mobs.monster.zombie.*;
import me.tofaa.entitylib.meta.mobs.passive.*;
import me.tofaa.entitylib.meta.mobs.water.*;
import me.tofaa.entitylib.meta.mobs.minecart.*;
import me.tofaa.entitylib.meta.mobs.tameable.CatMeta;
import me.tofaa.entitylib.meta.mobs.tameable.ParrotMeta;
import me.tofaa.entitylib.meta.mobs.tameable.WolfMeta;
import me.tofaa.entitylib.meta.mobs.villager.VillagerMeta;
import me.tofaa.entitylib.meta.mobs.villager.WanderingTraderMeta;
import me.tofaa.entitylib.meta.other.*;
import me.tofaa.entitylib.meta.projectile.*;
import me.tofaa.entitylib.meta.types.PlayerMeta;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static com.github.retrooper.packetevents.protocol.entity.type.EntityTypes.*;

@SuppressWarnings("unchecked")
final class MetaConverterRegistry {

    private final Map<EntityType, BiFunction<Integer, Metadata, EntityMeta>> converters = new HashMap<>();
    private final Map<EntityType, Class<? extends EntityMeta>> metaClasses = new HashMap<>();

    MetaConverterRegistry() {
        put(SNIFFER, SnifferMeta.class, SnifferMeta::new);
        put(INTERACTION, InteractionMeta.class, InteractionMeta::new);
        put(BLOCK_DISPLAY, BlockDisplayMeta.class, BlockDisplayMeta::new);
        put(ITEM_DISPLAY, ItemDisplayMeta.class, ItemDisplayMeta::new);
        put(TEXT_DISPLAY, TextDisplayMeta.class, TextDisplayMeta::new);
        put(AREA_EFFECT_CLOUD, AreaEffectCloudMeta.class, AreaEffectCloudMeta::new);
        put(ARMOR_STAND, ArmorStandMeta.class, ArmorStandMeta::new);
        put(BOAT, BoatMeta.class, BoatMeta::new);
        put(DRAGON_FIREBALL, DragonFireballMeta.class, DragonFireballMeta::new);
        put(END_CRYSTAL, EndCrystalMeta.class, EndCrystalMeta::new);
        put(ENDER_DRAGON, EnderDragonMeta.class, EnderDragonMeta::new);
        put(EVOKER_FANGS, EvokerFangsMeta.class, EvokerFangsMeta::new);
        put(FALLING_BLOCK, FallingBlockMeta.class, FallingBlockMeta::new);
        put(FIREWORK_ROCKET, FireworkRocketMeta.class, FireworkRocketMeta::new);
        put(FISHING_BOBBER, FishingHookMeta.class, FishingHookMeta::new);
        put(GLOW_ITEM_FRAME, GlowItemFrameMeta.class, GlowItemFrameMeta::new);
        put(ITEM_FRAME, ItemFrameMeta.class, ItemFrameMeta::new);
        put(LEASH_KNOT, LeashKnotMeta.class, LeashKnotMeta::new);
        put(LIGHTNING_BOLT, LightningBoltMeta.class, LightningBoltMeta::new);
        put(LLAMA_SPIT, LlamaSpitMeta.class, LlamaSpitMeta::new);
        put(MARKER, MarkerMeta.class, MarkerMeta::new);
        put(PAINTING, PaintingMeta.class, PaintingMeta::new);
        put(PRIMED_TNT, PrimedTntMeta.class, PrimedTntMeta::new);
        put(WITHER_SKULL, WitherSkullMeta.class, WitherSkullMeta::new);
        put(ZOGLIN, ZoglinMeta.class, ZoglinMeta::new);
        put(WITHER, WitherMeta.class, WitherMeta::new);
        put(VEX, VexMeta.class, VexMeta::new);
        put(SPIDER, SpiderMeta.class, SpiderMeta::new);
        put(SILVERFISH, SilverfishMeta.class, SilverfishMeta::new);
        put(GUARDIAN, GuardianMeta.class, GuardianMeta::new);
        put(GIANT, GiantMeta.class, GiantMeta::new);
        put(ENDERMITE, EndermiteMeta.class, EndermiteMeta::new);
        put(ENDERMITE, EndermiteMeta.class, EndermiteMeta::new);
        put(ELDER_GUARDIAN, ElderGuardianMeta.class, ElderGuardianMeta::new);
        put(CREEPER, CreeperMeta.class, CreeperMeta::new);
        put(CAVE_SPIDER, CaveSpiderMeta.class, CaveSpiderMeta::new);
        put(BLAZE, BlazeMeta.class, BlazeMeta::new);
        put(PIGLIN, PiglinMeta.class, PiglinMeta::new);
        put(PIGLIN_BRUTE, PiglinBruteMeta.class, PiglinBruteMeta::new);
        put(EVOKER, EvokerMeta.class, EvokerMeta::new);
        put(ILLUSIONER, IllusionerMeta.class, IllusionerMeta::new);
        put(PILLAGER, PillagerMeta.class, PillagerMeta::new);
        put(RAVAGER, RavagerMeta.class, RavagerMeta::new);
        put(VINDICATOR, VindicatorMeta.class, VindicatorMeta::new);
        put(WITCH, WitchMeta.class, WitchMeta::new);
        put(SKELETON, SkeletonMeta.class, SkeletonMeta::new);
        put(STRAY, StrayMeta.class, StrayMeta::new);
        put(WITHER_SKELETON, WitherSkeletonMeta.class, WitherSkeletonMeta::new);
        put(DROWNED, DrownedMeta.class, DrownedMeta::new);
        put(HUSK, HuskMeta.class, HuskMeta::new);
        put(ZOMBIE, ZombieMeta.class, ZombieMeta::new);
        put(ZOMBIE_VILLAGER, ZombieVillagerMeta.class, ZombieVillagerMeta::new);
        put(ZOMBIFIED_PIGLIN, ZombifiedPiglinMeta.class, ZombifiedPiglinMeta::new);
        put(AXOLOTL, AxolotlMeta.class, AxolotlMeta::new);
        put(COD, CodMeta.class, CodMeta::new);
        put(DOLPHIN, DolphinMeta.class, DolphinMeta::new);
        put(GLOW_SQUID, GlowSquidMeta.class, GlowSquidMeta::new);
        put(PUFFERFISH, PufferFishMeta.class, PufferFishMeta::new);
        put(SALMON, SalmonMeta.class, SalmonMeta::new);
        put(TROPICAL_FISH, TropicalFishMeta.class, TropicalFishMeta::new);
        put(ARROW, ArrowMeta.class, ArrowMeta::new);
        put(VILLAGER, VillagerMeta.class, VillagerMeta::new);
        put(WANDERING_TRADER, WanderingTraderMeta.class, WanderingTraderMeta::new);
        put(CHEST_MINECART, ChestMinecartMeta.class, ChestMinecartMeta::new);
        put(COMMAND_BLOCK_MINECART, CommandBlockMinecartMeta.class, CommandBlockMinecartMeta::new);
        put(COMMAND_BLOCK_MINECART, CommandBlockMinecartMeta.class, CommandBlockMinecartMeta::new);
        put(FURNACE_MINECART, FurnaceMinecartMeta.class, FurnaceMinecartMeta::new);
        put(HOPPER_MINECART, FurnaceMinecartMeta.class, FurnaceMinecartMeta::new);
        put(SPAWNER_MINECART, SpawnerMinecartMeta.class, SpawnerMinecartMeta::new);
        put(TNT_MINECART, TntMinecartMeta.class, TntMinecartMeta::new);
        put(PLAYER, PlayerMeta.class, PlayerMeta::new);
        put(THROWN_EXP_BOTTLE, ThrownExpBottleMeta.class, ThrownExpBottleMeta::new);
        put(EGG, ThrownEggMeta.class, ThrownEggMeta::new);
        put(TRIDENT, ThrownTridentMeta.class, ThrownTridentMeta::new);
        put(POTION, ThrownTridentMeta.class, ThrownTridentMeta::new);
        put(SMALL_FIREBALL, SmallFireballMeta.class, SmallFireballMeta::new);
        put(PIG, PigMeta.class, PigMeta::new);
        put(COW, CowMeta.class, CowMeta::new);
        put(CHICKEN, ChickenMeta.class, ChickenMeta::new);
        put(BEE, BeeMeta.class, BeeMeta::new);
        put(TURTLE, TurtleMeta.class, TurtleMeta::new);
        put(DONKEY, DonkeyMeta.class, DonkeyMeta::new);
        put(SHEEP, SheepMeta.class, SheepMeta::new);
        put(RABBIT, RabbitMeta.class, RabbitMeta::new);
        put(POLAR_BEAR, PolarBearMeta.class, PolarBearMeta::new);
        put(OCELOT, OcelotMeta.class, OcelotMeta::new );
        put(PANDA, PandaMeta.class, PandaMeta::new);
        put(STRIDER, StriderMeta.class, StriderMeta::new);
        put(FOX, FoxMeta.class, FoxMeta::new);
        put(FROG, FrogMeta.class, FrogMeta::new);
        put(GOAT, GoatMeta.class, GoatMeta::new);
        put(HOGLIN, HoglinMeta.class, HoglinMeta::new);
        put(CAT, CatMeta.class, CatMeta::new);
        put(PARROT, ParrotMeta.class, ParrotMeta::new);
        put(WOLF, WolfMeta.class, WolfMeta::new);
        put(DONKEY, DonkeyMeta.class, DonkeyMeta::new);
        put(HORSE, HorseMeta.class, HorseMeta::new);
        put(LLAMA, LlamaMeta.class, LlamaMeta::new);
        put(MULE, MuleMeta.class, MuleMeta::new);
        put(SKELETON_HORSE, SkeletonHorseMeta.class, SkeletonHorseMeta::new);
        put(ZOMBIE_HORSE, ZombieHorseMeta.class, ZombieHorseMeta::new);
        put(SLIME, SlimeMeta.class, SlimeMeta::new);
        put(MAGMA_CUBE, MagmaCubeMeta.class, MagmaCubeMeta::new);
        put(SHULKER_BULLET, ShulkerBulletMeta.class, ShulkerBulletMeta::new);
        put(TRADER_LLAMA, TraderLlamaMeta.class, TraderLlamaMeta::new);
        put(BAT, BatMeta.class, BatMeta::new);
        put(IRON_GOLEM, IronGolemMeta.class, IronGolemMeta::new);
        put(SHULKER, ShulkerMeta.class, ShulkerMeta::new);
        put(SNOW_GOLEM, SnowGolemMeta.class, SnowGolemMeta::new);
    }

    private void put(EntityType entityType, Class<? extends EntityMeta> metaClass, BiFunction<Integer, Metadata, EntityMeta> function) {
        converters.put(entityType, function);
        metaClasses.put(entityType, metaClass);
    }

    public <T extends EntityMeta> Class<T> getMetaClass(EntityType entityType) {
        return (Class<T>) metaClasses.get(entityType);
    }

    public @NotNull BiFunction<Integer, Metadata, EntityMeta> get(EntityType entityType) {
        return converters.getOrDefault(entityType, EntityMeta::new);
    }

}
