package me.tofaa.entitylib.spigot;

import me.tofaa.entitylib.UserLocaleProvider;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Function;
import net.kyori.adventure.translation.Translator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


/**
 * This implementation is based on code from the scoreboard-library project:
 * <a href="https://github.com/MegavexNetwork/scoreboard-library/blob/bc8e3c2d2ecf9973ec0d6bb8ae4af94ed008b360/commons/src/main/java/net/megavex/scoreboardlibrary/implementation/commons/LocaleProvider.java">LocaleProvider</a>
 * Modified and adapted for use in EntityLib.
 */
public class SpigotPlayerLocaleProvider implements UserLocaleProvider {
    private static final Locale DEFAULT_LOCALE = Locale.US;
    private static final Function<Player, Locale> provider = get();

    @Override
    public Locale locale(final UUID user) {
        final Player player = Bukkit.getPlayer(user);
        return player == null ? DEFAULT_LOCALE : provider.apply(player);
    }

    private static @NotNull Function<Player, Locale> get() {
        MethodHandles.Lookup lookup = MethodHandles.publicLookup();
        try {
            MethodHandle adventureMethod = lookup.findVirtual(Player.class, "locale", MethodType.methodType(Locale.class));
            return player -> {
                try {
                    return (Locale) adventureMethod.invokeExact(player);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (IllegalAccessException | NoSuchMethodException ignored) {
        }

        MethodType methodType = MethodType.methodType(String.class);
        try {
            MethodHandle legacySpigotMethod = lookup.findVirtual(Player.Spigot.class, "getLocale", methodType);
            return player -> {
                try {
                    Locale locale = Translator.parseLocale((String) legacySpigotMethod.invokeExact(player.spigot()));
                    return locale == null ? DEFAULT_LOCALE : locale;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (IllegalAccessException | NoSuchMethodException ignored) {
        }

        try {
            MethodHandle legacyMethod = lookup.findVirtual(Player.class, "getLocale", methodType);
            return player -> {
                try {
                    Locale locale = Translator.parseLocale((String) legacyMethod.invokeExact(player));
                    return locale == null ? DEFAULT_LOCALE : locale;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (IllegalAccessException | NoSuchMethodException ignored) {
            throw new RuntimeException("No way to get players locale found");
        }
    }
}
