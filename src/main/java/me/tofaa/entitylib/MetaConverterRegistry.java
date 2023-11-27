package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
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

import static com.github.retrooper.packetevents.protocol.entity.type.EntityTypes.*;

final class MetaConverterRegistry {

    private final Map<EntityType, BiFunction<Integer, Metadata, EntityMeta>> converters = new HashMap<>();

    MetaConverterRegistry() {
        put(PLAYER, PlayerMeta::new);
        put(THROWN_EXP_BOTTLE, ThrownExpBottleMeta::new);
        put(EGG, ThrownEggMeta::new);
        put(TRIDENT, ThrownTridentMeta::new);
        put(POTION, ThrownTridentMeta::new);
        put(SMALL_FIREBALL, SmallFireballMeta::new);
        put(PIG, PigMeta::new);
        put(COW, CowMeta::new);
        put(CHICKEN, ChickenMeta::new);
        put(BEE, BeeMeta::new);
        put(TURTLE, TurtleMeta::new);
        put(DONKEY, DonkeyMeta::new);
        put(SHEEP, SheepMeta::new);
        put(RABBIT, RabbitMeta::new);
        put(POLAR_BEAR, PolarBearMeta::new);
        put(OCELOT, OcelotMeta::new );
        put(PANDA, PandaMeta::new);
        put(STRIDER, StriderMeta::new);
        put(FOX, FoxMeta::new);
        put(FROG, FrogMeta::new);
    }

    private void put(EntityType entityType, BiFunction<Integer, Metadata, EntityMeta> function) {
        converters.put(entityType, function);
    }

    public @Nullable BiFunction<Integer, Metadata, EntityMeta> get(EntityType entityType) {
        return converters.get(entityType);
    }

}
