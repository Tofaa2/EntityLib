package me.tofaa.entitylib.extras.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.tofaa.entitylib.extras.MojangApiError;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

final class SFUtils {

    public static ErroredTextureProperties getTextures(String username) {
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + username);
            InputStream stream = url.openStream();
            InputStreamReader isr = new InputStreamReader(stream);
            JsonObject root = parse(isr);
            UUID uuid = UUID.fromString(root.get("id").getAsString());
            isr.close();
            stream.close();
            return getTextures(uuid);
        }
        catch (IOException e) {
            return new ErroredTextureProperties(new MojangApiError(e));
        }
    }

    public static ErroredTextureProperties getTextures(UUID uuid) {
        try {
            URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid.toString().replace("-", "") + "?unsigned=false");
            InputStream stream = url.openStream();
            InputStreamReader isr = new InputStreamReader(stream);
            JsonObject root = parse(isr);
            JsonArray textures = getTexturesObject(root);
            List<TextureProperty> properties = new ArrayList<>(textures.size());
            for (int i = 0; i < textures.size(); i++) {
                JsonObject texture = textures.get(i).getAsJsonObject();
                String name = texture.get("name").getAsString();
                String value = texture.get("value").getAsString();
                String signature = texture.has("signature") ? texture.get("signature").getAsString() : null;
                properties.add(new TextureProperty(name, value, signature));
            }
            isr.close();
            stream.close();
            ErroredTextureProperties prop = new ErroredTextureProperties(properties);
            prop.uuid = uuid;
            return prop;
        }
        catch (IOException e) {
            return new ErroredTextureProperties(new MojangApiError(e));
        }
    }

    private SFUtils() {}

    static JsonArray getTexturesObject(JsonObject root) {
        return root.getAsJsonArray("properties");
    }

    static JsonObject parse(InputStreamReader isr) {
        return new JsonParser().parse(isr).getAsJsonObject();
    }

}
