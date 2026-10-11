package me.tofaa.entitylib.bb.render;

import me.tofaa.entitylib.bb.model.BBCube;
import me.tofaa.entitylib.bb.model.BBFace;
import me.tofaa.entitylib.bb.model.BBGroup;
import me.tofaa.entitylib.bb.model.BBModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public final class BBSkin {

    private record Rule(Predicate<BBCube> predicate, BBMaterial material) {
    }

    private final Map<UUID, BBMaterial> bonesById;
    private final Map<String, BBMaterial> bonesByName;
    private final Map<UUID, BBMaterial> cubesById;
    private final Map<String, BBMaterial> cubesByName;
    private final Map<Integer, BBMaterial> texturesByIndex;
    private final Map<String, BBMaterial> texturesByName;
    private final List<Rule> rules;
    private final BBMaterial fallback;

    private BBSkin(Builder builder) {
        this.bonesById = Map.copyOf(builder.bonesById);
        this.bonesByName = Map.copyOf(builder.bonesByName);
        this.cubesById = Map.copyOf(builder.cubesById);
        this.cubesByName = Map.copyOf(builder.cubesByName);
        this.texturesByIndex = Map.copyOf(builder.texturesByIndex);
        this.texturesByName = Map.copyOf(builder.texturesByName);
        this.rules = List.copyOf(builder.rules);
        this.fallback = builder.fallback;
    }

    public static @NotNull Builder builder() {
        return new Builder();
    }

    public static @NotNull BBSkin palette() {
        return builder().build();
    }

    public static @NotNull BBSkin palette(@NotNull BlockPalette palette) {
        return builder().fallback(BBMaterial.palette(palette)).build();
    }

    public @Nullable BBMaterial bone(@NotNull BBGroup bone) {
        BBMaterial material = bonesById.get(bone.uuid());
        return material != null ? material : bonesByName.get(bone.name());
    }

    public @NotNull BBMaterial cube(@NotNull BBModel model, @NotNull BBCube cube) {
        BBMaterial material = cubesById.get(cube.uuid());
        if (material == null) {
            material = cubesByName.get(cube.name());
        }
        if (material != null) {
            return material;
        }
        for (Rule rule : rules) {
            if (rule.predicate.test(cube)) {
                return rule.material;
            }
        }
        for (BBFace face : cube.faces()) {
            if (!face.hasTexture()) {
                continue;
            }
            material = texturesByIndex.get(face.texture());
            if (material == null && face.texture() < model.textures().size()) {
                material = texturesByName.get(model.textures().get(face.texture()).name());
            }
            if (material != null) {
                return material;
            }
        }
        return fallback;
    }

    public static final class Builder {

        private final Map<UUID, BBMaterial> bonesById = new HashMap<>();
        private final Map<String, BBMaterial> bonesByName = new HashMap<>();
        private final Map<UUID, BBMaterial> cubesById = new HashMap<>();
        private final Map<String, BBMaterial> cubesByName = new HashMap<>();
        private final Map<Integer, BBMaterial> texturesByIndex = new HashMap<>();
        private final Map<String, BBMaterial> texturesByName = new HashMap<>();
        private final List<Rule> rules = new ArrayList<>();
        private BBMaterial fallback = BBMaterial.palette(BlockPalette.defaults());

        private Builder() {
        }

        public @NotNull Builder bone(@NotNull String name, @NotNull BBMaterial material) {
            bonesByName.put(name, material);
            return this;
        }

        public @NotNull Builder bone(@NotNull UUID uuid, @NotNull BBMaterial material) {
            bonesById.put(uuid, material);
            return this;
        }

        public @NotNull Builder cube(@NotNull String name, @NotNull BBMaterial material) {
            cubesByName.put(name, material);
            return this;
        }

        public @NotNull Builder cube(@NotNull UUID uuid, @NotNull BBMaterial material) {
            cubesById.put(uuid, material);
            return this;
        }

        public @NotNull Builder texture(@NotNull String textureName, @NotNull BBMaterial material) {
            texturesByName.put(textureName, material);
            return this;
        }

        public @NotNull Builder texture(int textureIndex, @NotNull BBMaterial material) {
            texturesByIndex.put(textureIndex, material);
            return this;
        }

        public @NotNull Builder rule(@NotNull Predicate<BBCube> predicate, @NotNull BBMaterial material) {
            rules.add(new Rule(predicate, material));
            return this;
        }

        public @NotNull Builder fallback(@NotNull BBMaterial material) {
            this.fallback = material;
            return this;
        }

        public @NotNull BBSkin build() {
            return new BBSkin(this);
        }

    }

}
