package me.tofaa.entitylib.extras.skin;

import me.tofaa.entitylib.extras.MojangApiError;

import java.util.function.Consumer;

public interface SkinFetcherBuilder {

    CachedSkinFetcherBuilder cached();

    SkinFetcherBuilder onErr(Consumer<MojangApiError> onErr);

    SkinFetcher build();

}
