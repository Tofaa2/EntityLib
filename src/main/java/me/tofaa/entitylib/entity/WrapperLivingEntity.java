package me.tofaa.entitylib.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityStatus;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.types.LivingEntityMeta;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WrapperLivingEntity extends WrapperEntity{

    private final WrapperEntityEquipment equipment;
    private float maxHealth;

    public WrapperLivingEntity(int entityId, @NotNull UUID uuid, EntityType entityType, EntityMeta meta) {
        super(entityId, uuid, entityType, meta);
        this.equipment = new WrapperEntityEquipment(this);
    }


    public void kill() {
        sendStatus((byte) 3);
        setHealth(0);
        this.velocity = Vector3d.zero();
    }

    public void sendStatus(byte status) {
        sendPacketsToViewers(new WrapperPlayServerEntityStatus(getEntityId(), status));
    }

    public float getHealth() {
        return getMeta().getHealth();
    }

    public void setHealth(float health) {
        getMeta().setHealth(Math.min(Math.max(health, 0), getMaxHealth()));
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public WrapperEntityEquipment getEquipment() {
        return equipment;
    }

    @Override
    public LivingEntityMeta getMeta() {
        return (LivingEntityMeta) super.getMeta();
    }
}
