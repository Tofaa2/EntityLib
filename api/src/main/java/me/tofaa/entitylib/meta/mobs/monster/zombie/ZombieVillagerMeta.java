package me.tofaa.entitylib.meta.mobs.monster.zombie;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.villager.VillagerData;
import com.github.retrooper.packetevents.protocol.entity.villager.profession.VillagerProfessions;
import com.github.retrooper.packetevents.protocol.entity.villager.type.VillagerTypes;
import me.tofaa.entitylib.meta.Metadata;
import me.tofaa.entitylib.meta.mobs.villager.VillagerMeta;

public class ZombieVillagerMeta extends ZombieMeta {

    public static final byte OFFSET = ZombieMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public ZombieVillagerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    public boolean isConverting() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setConverting(boolean value) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.BOOLEAN, value);
    }

    public VillagerData getVillagerData() {
        int[] data = super.metadata.getIndex(offset(OFFSET, 1), null);
        if (data == null) {
            return new VillagerData(VillagerTypes.PLAINS, VillagerProfessions.NONE, VillagerMeta.Level.NOVICE.ordinal());
        }
        return new VillagerData(VillagerMeta.TYPES[data[0]], VillagerMeta.PROFESSIONS[data[1]], VillagerMeta.Level.VALUES[data[2] - 1].ordinal());
    }

    public void setVillagerData(VillagerData data) {
        super.metadata.setIndex(offset(OFFSET, 1), EntityDataTypes.VILLAGER_DATA, new VillagerData(
                data.getType().getId(),
                data.getProfession().getId(),
                data.getLevel() + 1
        ));
    }

}
