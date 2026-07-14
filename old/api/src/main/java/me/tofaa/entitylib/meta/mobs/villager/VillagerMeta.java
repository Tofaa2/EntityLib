package me.tofaa.entitylib.meta.mobs.villager;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.villager.VillagerData;
import com.github.retrooper.packetevents.protocol.entity.villager.profession.VillagerProfession;
import com.github.retrooper.packetevents.protocol.entity.villager.profession.VillagerProfessions;
import com.github.retrooper.packetevents.protocol.entity.villager.type.VillagerType;
import com.github.retrooper.packetevents.protocol.entity.villager.type.VillagerTypes;
import me.tofaa.entitylib.meta.Metadata;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class VillagerMeta extends BaseVillagerMeta {

    public static final byte OFFSET = BaseVillagerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    @ApiStatus.Internal
    public static final VillagerType[] TYPES = new VillagerType[] {
            VillagerTypes.DESERT,
            VillagerTypes.JUNGLE,
            VillagerTypes.PLAINS,
            VillagerTypes.SAVANNA,
            VillagerTypes.SNOW,
            VillagerTypes.SWAMP,
            VillagerTypes.TAIGA
    };

    @ApiStatus.Internal
    public static final VillagerProfession[] PROFESSIONS = new VillagerProfession[] {
            VillagerProfessions.NONE,
            VillagerProfessions.ARMORER,
            VillagerProfessions.BUTCHER,
            VillagerProfessions.CARTOGRAPHER,
            VillagerProfessions.CLERIC,
            VillagerProfessions.FARMER,
            VillagerProfessions.FISHERMAN,
            VillagerProfessions.FLETCHER,
            VillagerProfessions.LEATHERWORKER,
            VillagerProfessions.LIBRARIAN,
            VillagerProfessions.MASON,
            VillagerProfessions.NITWIT,
            VillagerProfessions.SHEPHERD,
            VillagerProfessions.TOOLSMITH,
            VillagerProfessions.WEAPONSMITH
    };

    public VillagerMeta(int entityId, Metadata metadata) {
        super(entityId, metadata);
    }

    @NotNull
    public VillagerData getVillagerData() {
        int[] data = super.metadata.getIndex(OFFSET, null);
        if (data == null) {
            return new VillagerData(VillagerTypes.PLAINS, VillagerProfessions.NONE, Level.NOVICE.ordinal());
        }
        return new VillagerData(TYPES[data[0]], PROFESSIONS[data[1]], Level.VALUES[data[2] - 1].ordinal());
    }

    public void setVillagerData(@NotNull VillagerData data) {
        super.metadata.setIndex(OFFSET, EntityDataTypes.VILLAGER_DATA, new VillagerData(
                data.getType().getId(),
                data.getProfession().getId(),
                data.getLevel()
        ));
    }


    public enum Level {
        NOVICE,
        APPRENTICE,
        JOURNEYMAN,
        EXPERT,
        MASTER;

        public final static Level[] VALUES = values();
    }


}
