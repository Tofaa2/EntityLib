package me.tofaa.entitylib.storage;

import me.tofaa.entitylib.wrapper.WrapperEntity;

import java.nio.ByteBuffer;

public class ByteEntitySerializer implements EntitySerializer<ByteBuffer, ByteBuffer> {
    @Override
    public WrapperEntity read(ByteBuffer reader) {
        return null;
    }

    @Override
    public void write(ByteBuffer writer, WrapperEntity wrapper) {

    }
}
