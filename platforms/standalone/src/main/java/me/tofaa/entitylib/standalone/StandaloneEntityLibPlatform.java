package me.tofaa.entitylib.standalone;

import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLibAPI;
import me.tofaa.entitylib.UserLocaleProvider;
import me.tofaa.entitylib.common.AbstractPlatform;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

public class StandaloneEntityLibPlatform extends AbstractPlatform<Object> {


    private StandaloneEntityLibApi api;
    private UserLocaleProvider userLocaleProvider = (user) -> Locale.US;

    public StandaloneEntityLibPlatform() {
        super(null);
    }

    @Override
    public void setupApi(@NotNull APIConfig settings) {
        super.setupApi(settings);
        api = new StandaloneEntityLibApi(this, settings);
    }

    @Override
    public @NotNull Object getHandle() {
        throw new UnsupportedOperationException("Standalone platform does not have a handle.");
    }

    @Override
    public EntityLibAPI<?> getAPI() {
        return api;
    }

    @Override
    public String getName() {
        return "Standalone";
    }

    @Override
    public @NotNull UserLocaleProvider getUserLocaleProvider() {
        return userLocaleProvider;
    }

    @Override
    public void setUserLocaleProvider(@NotNull final UserLocaleProvider provider) {
        this.userLocaleProvider = provider;
    }
}
