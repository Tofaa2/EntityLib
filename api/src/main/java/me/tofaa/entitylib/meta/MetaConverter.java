package me.tofaa.entitylib.meta;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface MetaConverter<T, W> {

    W toWire(T value);

    T fromWire(W wire);

    default W toWire(T value, int protocolVersion) {
        return toWire(value);
    }

    default T fromWire(W wire, int protocolVersion) {
        return fromWire(wire);
    }

    default <V> @NotNull MetaConverter<T, V> then(@NotNull MetaConverter<W, V> next) {
        MetaConverter<T, W> first = this;
        return new MetaConverter<T, V>() {
            @Override
            public V toWire(T value) {
                return next.toWire(first.toWire(value));
            }

            @Override
            public T fromWire(V wire) {
                return first.fromWire(next.fromWire(wire));
            }

            @Override
            public V toWire(T value, int protocolVersion) {
                return next.toWire(first.toWire(value, protocolVersion), protocolVersion);
            }

            @Override
            public T fromWire(V wire, int protocolVersion) {
                return first.fromWire(next.fromWire(wire, protocolVersion), protocolVersion);
            }
        };
    }

    @SuppressWarnings("unchecked")
    static <T> @NotNull MetaConverter<T, T> identity() {
        return (MetaConverter<T, T>) Identity.INSTANCE;
    }

    static <T, W> @NotNull MetaConverter<T, W> of(@NotNull Function<T, W> toWire, @NotNull Function<W, T> fromWire) {
        return new MetaConverter<T, W>() {
            @Override
            public W toWire(T value) {
                return toWire.apply(value);
            }

            @Override
            public T fromWire(W wire) {
                return fromWire.apply(wire);
            }
        };
    }

    enum Identity implements MetaConverter<Object, Object> {
        INSTANCE;

        @Override
        public Object toWire(Object value) {
            return value;
        }

        @Override
        public Object fromWire(Object wire) {
            return wire;
        }
    }
}
