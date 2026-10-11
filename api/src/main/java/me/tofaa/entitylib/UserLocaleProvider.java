package me.tofaa.entitylib;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;

@FunctionalInterface
public interface UserLocaleProvider {

    @NotNull Locale locale(@NotNull UUID user);

}
