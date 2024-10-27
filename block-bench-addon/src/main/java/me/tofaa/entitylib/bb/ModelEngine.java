package me.tofaa.entitylib.bb;

import com.github.retrooper.packetevents.protocol.component.ComponentTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemType;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.google.gson.*;
import me.tofaa.entitylib.bb.mql.MQLPoint;

import javax.json.JsonNumber;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Optional;

public final class ModelEngine {

    public final static HashMap<String, Vector3d> offsetMappings = new HashMap<>();
    public final static HashMap<String, Vector3d> diffMappings = new HashMap<>();
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final static HashMap<String, HashMap<String, ItemStack>> blockMappings = new HashMap<>();

    private static Path modelPath;
    private static ItemType modelMaterial = ItemTypes.MAGMA_CREAM;

    /**
     * Loads the model from the given path
     *
     * @param mappingsData mappings file created by model parser
     * @param modelPath    path of the models
     */
    public static void loadMappings(Reader mappingsData, Path modelPath) {
        JsonObject map = GSON.fromJson(mappingsData, JsonObject.class);
        ModelEngine.modelPath = modelPath;

        blockMappings.clear();
        offsetMappings.clear();
        diffMappings.clear();
        ModelLoader.clearCache();

        map.entrySet().forEach(entry -> {
            HashMap<String, ItemStack> keys = new HashMap<>();

            entry.getValue().getAsJsonObject()
                    .get("id")
                    .getAsJsonObject()
                    .entrySet()
                    .forEach(id -> keys.put(id.getKey(), generateBoneItem(id.getValue().getAsInt())));

            blockMappings.put(entry.getKey(), keys);
            offsetMappings.put(entry.getKey(), getPos(entry.getValue().getAsJsonObject().get("offset").getAsJsonArray()).orElse(Vector3d.zero()));
            diffMappings.put(entry.getKey(), getPos(entry.getValue().getAsJsonObject().get("diff").getAsJsonArray()).orElse(Vector3d.zero()));
        });
    }

    private static ItemStack generateBoneItem(int model_id) {
        return ItemStack.builder()
                .type(modelMaterial)
                .component(ComponentTypes.CUSTOM_MODEL_DATA, model_id)
                .build();
    }

    public static HashMap<String, ItemStack> getItems(String model, String name) {
        return blockMappings.get(model + "/" + name);
    }

    public static Path getGeoPath(String id) {
        return modelPath.resolve(id).resolve("model.geo.json");
    }

    public static Path getAnimationPath(String id) {
        return modelPath.resolve(id).resolve("model.animation.json");
    }

    public static Optional<Vector3d> getPos(JsonElement pivot) {
        if (pivot == null) return Optional.empty();
        else {
            JsonArray arr = pivot.getAsJsonArray();
            return Optional.of(new Vector3d(arr.get(0).getAsDouble(), arr.get(1).getAsDouble(), arr.get(2).getAsDouble()));
        }
    }

    public static Optional<MQLPoint> getMQLPos(JsonElement pivot) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (pivot == null) return Optional.empty();
        else if (pivot instanceof JsonObject) {
            JsonObject obj = (JsonObject) pivot;
            return Optional.of(new MQLPoint(obj));
        } else if (pivot instanceof JsonNumber) {
            JsonNumber num = (JsonNumber) pivot;
            return Optional.of(new MQLPoint(num.doubleValue(), num.doubleValue(), num.doubleValue()));
        } else {
            return Optional.empty();
        }
    }

    public static ItemType getModelMaterial() {
        return modelMaterial;
    }

    public static void setModelMaterial(ItemType modelMaterial) {
        ModelEngine.modelMaterial = modelMaterial;
    }

    public static Optional<MQLPoint> getMQLPos(JsonArray arr) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (arr == null) return Optional.empty();
        else {
            return Optional.of(new MQLPoint(arr));
        }
    }
}

