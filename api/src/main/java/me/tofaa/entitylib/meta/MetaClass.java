package me.tofaa.entitylib.meta;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MetaClass {

    private final String name;
    private final int fromProtocol;
    private final int toProtocol;
    private final List<Parent> parents;
    private final List<MetaField<?>> ownFields;
    private final List<EntityType> entityTypes;
    private final Map<Integer, List<MetaField<?>>> layouts = new ConcurrentHashMap<>();
    private volatile Set<MetaField<?>> allFields;

    private MetaClass(String name, int fromProtocol, int toProtocol, List<Parent> parents, List<MetaField<?>> ownFields,
                      List<EntityType> entityTypes) {
        this.name = name;
        this.fromProtocol = fromProtocol;
        this.toProtocol = toProtocol;
        this.parents = parents;
        this.ownFields = Collections.unmodifiableList(ownFields);
        this.entityTypes = Collections.unmodifiableList(entityTypes);
    }

    public @NotNull String name() {
        return name;
    }

    public boolean existsIn(int protocolVersion) {
        return protocolVersion >= fromProtocol && protocolVersion < toProtocol;
    }

    public @Nullable MetaClass parent(int protocolVersion) {
        for (Parent parent : parents) {
            if (protocolVersion >= parent.fromProtocol && protocolVersion < parent.toProtocol) {
                return parent.metaClass;
            }
        }
        return null;
    }

    public @NotNull List<MetaField<?>> ownFields() {
        return ownFields;
    }

    public @NotNull List<EntityType> entityTypes() {
        return entityTypes;
    }

    public @NotNull List<MetaField<?>> fields(int protocolVersion) {
        return layouts.computeIfAbsent(protocolVersion, this::computeLayout);
    }

    private List<MetaField<?>> computeLayout(int protocolVersion) {
        if (!existsIn(protocolVersion)) {
            return Collections.emptyList();
        }
        List<MetaField<?>> fields = new ArrayList<>();
        MetaClass parent = parent(protocolVersion);
        if (parent != null) {
            fields.addAll(parent.fields(protocolVersion));
        }
        for (MetaField<?> field : ownFields) {
            if (field.existsIn(protocolVersion)) {
                fields.add(field);
            }
        }
        fields.sort((a, b) -> Integer.compare(a.resolve(protocolVersion).index(), b.resolve(protocolVersion).index()));
        return Collections.unmodifiableList(fields);
    }

    public @Nullable MetaField<?> fieldAt(int protocolVersion, int index) {
        for (MetaField<?> field : fields(protocolVersion)) {
            if (field.resolve(protocolVersion).index() == index) {
                return field;
            }
        }
        return null;
    }

    public boolean owns(@NotNull MetaField<?> field) {
        Set<MetaField<?>> fields = allFields;
        if (fields == null) {
            fields = Collections.newSetFromMap(new IdentityHashMap<>());
            collectFields(fields, Collections.newSetFromMap(new IdentityHashMap<>()));
            allFields = fields;
        }
        return fields.contains(field);
    }

    private void collectFields(Set<MetaField<?>> fields, Set<MetaClass> visited) {
        if (!visited.add(this)) {
            return;
        }
        fields.addAll(ownFields);
        for (Parent parent : parents) {
            parent.metaClass.collectFields(fields, visited);
        }
    }

    public boolean isA(@NotNull MetaClass other, int protocolVersion) {
        for (MetaClass current = this; current != null; current = current.parent(protocolVersion)) {
            if (current == other) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    public static @NotNull Map<EntityType, List<MetaClass>> indexByEntityType(@NotNull Collection<MetaClass> classes) {
        Map<EntityType, List<MetaClass>> index = new HashMap<>();
        for (MetaClass metaClass : classes) {
            for (EntityType entityType : metaClass.entityTypes) {
                index.computeIfAbsent(entityType, type -> new ArrayList<>()).add(metaClass);
            }
        }
        return index;
    }

    public static @NotNull List<MetaClass> findAll(@NotNull Map<EntityType, List<MetaClass>> index, @NotNull EntityType entityType) {
        for (EntityType type = entityType; type != null; type = type.getParent().orElse(null)) {
            List<MetaClass> classes = index.get(type);
            if (classes != null && !classes.isEmpty()) {
                return Collections.unmodifiableList(classes);
            }
        }
        return Collections.emptyList();
    }

    public static @Nullable MetaClass find(@NotNull Map<EntityType, List<MetaClass>> index, @NotNull EntityType entityType,
                                           int protocolVersion) {
        for (EntityType type = entityType; type != null; type = type.getParent().orElse(null)) {
            for (MetaClass metaClass : index.getOrDefault(type, Collections.emptyList())) {
                if (metaClass.existsIn(protocolVersion)) {
                    return metaClass;
                }
            }
        }
        return null;
    }

    public static @NotNull Builder builder(@NotNull String name) {
        return new Builder(name);
    }

    public static final class Builder {
        private final String name;
        private int fromProtocol = 0;
        private int toProtocol = Integer.MAX_VALUE;
        private final List<Parent> parents = new ArrayList<>();
        private final List<MetaField<?>> fields = new ArrayList<>();
        private final List<EntityType> entityTypes = new ArrayList<>();

        Builder(String name) {
            this.name = name;
        }

        public @NotNull Builder lifetime(int fromProtocol, int toProtocol) {
            this.fromProtocol = fromProtocol;
            this.toProtocol = toProtocol;
            return this;
        }

        public @NotNull Builder parent(int fromProtocol, int toProtocol, @NotNull MetaClass parent) {
            parents.add(new Parent(fromProtocol, toProtocol, parent));
            return this;
        }

        public @NotNull Builder fields(@NotNull MetaField<?>... fields) {
            this.fields.addAll(Arrays.asList(fields));
            return this;
        }

        public @NotNull Builder entityTypes(@NotNull EntityType... entityTypes) {
            this.entityTypes.addAll(Arrays.asList(entityTypes));
            return this;
        }

        public @NotNull MetaClass build() {
            return new MetaClass(name, fromProtocol, toProtocol, new ArrayList<>(parents), new ArrayList<>(fields),
                    new ArrayList<>(entityTypes));
        }
    }

    private static final class Parent {
        final int fromProtocol;
        final int toProtocol;
        final MetaClass metaClass;

        Parent(int fromProtocol, int toProtocol, MetaClass metaClass) {
            this.fromProtocol = fromProtocol;
            this.toProtocol = toProtocol;
            this.metaClass = metaClass;
        }
    }
}
