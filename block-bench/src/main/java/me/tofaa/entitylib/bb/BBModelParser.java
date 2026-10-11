package me.tofaa.entitylib.bb;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.tofaa.entitylib.bb.math.Vec3;
import me.tofaa.entitylib.bb.model.BBAnimation;
import me.tofaa.entitylib.bb.model.BBAnimator;
import me.tofaa.entitylib.bb.model.BBCube;
import me.tofaa.entitylib.bb.model.BBFace;
import me.tofaa.entitylib.bb.model.BBGroup;
import me.tofaa.entitylib.bb.model.BBKeyframe;
import me.tofaa.entitylib.bb.model.BBModel;
import me.tofaa.entitylib.bb.model.BBTexture;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public final class BBModelParser {

    private static final Vec3 JAVA_BLOCK_CENTER = new Vec3(8, 0, 8);

    private BBModelParser() {
    }

    public static @NotNull BBModel parse(@NotNull Path file) throws IOException {
        return parse(Files.readString(file, StandardCharsets.UTF_8));
    }

    public static @NotNull BBModel parse(@NotNull Reader reader) {
        return parse(JsonParser.parseReader(reader).getAsJsonObject());
    }

    public static @NotNull BBModel parse(@NotNull String json) {
        return parse(JsonParser.parseString(json).getAsJsonObject());
    }

    public static @NotNull BBModel parse(@NotNull JsonObject root) {
        JsonObject meta = object(root, "meta");
        String format = meta == null ? "free" : string(meta, "model_format", "free");
        Vec3 offset = format.startsWith("java_block") ? JAVA_BLOCK_CENTER : Vec3.ZERO;

        JsonObject resolution = object(root, "resolution");
        int width = resolution == null ? 16 : (int) number(resolution, "width", 16);
        int height = resolution == null ? 16 : (int) number(resolution, "height", 16);

        Map<String, BBCube> cubes = new HashMap<>();
        for (JsonElement element : array(root, "elements")) {
            JsonObject raw = element.getAsJsonObject();
            if (!string(raw, "type", "cube").equals("cube") || !raw.has("from") || !raw.has("to")) {
                continue;
            }
            BBCube cube = cube(raw, offset);
            cubes.put(cube.uuid().toString(), cube);
        }

        Map<String, JsonObject> groups = new HashMap<>();
        for (JsonElement element : array(root, "groups")) {
            JsonObject raw = element.getAsJsonObject();
            groups.put(string(raw, "uuid", ""), raw);
        }

        List<BBGroup> rootGroups = new ArrayList<>();
        List<BBCube> rootCubes = new ArrayList<>();
        children(array(root, "outliner"), cubes, groups, offset, rootGroups, rootCubes);
        BBGroup rootGroup = new BBGroup(new UUID(0, 0), "root", Vec3.ZERO, Vec3.ZERO, true, rootGroups, rootCubes);

        List<BBTexture> textures = new ArrayList<>();
        for (JsonElement element : array(root, "textures")) {
            JsonObject raw = element.getAsJsonObject();
            textures.add(new BBTexture(uuid(raw), string(raw, "name", ""), image(string(raw, "source", ""))));
        }

        Map<String, BBAnimation> animations = new LinkedHashMap<>();
        for (JsonElement element : array(root, "animations")) {
            BBAnimation animation = animation(element.getAsJsonObject());
            animations.put(animation.name(), animation);
        }

        return new BBModel(string(root, "name", ""), format, width, height, rootGroup, textures, animations);
    }

    private static void children(JsonArray nodes, Map<String, BBCube> cubes, Map<String, JsonObject> groups, Vec3 offset,
                                 List<BBGroup> outGroups, List<BBCube> outCubes) {
        for (JsonElement node : nodes) {
            if (node.isJsonPrimitive()) {
                BBCube cube = cubes.get(node.getAsString());
                if (cube != null) {
                    outCubes.add(cube);
                }
                continue;
            }
            JsonObject raw = node.getAsJsonObject();
            JsonObject properties = raw.has("origin") || raw.has("name") ? raw : groups.getOrDefault(string(raw, "uuid", ""), raw);
            List<BBGroup> childGroups = new ArrayList<>();
            List<BBCube> childCubes = new ArrayList<>();
            children(array(raw, "children"), cubes, groups, offset, childGroups, childCubes);
            outGroups.add(new BBGroup(
                uuid(raw),
                string(properties, "name", ""),
                vector(properties, "origin", Vec3.ZERO).sub(offset),
                vector(properties, "rotation", Vec3.ZERO),
                bool(properties, "visibility", true),
                childGroups,
                childCubes
            ));
        }
    }

    private static BBCube cube(JsonObject raw, Vec3 offset) {
        List<BBFace> faces = new ArrayList<>();
        JsonObject rawFaces = object(raw, "faces");
        if (rawFaces != null) {
            for (BBFace.Direction direction : BBFace.Direction.values()) {
                JsonObject face = object(rawFaces, direction.name().toLowerCase(Locale.ROOT));
                if (face == null) {
                    continue;
                }
                JsonArray uv = array(face, "uv");
                JsonElement texture = face.get("texture");
                faces.add(new BBFace(
                    direction,
                    uv.size() > 0 ? uv.get(0).getAsDouble() : 0,
                    uv.size() > 1 ? uv.get(1).getAsDouble() : 0,
                    uv.size() > 2 ? uv.get(2).getAsDouble() : 0,
                    uv.size() > 3 ? uv.get(3).getAsDouble() : 0,
                    texture == null || texture.isJsonNull() || !texture.getAsJsonPrimitive().isNumber() ? -1 : texture.getAsInt()
                ));
            }
        }
        return new BBCube(
            uuid(raw),
            string(raw, "name", ""),
            vector(raw, "from", Vec3.ZERO).sub(offset),
            vector(raw, "to", Vec3.ZERO).sub(offset),
            vector(raw, "origin", Vec3.ZERO).sub(offset),
            vector(raw, "rotation", Vec3.ZERO),
            number(raw, "inflate", 0),
            bool(raw, "visibility", true),
            faces
        );
    }

    private static BBAnimation animation(JsonObject raw) {
        Map<UUID, BBAnimator> animators = new HashMap<>();
        JsonObject rawAnimators = object(raw, "animators");
        if (rawAnimators != null) {
            for (Map.Entry<String, JsonElement> entry : rawAnimators.entrySet()) {
                UUID bone;
                try {
                    bone = UUID.fromString(entry.getKey());
                } catch (IllegalArgumentException notABone) {
                    continue;
                }
                JsonObject animator = entry.getValue().getAsJsonObject();
                List<BBKeyframe> rotation = new ArrayList<>();
                List<BBKeyframe> position = new ArrayList<>();
                List<BBKeyframe> scale = new ArrayList<>();
                for (JsonElement element : array(animator, "keyframes")) {
                    JsonObject keyframe = element.getAsJsonObject();
                    JsonArray points = array(keyframe, "data_points");
                    if (points.size() == 0) {
                        continue;
                    }
                    String channel = string(keyframe, "channel", "");
                    JsonObject point = points.get(0).getAsJsonObject();
                    double fallback = channel.equals("scale") ? 1 : 0;
                    Vec3 value = new Vec3(expression(point, "x", fallback), expression(point, "y", fallback), expression(point, "z", fallback));
                    BBKeyframe.Interpolation interpolation = string(keyframe, "interpolation", "linear").equals("step")
                        ? BBKeyframe.Interpolation.STEP
                        : BBKeyframe.Interpolation.LINEAR;
                    BBKeyframe parsed = new BBKeyframe(number(keyframe, "time", 0), value, interpolation);
                    switch (channel) {
                        case "rotation" -> rotation.add(parsed);
                        case "position" -> position.add(parsed);
                        case "scale" -> scale.add(parsed);
                        default -> {
                        }
                    }
                }
                Comparator<BBKeyframe> byTime = Comparator.comparingDouble(BBKeyframe::time);
                rotation.sort(byTime);
                position.sort(byTime);
                scale.sort(byTime);
                animators.put(bone, new BBAnimator(string(animator, "name", ""), rotation, position, scale));
            }
        }
        BBAnimation.Loop loop = switch (string(raw, "loop", "once")) {
            case "loop" -> BBAnimation.Loop.LOOP;
            case "hold" -> BBAnimation.Loop.HOLD;
            default -> BBAnimation.Loop.ONCE;
        };
        return new BBAnimation(uuid(raw), string(raw, "name", ""), loop, number(raw, "length", 0), animators);
    }

    private static double expression(JsonObject object, String key, double fallback) {
        JsonElement element = object.get(key);
        if (element == null || element.isJsonNull() || !element.isJsonPrimitive()) {
            return fallback;
        }
        try {
            return Double.parseDouble(element.getAsString().trim());
        } catch (NumberFormatException molang) {
            return fallback;
        }
    }

    private static byte[] image(String source) {
        int comma = source.indexOf(',');
        if (!source.startsWith("data:") || comma < 0) {
            return new byte[0];
        }
        try {
            return Base64.getDecoder().decode(source.substring(comma + 1));
        } catch (IllegalArgumentException invalid) {
            return new byte[0];
        }
    }

    private static UUID uuid(JsonObject object) {
        try {
            return UUID.fromString(string(object, "uuid", ""));
        } catch (IllegalArgumentException missing) {
            return UUID.randomUUID();
        }
    }

    private static JsonObject object(JsonObject parent, String key) {
        JsonElement element = parent.get(key);
        return element != null && element.isJsonObject() ? element.getAsJsonObject() : null;
    }

    private static JsonArray array(JsonObject parent, String key) {
        JsonElement element = parent.get(key);
        return element != null && element.isJsonArray() ? element.getAsJsonArray() : new JsonArray();
    }

    private static String string(JsonObject parent, String key, String fallback) {
        JsonElement element = parent.get(key);
        return element != null && element.isJsonPrimitive() ? element.getAsString() : fallback;
    }

    private static double number(JsonObject parent, String key, double fallback) {
        JsonElement element = parent.get(key);
        try {
            return element != null && element.isJsonPrimitive() ? element.getAsDouble() : fallback;
        } catch (NumberFormatException invalid) {
            return fallback;
        }
    }

    private static boolean bool(JsonObject parent, String key, boolean fallback) {
        JsonElement element = parent.get(key);
        return element != null && element.isJsonPrimitive() && element.getAsJsonPrimitive().isBoolean() ? element.getAsBoolean() : fallback;
    }

    private static Vec3 vector(JsonObject parent, String key, Vec3 fallback) {
        JsonArray array = array(parent, key);
        if (array.size() < 3) {
            return fallback;
        }
        return new Vec3(array.get(0).getAsDouble(), array.get(1).getAsDouble(), array.get(2).getAsDouble());
    }

}
