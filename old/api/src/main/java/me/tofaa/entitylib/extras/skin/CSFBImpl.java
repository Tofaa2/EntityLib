package me.tofaa.entitylib.extras.skin;

import me.tofaa.entitylib.extras.MojangApiError;

import java.util.function.Consumer;

final class CSFBImpl implements CachedSkinFetcherBuilder{

    private Consumer<MojangApiError> onErr;
    private long cacheDuration = -1;

    CSFBImpl(Consumer<MojangApiError> onErr) {
        this.onErr = onErr;
    }

    @Override
    public CachedSkinFetcherBuilder cacheDuration(long duration) {
        this.cacheDuration = duration;
        return this;
    }

    @Override
    public CachedSkinFetcherBuilder cached() {
        return this;
    }

    @Override
    public CachedSkinFetcherBuilder onErr(Consumer<MojangApiError> onErr) {
        this.onErr = onErr;
        return this;
    }

    @Override
    public SkinFetcher build() {
        return new CachedSkinFetcherImpl(onErr, cacheDuration);
    }
}
