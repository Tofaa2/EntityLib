package me.tofaa.entitylib.codegen;

import me.tofaa.entitylib.codegen.model.*;

import java.util.*;
import java.util.stream.Collectors;

public final class FieldAnalyzer {

    public List<CrossVersionField> analyze(List<VersionData> versions) {
        Map<String, Map<String, List<FieldEntry>>> byEntityAndField = new LinkedHashMap<>();

        for (VersionData vd : versions) {
            for (Map.Entry<String, EntitySchema> entry : vd.entities().entrySet()) {
                String entityName = entry.getKey();
                EntitySchema schema = entry.getValue();
                int proto = vd.protocolVersion();

                for (FieldDef field : schema.fields()) {
                    byEntityAndField
                            .computeIfAbsent(entityName, k -> new LinkedHashMap<>())
                            .computeIfAbsent(field.fieldName(), k -> new ArrayList<>())
                            .add(new FieldEntry(proto, field));
                }
            }
        }

        List<CrossVersionField> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, List<FieldEntry>>> entityEntry : byEntityAndField.entrySet()) {
            String entityName = entityEntry.getKey();
            for (Map.Entry<String, List<FieldEntry>> fieldEntry : entityEntry.getValue().entrySet()) {
                String fieldName = fieldEntry.getKey();
                List<FieldEntry> entries = fieldEntry.getValue();
                entries.sort(Comparator.comparingInt(FieldEntry::protocol));

                List<VersionRange> ranges = buildRanges(entries);
                result.add(new CrossVersionField(entityName, fieldName, ranges));
            }
        }

        return result;
    }

    private List<VersionRange> buildRanges(List<FieldEntry> entries) {
        List<VersionRange> ranges = new ArrayList<>();
        if (entries.isEmpty()) return ranges;

        FieldEntry current = entries.get(0);
        int rangeStart = current.protocol;

        for (int i = 1; i < entries.size(); i++) {
            FieldEntry next = entries.get(i);
            if (current.index != next.index || !current.dataType.equals(next.dataType)) {
                ranges.add(new VersionRange(rangeStart, entries.get(i - 1).protocol, current.index, current.dataType));
                current = next;
                rangeStart = next.protocol;
            }
        }
        ranges.add(new VersionRange(rangeStart, Integer.MAX_VALUE, current.index, current.dataType));
        return ranges;
    }

    private record FieldEntry(int protocol, int index, String dataType, String defaultValue) {
        FieldEntry(int protocol, FieldDef field) {
            this(protocol, field.index(), field.dataType(), field.defaultValue());
        }
    }
}
