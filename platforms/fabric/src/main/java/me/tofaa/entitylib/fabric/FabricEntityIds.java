package me.tofaa.entitylib.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;

final class FabricEntityIds {

    private static final String INTERMEDIARY_ENTITY = "net.minecraft.class_1297";

    private FabricEntityIds() {
    }

    static IntSupplier detect() {
        for (String name : candidates()) {
            Class<?> entityClass;
            try {
                entityClass = Class.forName(name, false, FabricEntityIds.class.getClassLoader());
            } catch (ClassNotFoundException | LinkageError missing) {
                continue;
            }
            for (Field field : entityClass.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) || field.getType() != AtomicInteger.class) {
                    continue;
                }
                try {
                    field.setAccessible(true);
                    AtomicInteger counter = (AtomicInteger) field.get(null);
                    if (counter != null) {
                        return counter::incrementAndGet;
                    }
                } catch (ReflectiveOperationException | RuntimeException inaccessible) {
                    return null;
                }
            }
        }
        return null;
    }

    private static List<String> candidates() {
        List<String> names = new ArrayList<>();
        try {
            names.add(FabricLoader.getInstance().getMappingResolver().mapClassName("intermediary", INTERMEDIARY_ENTITY));
        } catch (RuntimeException unmapped) {
            names.add(INTERMEDIARY_ENTITY);
        }
        names.add("net.minecraft.world.entity.Entity");
        names.add("net.minecraft.entity.Entity");
        return names;
    }

}
