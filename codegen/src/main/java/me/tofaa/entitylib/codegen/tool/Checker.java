package me.tofaa.entitylib.codegen.tool;

import me.tofaa.entitylib.codegen.schema.Layouts;
import me.tofaa.entitylib.codegen.schema.ParentRef;
import me.tofaa.entitylib.codegen.schema.Schema;
import me.tofaa.entitylib.codegen.schema.SchemaClass;
import me.tofaa.entitylib.codegen.schema.SchemaException;
import me.tofaa.entitylib.codegen.schema.SchemaField;
import me.tofaa.entitylib.codegen.schema.SchemaFlag;
import me.tofaa.entitylib.codegen.schema.Versions;
import me.tofaa.entitylib.codegen.snapshot.Snapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public final class Checker {

    private final Schema schema;
    private final Layouts layouts;
    private final List<String> problems = new ArrayList<>();

    public Checker(Schema schema) {
        this.schema = schema;
        this.layouts = new Layouts(schema);
    }

    public List<String> problems() {
        return problems;
    }

    public void validate() {
        Versions versions = schema.versions();
        for (SchemaClass schemaClass : schema.classes()) {
            String where = schemaClass.name;
            try {
                checkRange(where, schemaClass.since, schemaClass.removed);
                for (ParentRef parent : schemaClass.parents) {
                    checkRange(where + " extends " + parent.parent, parent.since, parent.removed);
                    if (schema.get(parent.parent) == null) {
                        problems.add(where + ": extends unknown class " + parent.parent);
                    }
                }
                for (SchemaField field : schemaClass.fields) {
                    String fieldWhere = where + "." + field.name;
                    checkRange(fieldWhere, field.since, field.removed);
                    schema.type(field.type);
                    if (!field.name.matches("[A-Z][A-Z0-9_]*")) {
                        problems.add(fieldWhere + ": field names must be UPPER_SNAKE_CASE");
                    }
                    if (!field.flags.isEmpty() && !schema.type(field.type).java().equals("java.lang.Byte")) {
                        problems.add(fieldWhere + ": flags are only supported on byte fields");
                    }
                    for (SchemaFlag flag : field.flags) {
                        checkRange(fieldWhere + "#" + flag.name, flag.since, flag.removed);
                        if (flag.mask <= 0 || flag.mask > 0xFF) {
                            problems.add(fieldWhere + "#" + flag.name + ": mask must be between 0x01 and 0xFF");
                        }
                    }
                }
            } catch (SchemaException e) {
                problems.add(where + ": " + e.getMessage());
            }
        }
        if (!problems.isEmpty()) {
            return;
        }
        for (Versions.Version version : versions.list()) {
            Map<String, String> owners = new HashMap<>();
            for (SchemaClass schemaClass : schema.classes()) {
                if (!schema.alive(schemaClass, version)) {
                    continue;
                }
                for (String entity : schemaClass.entities) {
                    if (!entity.matches("[a-z][a-z0-9_]*")) {
                        problems.add(schemaClass.name + ": entity names must be lower_snake_case, found " + entity);
                    }
                    String other = owners.put(entity, schemaClass.name);
                    if (other != null) {
                        problems.add("Entity " + entity + " is listed by both " + other + " and " + schemaClass.name + " in " + version);
                    }
                }
            }
        }
        if (!problems.isEmpty()) {
            return;
        }
        for (Versions.Version version : versions.list()) {
            for (SchemaClass schemaClass : schema.classes()) {
                if (!schema.alive(schemaClass, version)) {
                    continue;
                }
                String where = schemaClass.name + " in " + version;
                int parents = 0;
                for (ParentRef parent : schemaClass.parents) {
                    if (versions.alive(parent.since, parent.removed, version)) {
                        parents++;
                    }
                }
                if (parents > 1) {
                    problems.add(where + ": more than one parent applies");
                    continue;
                }
                if (hasCycle(schemaClass, version)) {
                    problems.add(where + ": inheritance cycle");
                    continue;
                }
                List<Layouts.Slot> slots;
                try {
                    slots = layouts.all(schemaClass, version);
                } catch (SchemaException e) {
                    problems.add(where + ": " + e.getMessage());
                    continue;
                }
                Map<Integer, String> byIndex = new HashMap<>();
                Set<String> ownNames = new HashSet<>();
                for (Layouts.Slot slot : slots) {
                    String previous = byIndex.put(slot.index(), slot.owner().name + "." + slot.field().name);
                    if (previous != null) {
                        problems.add(where + ": index " + slot.index() + " is used by both " + previous + " and "
                                + slot.owner().name + "." + slot.field().name);
                    }
                    if (slot.owner() == schemaClass && !ownNames.add(slot.field().name)) {
                        problems.add(where + ": two entries named " + slot.field().name + " exist at the same time");
                    }
                    if (slot.owner() == schemaClass) {
                        int used = 0;
                        for (SchemaFlag flag : slot.field().flags) {
                            if (!versions.alive(flag.since, flag.removed, version)) {
                                continue;
                            }
                            if ((used & flag.mask) != 0) {
                                problems.add(where + ": flag " + flag.name + " of " + slot.field().name
                                        + " overlaps another flag");
                            }
                            used |= flag.mask;
                        }
                    }
                }
            }
        }
    }

    private void checkRange(String where, String since, String removed) {
        Versions versions = schema.versions();
        if (since != null && removed != null && versions.get(since).ordinal() >= versions.get(removed).ordinal()) {
            problems.add(where + ": 'removed' (" + removed + ") must be a later version than 'since' (" + since + ")");
        } else {
            if (since != null) versions.get(since);
            if (removed != null) versions.get(removed);
        }
    }

    private boolean hasCycle(SchemaClass start, Versions.Version version) {
        Set<SchemaClass> seen = new HashSet<>();
        for (SchemaClass current = start; current != null; current = schema.parent(current, version)) {
            if (!seen.add(current)) {
                return true;
            }
        }
        return false;
    }

    public void verify(Snapshot snapshot) {
        Versions.Version version = snapshot.version();
        String at = "[" + version + "] ";
        Set<String> names = new TreeSet<>(snapshot.classes().keySet());
        for (SchemaClass schemaClass : schema.classes()) {
            if (schema.alive(schemaClass, version)) {
                names.add(schemaClass.name);
            }
        }
        for (String name : names) {
            SchemaClass schemaClass = schema.get(name);
            Snapshot.SnapClass expected = snapshot.classes().get(name);
            boolean inSchema = schemaClass != null && schema.alive(schemaClass, version);
            if (expected == null) {
                if (!snapshot.omitsEmptyClasses() || !layouts.own(schemaClass, version).isEmpty()) {
                    problems.add(at + name + ": exists in the schema but not upstream");
                }
                continue;
            }
            if (!inSchema) {
                problems.add(at + name + ": exists upstream but not in the schema");
                continue;
            }
            SchemaClass parent = schema.parent(schemaClass, version);
            while (snapshot.omitsEmptyClasses() && parent != null && !snapshot.classes().containsKey(parent.name)) {
                parent = schema.parent(parent, version);
            }
            if (!Objects.equals(parent == null ? null : parent.name, expected.parent())) {
                problems.add(at + name + ": extends " + (parent == null ? "nothing" : parent.name)
                        + " in the schema but " + expected.parent() + " upstream");
            }
            List<String> actual = new ArrayList<>();
            for (Layouts.Slot slot : layouts.own(schemaClass, version)) {
                actual.add(slot.index() + " " + slot.field().name + " " + slot.field().type);
            }
            actual.sort(null);
            List<String> wanted = new ArrayList<>();
            for (Snapshot.SnapField field : expected.fields()) {
                wanted.add(field.index() + " " + field.name() + " " + field.type());
            }
            wanted.sort(null);
            if (!actual.equals(wanted)) {
                List<String> missing = new ArrayList<>(wanted);
                missing.removeAll(actual);
                List<String> extra = new ArrayList<>(actual);
                extra.removeAll(wanted);
                problems.add(at + name + ": fields differ; upstream only: " + missing + ", schema only: " + extra);
            }
        }
    }
}
