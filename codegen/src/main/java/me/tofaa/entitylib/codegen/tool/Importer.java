package me.tofaa.entitylib.codegen.tool;

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

public final class Importer {

    private final Schema existing;
    private final Schema result;
    private final Versions versions;
    private final Set<Object> open = new HashSet<>();
    private List<Snapshot> snapshots = List.of();

    public Importer(Schema existing) {
        this.existing = existing;
        this.versions = existing.versions();
        this.result = new Schema(existing.versions(), existing.types());
    }

    public Schema run(List<Snapshot> snapshots) {
        if (snapshots.isEmpty()) {
            throw new SchemaException("There are no snapshots to import");
        }
        this.snapshots = snapshots;
        seed(snapshots.get(0).version());
        for (int i = 0; i < snapshots.size(); i++) {
            fold(i);
        }
        carryOver();
        return result;
    }

    private void seed(Versions.Version firstSnapshot) {
        if (firstSnapshot.ordinal() == 0) {
            return;
        }
        Versions.Version before = versions.list().get(firstSnapshot.ordinal() - 1);
        for (SchemaClass old : existing.classes()) {
            if (versions.get(old.since).ordinal() >= firstSnapshot.ordinal()) {
                continue;
            }
            SchemaClass seeded = new SchemaClass();
            seeded.name = old.name;
            seeded.since = old.since;
            if (existing.alive(old, before)) {
                open.add(seeded);
            } else {
                seeded.removed = old.removed;
            }
            for (ParentRef parent : old.parents) {
                if (versions.get(parent.since).ordinal() >= firstSnapshot.ordinal()) {
                    continue;
                }
                boolean alive = versions.alive(parent.since, parent.removed, before);
                seeded.parents.add(new ParentRef(parent.parent, parent.since, alive ? null : parent.removed));
            }
            for (SchemaField field : old.fields) {
                if (versions.get(field.since).ordinal() >= firstSnapshot.ordinal()) {
                    continue;
                }
                SchemaField copy = new SchemaField();
                copy.name = field.name;
                copy.type = field.type;
                copy.since = field.since;
                copy.index = field.index;
                copy.convert = field.convert;
                for (SchemaFlag flag : field.flags) {
                    copy.flags.add(flag.copy());
                }
                if (existing.alive(field, before)) {
                    open.add(copy);
                } else {
                    copy.removed = field.removed;
                }
                seeded.fields.add(copy);
            }
            result.add(seeded);
        }
    }

    private boolean assumedPresent(SchemaClass schemaClass, int index) {
        Snapshot snapshot = snapshots.get(index);
        if (schemaClass == null || !snapshot.omitsEmptyClasses() || !open.contains(schemaClass)
                || snapshot.classes().containsKey(schemaClass.name)) {
            return false;
        }
        for (int later = index + 1; later < snapshots.size(); later++) {
            if (snapshots.get(later).classes().containsKey(schemaClass.name)) {
                return true;
            }
        }
        return false;
    }

    private static ParentRef currentParent(SchemaClass schemaClass) {
        ParentRef current = null;
        for (ParentRef ref : schemaClass.parents) {
            if (ref.removed == null) {
                current = ref;
            }
        }
        return current;
    }

    private void fold(int index) {
        Snapshot snapshot = snapshots.get(index);
        String version = snapshot.version().name();
        for (Snapshot.SnapClass snap : snapshot.classes().values()) {
            SchemaClass schemaClass = result.get(snap.name());
            if (schemaClass == null) {
                schemaClass = new SchemaClass();
                schemaClass.name = snap.name();
                schemaClass.since = version;
                result.add(schemaClass);
                open.add(schemaClass);
            } else if (!open.contains(schemaClass)) {
                throw new SchemaException(snap.name() + " was removed in " + schemaClass.removed + " and exists again in "
                        + version + "; if these are different classes, rename one of them in upstream.yml");
            }
            foldParent(schemaClass, snap.parent(), index);
            foldFields(schemaClass, snap.fields(), version, snapshot.explicitIndexes());
        }
        for (SchemaClass schemaClass : result.classes()) {
            if (assumedPresent(schemaClass, index)) {
                for (SchemaField field : schemaClass.fields) {
                    if (open.remove(field)) {
                        field.removed = version;
                    }
                }
            } else if (open.contains(schemaClass) && !snapshot.classes().containsKey(schemaClass.name)) {
                open.remove(schemaClass);
                schemaClass.removed = version;
                for (ParentRef parent : schemaClass.parents) {
                    if (parent.removed == null) {
                        parent.removed = version;
                    }
                }
                for (SchemaField field : schemaClass.fields) {
                    if (open.remove(field)) {
                        field.removed = version;
                    }
                }
            }
        }
    }

