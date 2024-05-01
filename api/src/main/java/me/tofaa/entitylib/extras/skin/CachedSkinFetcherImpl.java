package me.tofaa.entitylib.extras.skin;

import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import me.tofaa.entitylib.extras.MojangApiError;

import java.util.*;
import java.util.function.Consumer;

final class CachedSkinFetcherImpl implements SkinFetcher {

    private final long cacheDuration;
    private final Consumer<MojangApiError> onErr;
    private final Map<String, CachedData> cache = new HashMap<>();
    private final Map<UUID, CachedData> cacheUUID = new HashMap<>();

    CachedSkinFetcherImpl(Consumer<MojangApiError> onErr, long cacheDuration) {
        this.onErr = onErr;
        this.cacheDuration = cacheDuration;
    }


    @Override
    public List<TextureProperty> getSkin(String playerName) {
        if (cache.containsKey(playerName)) {
            CachedData data = cache.get(playerName);
            if (data.expiration > System.currentTimeMillis()) {
                return data.skin;
            }
            else {
                cache.remove(playerName);
            }
        }
        return putAndReturn(playerName);
    }

    @Override
    public List<TextureProperty> getSkin(UUID uuid) {
        if (cacheUUID.containsKey(uuid)) {
            CachedData data = cacheUUID.get(uuid);
            if (data.expiration > System.currentTimeMillis()) {
                return data.skin;
            }
            else {
                cacheUUID.remove(uuid);
            }
        }
        return putAndReturn(uuid);
    }

    @Override
    public List<TextureProperty> getSkinOrDefault(String playerName, List<TextureProperty> defaults) {
        if (cache.containsKey(playerName)) {
            CachedData data = cache.get(playerName);
            if (data.expiration > System.currentTimeMillis()) {
                return data.skin;
            }
            else {
                cache.remove(playerName);
            }
        }
        List<TextureProperty> skin = putAndReturn(playerName);
        if (skin.isEmpty()) {
            cache.remove(playerName);
            return defaults;
        }
        return skin;
    }

    @Override
    public List<TextureProperty> getSkinOrDefault(UUID uuid, List<TextureProperty> defaults) {
        if (cacheUUID.containsKey(uuid)) {
            CachedData data = cacheUUID.get(uuid);
            if (data.expiration > System.currentTimeMillis()) {
                return data.skin;
            }
            else {
                cacheUUID.remove(uuid);
            }
        }
        List<TextureProperty> skin = putAndReturn(uuid);
        if (skin.isEmpty()) {
            cacheUUID.remove(uuid);
            return defaults;
        }
        return skin;
    }

    private List<TextureProperty> putAndReturn(String playerName) {
        ErroredTextureProperties p = SFUtils.getTextures(playerName);
        if (p.didError()) {
            if (onErr != null) {
                onErr.accept(new MojangApiError(p.getError()));
            }
            return Collections.emptyList();
        }
        List<TextureProperty> skin = p.getTextureProperties();
        CachedData data;
        if (cacheDuration == -1) {
            data = new CachedData(skin, Long.MAX_VALUE);
        }
        else {
            data = new CachedData(skin, System.currentTimeMillis() + cacheDuration);
        }
        cache.put(playerName, data);
        if (p.uuid != null) {
            cacheUUID.put(p.uuid, data);
        }
        return skin;
    }

    private List<TextureProperty> putAndReturn(UUID uuid) {
        ErroredTextureProperties p = SFUtils.getTextures(uuid);
        if (p.didError()) {
            if (onErr != null) {
                onErr.accept(new MojangApiError(p.getError()));
            }
            return Collections.emptyList();
        }
        List<TextureProperty> skin = p.getTextureProperties();
        if (cacheDuration != -1) {
            cacheUUID.put(uuid, new CachedData(skin, System.currentTimeMillis() + cacheDuration));
        }
        else {
            cacheUUID.put(uuid, new CachedData(skin, Long.MAX_VALUE));
        }
        return skin;
    }
    static class CachedData {
        private final List<TextureProperty> skin;
        private final long expiration;
        CachedData(List<TextureProperty> skin, long expiration) {
            this.skin = skin;
            this.expiration = expiration;
        }
    }
}
