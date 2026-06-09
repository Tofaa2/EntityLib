// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariant;
import me.tofaa.entitylib.meta.EntityDataKey;

/**
 * Supported versions: All versions
 */
public class PaintingDataKeys extends HangingEntityDataKeys {

    /**
     * Supported versions: 1.19+
     */
    public static final EntityDataKey<PaintingVariant> PAINTING_VARIANT = EntityDataKey.<PaintingVariant>builder(PaintingDataKeys.class)
            .addVersion(ClientVersion.V_1_19, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_19_1, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_19_3, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_19_4, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_20_2, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_20_3, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_20_5, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21_2, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21_4, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21_5, 8, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 9, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 9, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 9, EntityDataTypes.PAINTING_VARIANT)
            .addVersion(ClientVersion.V_26_1, 9, EntityDataTypes.PAINTING_VARIANT)
            .build();

}
