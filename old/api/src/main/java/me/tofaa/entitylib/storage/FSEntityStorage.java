package me.tofaa.entitylib.storage;

import me.tofaa.entitylib.wrapper.WrapperEntity;

import java.util.Collection;
import java.util.Collections;

public class FSEntityStorage implements EntityStorage{
    @Override
    public Collection<WrapperEntity> readAll() {
        return Collections.emptyList();
    }

    @Override
    public void writeAll(Collection<WrapperEntity> entities) {

    }
}
