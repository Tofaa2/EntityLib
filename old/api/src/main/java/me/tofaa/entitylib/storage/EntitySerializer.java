package me.tofaa.entitylib.storage;

import me.tofaa.entitylib.wrapper.WrapperEntity;

/**
 * An interface that represents a way to serialize and deserialize {@link WrapperEntity} and its subclasses.
 * @param <R> the reader generic
 * @param <W> the writer generic
 */
public interface EntitySerializer<R, W> {

    WrapperEntity read(R reader);

    void write(W writer, WrapperEntity wrapper);

}
