package me.tofaa.entitylib.codegen.gen;

import me.tofaa.entitylib.codegen.schema.Layouts;
import me.tofaa.entitylib.codegen.schema.Schema;
import me.tofaa.entitylib.codegen.schema.SchemaClass;
import me.tofaa.entitylib.codegen.schema.SchemaException;
import me.tofaa.entitylib.codegen.schema.SchemaField;
import me.tofaa.entitylib.codegen.schema.SchemaFlag;
import me.tofaa.entitylib.codegen.schema.TypeDef;
import me.tofaa.entitylib.codegen.schema.Versions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Model {

    public record Binding(Versions.Version from, int toProtocol, int index, TypeDef type, String convert) {
    }

    public record FlagRange(Versions.Version from, int toProtocol, int mask) {
    }

    public record Flag(String name, String constant, List<FlagRange> ranges) {
        public boolean aliveIn(Versions.Version version) {
            return ranges.stream().anyMatch(range -> version.protocol() >= range.from().protocol()
                    && version.protocol() < range.toProtocol());
        }
    }

    public record Field(SchemaClass owner, String name, TypeDef valueType, List<Binding> bindings, List<Flag> flags) {
        public boolean aliveIn(Versions.Version version) {
            return bindings.stream().anyMatch(binding -> version.protocol() >= binding.from().protocol()
                    && version.protocol() < binding.toProtocol());
        }
    }

    private final Schema schema;
    private final Layouts layouts;
    private final Map<String, List<Field>> fields = new LinkedHashMap<>();
    private final java.util.Set<String> problems = new java.util.LinkedHashSet<>();

    public Model(Schema schema) {
        this.schema = schema;
        this.layouts = new Layouts(schema);
        for (SchemaClass schemaClass : schema.classes()) {
            fields.put(schemaClass.name, resolve(schemaClass));
        }
        if (!problems.isEmpty()) {
            throw new SchemaException("The schema cannot be generated:\n  " + String.join("\n  ", problems));
        }
    }

    public Schema schema() {
        return schema;
    }

    public Layouts layouts() {
        return layouts;
    }

    public List<Field> fields(SchemaClass schemaClass) {
        return fields.get(schemaClass.name);
    }

    private List<Field> resolve(SchemaClass schemaClass) {
        Map<String, List<SchemaField>> byName = new LinkedHashMap<>();
        for (SchemaField entry : schemaClass.fields) {
            byName.computeIfAbsent(entry.name, name -> new ArrayList<>()).add(entry);
        }
        List<Field> result = new ArrayList<>();
        List<String> constants = new ArrayList<>(byName.keySet());
        constants.add("META_CLASS");
        for (Map.Entry<String, List<SchemaField>> logical : byName.entrySet()) {
            String name = logical.getKey();
            SchemaField newest = logical.getValue().get(0);
            for (SchemaField entry : logical.getValue()) {
                if (schema.versions().get(entry.since).ordinal() > schema.versions().get(newest.since).ordinal()) {
                    newest = entry;
                }
            }
            TypeDef valueType = schema.type(newest.type);

            List<Binding> bindings = new ArrayList<>();
            Map<String, List<FlagRange>> flagRanges = new LinkedHashMap<>();
            Layouts.Slot previous = null;
            for (Versions.Version version : schema.versions().list()) {
                Layouts.Slot slot = null;
                for (Layouts.Slot candidate : layouts.own(schemaClass, version)) {
                    if (candidate.field().name.equals(name)) {
                        slot = candidate;
                    }
                }
                if (previous != null && (slot == null || !sameBinding(previous, slot))) {
                    close(bindings, version);
                }
                if (slot != null && (previous == null || !sameBinding(previous, slot))) {
                    TypeDef type = schema.type(slot.field().type);
                    String convert = slot.field().convert;
                    if (convert == null && !type.java().equals(valueType.java())) {
                        convert = schema.conversion(valueType.name(), type.name());
                    }
                    if (!type.java().equals(valueType.java()) && convert == null) {
                        problems.add(schemaClass.name + "." + name + ": is " + valueType.name() + " in its newest version but "
                                + type.name() + " since " + slot.field().since + "; add 'convert: <constant in MetaConverters>'"
                                + " to the " + type.name() + " entry, a default under 'conversions' in types.yml,"
                                + " or give the entries different names");
                    }
                    bindings.add(new Binding(version, Integer.MAX_VALUE, slot.index(), type, convert));
                }
                collectFlags(flagRanges, slot, version);
                previous = slot;
            }
            List<Flag> flags = new ArrayList<>();
            for (Map.Entry<String, List<FlagRange>> flag : flagRanges.entrySet()) {
                if (flag.getValue().isEmpty()) {
                    continue;
                }
                String constant = flag.getKey();
                if (constants.contains(constant)) {
                    constant = name + "_" + constant;
                }
                constants.add(constant);
                flags.add(new Flag(flag.getKey(), constant, flag.getValue()));
            }
            result.add(new Field(schemaClass, name, valueType, bindings, flags));
        }
        return result;
    }

    private static boolean sameBinding(Layouts.Slot a, Layouts.Slot b) {
        return a.index() == b.index() && a.field().type.equals(b.field().type)
                && Objects.equals(a.field().convert, b.field().convert);
    }

    private static void close(List<Binding> bindings, Versions.Version version) {
        Binding last = bindings.get(bindings.size() - 1);
        if (last.toProtocol() == Integer.MAX_VALUE) {
            bindings.set(bindings.size() - 1,
                    new Binding(last.from(), version.protocol(), last.index(), last.type(), last.convert()));
        }
    }

    private void collectFlags(Map<String, List<FlagRange>> flagRanges, Layouts.Slot slot, Versions.Version version) {
        Map<String, Integer> alive = new LinkedHashMap<>();
        if (slot != null) {
            for (SchemaFlag flag : slot.field().flags) {
                if (schema.versions().alive(flag.since, flag.removed, version)) {
                    alive.put(flag.name, flag.mask);
                }
            }
            for (SchemaFlag flag : slot.field().flags) {
                flagRanges.computeIfAbsent(flag.name, name -> new ArrayList<>());
            }
        }
        for (Map.Entry<String, List<FlagRange>> entry : flagRanges.entrySet()) {
            List<FlagRange> ranges = entry.getValue();
            FlagRange last = ranges.isEmpty() ? null : ranges.get(ranges.size() - 1);
            boolean open = last != null && last.toProtocol() == Integer.MAX_VALUE;
            Integer mask = alive.get(entry.getKey());
            if (open && (mask == null || mask != last.mask())) {
                ranges.set(ranges.size() - 1, new FlagRange(last.from(), version.protocol(), last.mask()));
                open = false;
            }
            if (!open && mask != null) {
                ranges.add(new FlagRange(version, Integer.MAX_VALUE, mask));
            }
        }
    }

    public SchemaClass javaParent(SchemaClass schemaClass) {
        Versions.Version last = null;
        for (Versions.Version version : schema.versions().list()) {
            if (schema.alive(schemaClass, version)) {
                last = version;
            }
        }
        return last == null ? null : schema.parent(schemaClass, last);
    }
}
