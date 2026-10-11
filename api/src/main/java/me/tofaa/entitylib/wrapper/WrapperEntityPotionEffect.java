package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.potion.PotionType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityEffect;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerRemoveEntityEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WrapperEntityPotionEffect {
    private final WrapperLivingEntity entity;
    private final Map<PotionType, WrapperPotionEffect> effects = new ConcurrentHashMap<>();

    private boolean notifyChanges = true;

    public WrapperEntityPotionEffect(WrapperLivingEntity entity) {
        this.entity = entity;
    }

    public void addPotionEffect(
            PotionType type,
            int amplifier,
            int duration,
            boolean ambient,
            boolean visible,
            boolean showIcons,
            @Nullable NBTCompound factorData
    ) {
        WrapperPotionEffect effect = new WrapperPotionEffect(type, amplifier, duration, ambient, visible, showIcons, factorData);

        this.effects.put(type, effect);

        this.entity.sendPacketToViewersIfSpawned(createEffectPacket(effect));
    }

    public void addPotionEffect(
            PotionType type,
            int amplifier,
            int duration,
            byte flags,
            @Nullable NBTCompound factorData
    ) {
        BitSet flagsBitSet = BitSet.valueOf(new byte[]{flags});

        boolean ambient = flagsBitSet.get(0);
        boolean visible = flagsBitSet.get(1);
        boolean icons = flagsBitSet.get(2);

        addPotionEffect(type, amplifier, duration, ambient, visible, icons, factorData);
    }

    public void addPotionEffect(
            PotionType type,
            int amplifier,
            int duration,
            byte flags,
            boolean hasFactorData,
            @Nullable NBTCompound factorData
    ) {
        addPotionEffect(type, amplifier, duration, flags, hasFactorData ? factorData : null);
    }

    public void addPotionEffect(
            PotionType type,
            int amplifier,
            int duration,
            byte flags
    ) {
        addPotionEffect(type, amplifier, duration, flags, false, null);
    }

    public void removePotionEffect(@NotNull PotionType potionType) {
        if (this.effects.remove(potionType) != null) {
            this.entity.sendPacketToViewersIfSpawned(createRemoveEffectPacket(potionType));
        }
    }

    public void clearPotionEffects() {
        new ArrayList<>(this.effects.keySet()).forEach(this::removePotionEffect);
    }

    public @NotNull List<WrapperPlayServerEntityEffect> createEffectPackets() {
        List<WrapperPlayServerEntityEffect> packets = new ArrayList<>();

        this.effects.forEach((potionType, effect) -> packets.add(createEffectPacket(effect)));

        return packets;
    }

    public @NotNull WrapperPlayServerEntityEffect createEffectPacket(@NotNull WrapperPotionEffect effect) {
        PotionType potionType = effect.getPotionType();
        int amplifier = effect.getAmplifier();
        int duration = effect.getDuration();
        boolean ambient = effect.isAmbient();
        boolean visible = effect.isVisible();
        boolean icons = effect.hasIcons();
        NBTCompound factorData = effect.getFactorData();

        int flags = 0;

        flags |= ambient ? 1 : 0;
        flags |= visible ? (1 << 1) : 0;
        flags |= icons ? (1 << 2) : 0;

        WrapperPlayServerEntityEffect wrapperPlayServerEntityEffect = new WrapperPlayServerEntityEffect(
                0,
                null,
                0,
                0,
                (byte) flags
        );

        wrapperPlayServerEntityEffect.setEntityId(this.entity.getEntityId());
        wrapperPlayServerEntityEffect.setPotionType(potionType);
        wrapperPlayServerEntityEffect.setEffectAmplifier(amplifier);
        wrapperPlayServerEntityEffect.setEffectDurationTicks(duration);
        wrapperPlayServerEntityEffect.setFactorData(factorData);

        return wrapperPlayServerEntityEffect;
    }

    public @NotNull WrapperPlayServerRemoveEntityEffect createRemoveEffectPacket(@NotNull PotionType potionType) {
        return new WrapperPlayServerRemoveEntityEffect(this.entity.getEntityId(), potionType);
    }

    public void refresh() {
        if (notifyChanges) {
            new ArrayList<>(this.effects.values()).forEach(effect -> {
                WrapperPlayServerEntityEffect wrapperPlayServerEntityEffect = createEffectPacket(effect);

                this.entity.sendPacketToViewersIfSpawned(wrapperPlayServerEntityEffect);
            });
        }
    }

    public boolean isNotifyingChanges() {
        return notifyChanges;
    }

    public void setNotifyChanges(boolean notifyChanges) {
        this.notifyChanges = notifyChanges;
        refresh();
    }

    public static class WrapperPotionEffect {
        private final PotionType potionType;
        private final int amplifier;
        private final int duration;
        private final boolean ambient;
        private final boolean visible;
        private final boolean icons;
        private final @Nullable NBTCompound factorData;

        private WrapperPotionEffect(PotionType potionType, int amplifier, int duration, boolean ambient, boolean visible, boolean icons, @Nullable NBTCompound factorData) {
            this.potionType = potionType;
            this.amplifier = amplifier;
            this.duration = duration;
            this.ambient = ambient;
            this.visible = visible;
            this.icons = icons;
            this.factorData = factorData;
        }

        public PotionType getPotionType() {
            return potionType;
        }

        public int getAmplifier() {
            return amplifier;
        }

        public int getDuration() {
            return duration;
        }

        public boolean isAmbient() {
            return ambient;
        }

        public boolean isVisible() {
            return visible;
        }

        public boolean hasIcons() {
            return icons;
        }

        public @Nullable NBTCompound getFactorData() {
            return factorData;
        }
    }
}
