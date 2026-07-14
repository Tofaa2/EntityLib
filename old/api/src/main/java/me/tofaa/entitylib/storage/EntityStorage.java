package me.tofaa.entitylib.storage;

import me.tofaa.entitylib.wrapper.WrapperEntity;

import java.util.Collection;

public interface EntityStorage {


    Collection<WrapperEntity> readAll();

    void writeAll(Collection<WrapperEntity> entities);

}
