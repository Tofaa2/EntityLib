package me.tofaa.entitylib.extras.skin;

import me.tofaa.entitylib.extras.MojangApiError;

import java.util.function.Consumer;

public interface CachedSkinFetcherBuilder extends SkinFetcherBuilder {

    CachedSkinFetcherBuilder cacheDuration(long duration);

    @Override
    CachedSkinFetcherBuilder onErr(Consumer<MojangApiError> onErr);

}
