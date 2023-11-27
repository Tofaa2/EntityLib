package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.mobs.*;
import me.tofaa.entitylib.meta.projectile.SmallFireballMeta;
import me.tofaa.entitylib.meta.projectile.ThrownEggMeta;
import me.tofaa.entitylib.meta.projectile.ThrownExpBottleMeta;
import me.tofaa.entitylib.meta.projectile.ThrownTridentMeta;
import me.tofaa.entitylib.meta.types.PlayerMeta;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

final class MetaConverterRegistry {

    private final Map<EntityType, BiFunction<Integer, Metadata, EntityMeta>> converters = new HashMap<>();

    MetaConverterRegistry() {
        put(EntityTypes.PLAYER, PlayerMeta::new);
        put(EntityTypes.THROWN_EXP_BOTTLE, ThrownExpBottleMeta::new);
        put(EntityTypes.EGG, ThrownEggMeta::new);
        put(EntityTypes.TRIDENT, ThrownTridentMeta::new);
        put(EntityTypes.POTION, ThrownTridentMeta::new);
        put(EntityTypes.SMALL_FIREBALL, SmallFireballMeta::new);
        put(EntityTypes.PIG, PigMeta::new);
        put(EntityTypes.COW, CowMeta::new);
        put(EntityTypes.CHICKEN, ChickenMeta::new);
        put(EntityTypes.BEE, BeeMeta::new);
        put(EntityTypes.TURTLE, TurtleMeta::new);
        put(EntityTypes.DONKEY, DonkeyMeta::new);
        put(EntityTypes.SHEEP, SheepMeta::new);
    }

    private void put(EntityType entityType, BiFunction<Integer, Metadata, EntityMeta> function) {
        converters.put(entityType, function);
    }

    public @Nullable BiFunction<Integer, Metadata, EntityMeta> get(EntityType entityType) {
        return converters.get(entityType);
    }

}
