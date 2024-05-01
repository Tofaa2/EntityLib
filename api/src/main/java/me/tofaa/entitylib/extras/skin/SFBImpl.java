package me.tofaa.entitylib.extras.skin;

import me.tofaa.entitylib.extras.MojangApiError;

import java.util.function.Consumer;

class SFBImpl implements SkinFetcherBuilder {

    private Consumer<MojangApiError> rateLimitErrorConsumer;

    @Override
    public CachedSkinFetcherBuilder cached() {
        return new CSFBImpl(rateLimitErrorConsumer);
    }

    @Override
    public SkinFetcherBuilder onErr(Consumer<MojangApiError> onErr) {
        this.rateLimitErrorConsumer = onErr;
        return this;
    }

    @Override
    public SkinFetcher build() {
        return new SkinFetcherImpl(rateLimitErrorConsumer);
    }


}
