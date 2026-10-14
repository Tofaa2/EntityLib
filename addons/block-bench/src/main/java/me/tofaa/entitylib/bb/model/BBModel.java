package me.tofaa.entitylib.bb.model;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record BBModel(String name, String format, int resolutionWidth, int resolutionHeight, BBGroup root,
                      List<BBTexture> textures, Map<String, BBAnimation> animations) {

    public @Nullable BBAnimation animation(String name) {
        return animations.get(name);
    }

    public List<BBCube> cubes() {
        List<BBCube> cubes = new ArrayList<>();
        collect(root, cubes);
        return cubes;
    }

    private static void collect(BBGroup group, List<BBCube> cubes) {
        cubes.addAll(group.cubes());
        for (BBGroup child : group.groups()) {
            collect(child, cubes);
        }
    }

}
