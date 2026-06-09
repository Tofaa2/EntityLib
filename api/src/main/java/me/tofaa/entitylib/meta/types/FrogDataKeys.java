// Auto-generated file. Do not edit manually.
package me.tofaa.entitylib.meta.types;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.frog.FrogVariant;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import me.tofaa.entitylib.meta.EntityDataKey;

import java.util.Optional;

/**
 * Supported versions: 1.19+
 */
public class FrogDataKeys extends AnimalDataKeys {

    /**
     * Supported versions: 1.19+
     */
    public static final EntityDataKey<Optional<Integer>> TONGUE_TARGET = EntityDataKey.<Optional<Integer>>builder(FrogDataKeys.class)
            .addVersion(ClientVersion.V_1_19, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_19_1, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_19_3, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_19_4, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_20_2, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_20_3, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_20_5, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_2, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_4, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_5, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_6, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_9, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_1_21_11, 18, EntityDataTypes.OPTIONAL_INT)
            .addVersion(ClientVersion.V_26_1, 19, EntityDataTypes.OPTIONAL_INT)
            .build();

    /**
     * Supported versions: 1.19+
     */
    public static final EntityDataKey<FrogVariant> VARIANT = EntityDataKey.<FrogVariant>builder(FrogDataKeys.class)
            // TODO type changed from 'FrogVariant' to 'Holder<FrogVariant>', converter required
            // TODO type changed from 'FrogVariant' to 'Holder<FrogVariant>', converter required
            // TODO type changed from 'FrogVariant' to 'Holder<FrogVariant>', converter required
            // TODO type changed from 'FrogVariant' to 'Holder<FrogVariant>', converter required
            // TODO type changed from 'FrogVariant' to 'Holder<FrogVariant>', converter required
            // TODO type changed from 'FrogVariant' to 'Holder<FrogVariant>', converter required
            .addVersion(ClientVersion.V_1_20_5, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21_2, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21_4, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21_5, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21_6, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21_9, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_1_21_11, 17, EntityDataTypes.TYPED_FROG_VARIANT)
            .addVersion(ClientVersion.V_26_1, 18, EntityDataTypes.TYPED_FROG_VARIANT)
            .build();

}
