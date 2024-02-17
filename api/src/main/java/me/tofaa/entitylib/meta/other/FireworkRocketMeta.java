package me.tofaa.entitylib.meta.other;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import me.tofaa.entitylib.meta.EntityMeta;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.types.ProjectileMeta;

import java.util.Optional;

public class FireworkRocketMeta extends EntityMeta implements ProjectileMeta {

    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    private int shooter = -1;

    public FireworkRocketMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public ItemStack getFireworkItem() {
        return super.metadata.getIndex(OFFSET, ItemStack.EMPTY);
    }

    public void setFireworkItem(ItemStack value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.ITEMSTACK, value);
    }


    public boolean isShotAtAngle() {
        return super.metadata.getIndex(offset(OFFSET, 2), false);
    }

    public void setShotAtAngle(boolean value) {
        super.metadata.setIndex(offset(OFFSET, 2), EntityDataTypes.BOOLEAN, value);
    }

    @Override
    public int getShooter() {
        return shooter;
    }

    @Override
    public void setShooter(int entityId) {
        this.shooter = entityId;
        Optional<Integer> optional = Optional.ofNullable(entityId == -1 ? null : entityId);
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.OPTIONAL_INT, optional);
    }
}
