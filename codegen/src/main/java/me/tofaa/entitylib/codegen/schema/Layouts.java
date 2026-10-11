package me.tofaa.entitylib.codegen.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Layouts {

    public record Slot(int index, SchemaClass owner, SchemaField field) {
    }

    private final Schema schema;
    private final Map<String, List<Slot>> cache = new HashMap<>();

    public Layouts(Schema schema) {
        this.schema = schema;
    }

    public List<Slot> all(SchemaClass schemaClass, Versions.Version version) {
        String key = schemaClass.name + "@" + version.name();
        List<Slot> cached = cache.get(key);
        if (cached != null) {
            return cached;
        }
        List<Slot> slots = new ArrayList<>();
        if (schema.alive(schemaClass, version)) {
            SchemaClass parent = schema.parent(schemaClass, version);
            int next = 0;
            if (parent != null) {
                if (!schema.alive(parent, version)) {
                    throw new SchemaException(schemaClass.name + " extends " + parent.name + " in " + version
                            + ", but " + parent.name + " does not exist in that version");
                }
                List<Slot> inherited = all(parent, version);
                slots.addAll(inherited);
                for (Slot slot : inherited) {
                    if (slot.field().index == null) {
                        next++;
                    }
                }
            }
            for (SchemaField field : schemaClass.fields) {
                if (schema.alive(field, version)) {
                    slots.add(new Slot(field.index != null ? field.index : next++, schemaClass, field));
                }
            }
        }
        cache.put(key, slots);
        return slots;
    }

    public List<Slot> own(SchemaClass schemaClass, Versions.Version version) {
        List<Slot> own = new ArrayList<>();
        for (Slot slot : all(schemaClass, version)) {
            if (slot.owner() == schemaClass) {
                own.add(slot);
            }
        }
        return own;
    }
}
