package me.tofaa.entitylib.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 * Convenient class to check for common exceptions. Taken from <a href="https://minestom.net/">Minestom</a>
 */
public final class Check {

    private Check() {}


    public static <T> void arrayLength(List<T> lines, int index, T e) {
        if (index >= lines.size()) {
            for (int i = lines.size(); i < index; i++) {
                lines.add(null);
            }
            lines.add(e);
        }
        else {lines.set(index, e);
        }
    }

    @Contract("null, _ -> fail")
    public static void notNull(@Nullable Object object, @NotNull String reason) {
        if (Objects.isNull(object)) {
            throw new NullPointerException(reason);
        }
    }

    @Contract("null, _, _ -> fail")
    public static void notNull(@Nullable Object object, @NotNull String reason, Object... arguments) {
        if (Objects.isNull(object)) {
            throw new NullPointerException(MessageFormat.format(reason, arguments));
        }
    }

    @Contract("true, _ -> fail")
    public static void argCondition(boolean condition, @NotNull String reason) {
        if (condition) {
            throw new IllegalArgumentException(reason);
        }
    }

    @Contract("true, _, _ -> fail")
    public static void argCondition(boolean condition, @NotNull String reason, Object... arguments) {
        if (condition) {
            throw new IllegalArgumentException(MessageFormat.format(reason, arguments));
        }
    }

    @Contract("_ -> fail")
    public static void fail(@NotNull String reason) {
        throw new IllegalArgumentException(reason);
    }

    @Contract("true, _ -> fail")
    public static void stateCondition(boolean condition, @NotNull String reason) {
        if (condition) {
            throw new IllegalStateException(reason);
        }
    }

    @Contract("true, _, _ -> fail")
    public static void stateCondition(boolean condition, @NotNull String reason, Object... arguments) {
        if (condition) {
            throw new IllegalStateException(MessageFormat.format(reason, arguments));
        }
    }

}