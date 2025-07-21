package me.tofaa.entitylib;

import java.util.Locale;
import java.util.UUID;

public interface UserLocaleProvider {
    Locale locale(UUID user);
}