    private void foldParent(SchemaClass schemaClass, String parent, int index) {
        String version = snapshots.get(index).version().name();
        ParentRef current = currentParent(schemaClass);
        if (current != null) {
            String nearest = current.parent;
            while (nearest != null && assumedPresent(result.get(nearest), index)) {
                ParentRef above = currentParent(result.get(nearest));
                nearest = above == null ? null : above.parent;
            }
            if (current.parent.equals(parent) || (nearest != null && nearest.equals(parent))) {
                return;
            }
        }
        if (current != null) {
            current.removed = version;
        }
        if (parent != null) {
            schemaClass.parents.add(new ParentRef(parent, version, null));
        }
    }

    private void foldFields(SchemaClass schemaClass, List<Snapshot.SnapField> fields, String version, boolean explicitIndexes) {
        List<SchemaField> entries = schemaClass.fields;
        Set<SchemaField> seen = new HashSet<>();
        int cursor = 0;
        for (Snapshot.SnapField field : fields) {
            int match = -1;
            for (int i = cursor; i < entries.size() && !explicitIndexes; i++) {
                SchemaField entry = entries.get(i);
                if (open.contains(entry) && entry.index == null && entry.name.equals(field.name())
                        && entry.type.equals(field.type())) {
                    match = i;
                    break;
                }
            }
            if (match >= 0) {
                seen.add(entries.get(match));
                cursor = match + 1;
                continue;
            }
            SchemaField entry = new SchemaField();
            entry.name = field.name();
            entry.type = field.type();
            entry.since = version;
            entry.index = explicitIndexes ? field.index() : null;
            entries.add(cursor, entry);
            open.add(entry);
            seen.add(entry);
            cursor++;
        }
        for (SchemaField entry : entries) {
            if (open.contains(entry) && !seen.contains(entry)) {
                open.remove(entry);
                entry.removed = version;
            }
        }
    }

    private void carryOver() {
        for (SchemaClass schemaClass : result.classes()) {
            SchemaClass old = existing.get(schemaClass.name);
            if (old != null && schemaClass.entities.isEmpty()) {
                schemaClass.entities.addAll(old.entities);
            }
        }
        Map<String, SchemaField> known = new HashMap<>();
        for (SchemaClass schemaClass : existing.classes()) {
            for (SchemaField field : schemaClass.fields) {
                if (!field.flags.isEmpty() || field.convert != null) {
                    known.putIfAbsent(schemaClass.name + "." + field.name + ":" + field.type, field);
                }
            }
        }
        for (SchemaClass schemaClass : result.classes()) {
            for (SchemaField field : schemaClass.fields) {
                SchemaField source = known.get(schemaClass.name + "." + field.name + ":" + field.type);
                if (source == null) {
                    continue;
                }
                if (field.convert == null) {
                    field.convert = source.convert;
                }
                if (field.flags.isEmpty()) {
                    for (SchemaFlag flag : source.flags) {
                        field.flags.add(flag.copy());
                    }
                }
            }
        }
    }

    public static List<String> describeChanges(Schema before, Schema after) {
        List<String> changes = new ArrayList<>();
        for (SchemaClass schemaClass : after.classes()) {
            SchemaClass old = before.get(schemaClass.name);
            if (old == null) {
                changes.add("+ class " + schemaClass.name + " (since " + schemaClass.since + ")");
                continue;
            }
            if (!Objects.equals(old.removed, schemaClass.removed) || !Objects.equals(old.since, schemaClass.since)) {
                changes.add("~ class " + schemaClass.name + ": " + old.since + ".." + old.removed + " -> "
                        + schemaClass.since + ".." + schemaClass.removed);
            }
            List<String> oldFields = describe(old);
            List<String> newFields = describe(schemaClass);
            for (String field : newFields) {
                if (!oldFields.contains(field)) {
                    changes.add("+ " + schemaClass.name + ": " + field);
                }
            }
            for (String field : oldFields) {
                if (!newFields.contains(field)) {
                    changes.add("- " + schemaClass.name + ": " + field);
                }
            }
        }
        for (SchemaClass old : before.classes()) {
            if (after.get(old.name) == null) {
                changes.add("- class " + old.name);
            }
        }
        return changes;
    }

    private static List<String> describe(SchemaClass schemaClass) {
        List<String> lines = new ArrayList<>();
        for (ParentRef parent : schemaClass.parents) {
            lines.add("extends " + parent.parent + " [" + parent.since + ".." + (parent.removed == null ? "" : parent.removed) + ")");
        }
        for (SchemaField field : schemaClass.fields) {
            lines.add(field.name + " " + field.type + " [" + field.since + ".." + (field.removed == null ? "" : field.removed) + ")");
        }
        return lines;
    }
}
