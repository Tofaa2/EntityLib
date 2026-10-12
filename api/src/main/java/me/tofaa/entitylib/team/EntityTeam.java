package me.tofaa.entitylib.team;

import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams.CollisionRule;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams.NameTagVisibility;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams.OptionData;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams.ScoreBoardTeamInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerTeams.TeamMode;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.event.EventListener;
import me.tofaa.entitylib.event.EventNode;
import me.tofaa.entitylib.event.entity.EntityEvent;
import me.tofaa.entitylib.event.entity.EntityViewerAddEvent;
import me.tofaa.entitylib.event.entity.EntityViewerRemoveEvent;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class EntityTeam {

    private static final int FOLLOW_PRIORITY = 1000;

    private final String name;
    private final Set<String> entries = ConcurrentHashMap.newKeySet();
    private final Set<Integer> members = ConcurrentHashMap.newKeySet();
    private final Set<UUID> viewers = ConcurrentHashMap.newKeySet();
    private final EventNode<EntityEvent> node;
    private volatile Component displayName;
    private volatile Component prefix = Component.empty();
    private volatile Component suffix = Component.empty();
    private volatile NameTagVisibility nameTagVisibility = NameTagVisibility.ALWAYS;
    private volatile CollisionRule collisionRule = CollisionRule.ALWAYS;
    private volatile NamedTextColor color = NamedTextColor.WHITE;
    private volatile OptionData options = OptionData.NONE;

    private EntityTeam(String name) {
        this.name = name;
        this.displayName = Component.text(name);
        this.node = EventNode.type("team-" + name, EntityEvent.class, event -> members.contains(event.getEntity().getEntityId()));
        node.addListener(EventListener.builder(EntityViewerAddEvent.class)
            .priority(FOLLOW_PRIORITY)
            .ignoreCancelled(true)
            .handler(event -> addViewer(event.getViewer()))
            .build());
        node.addListener(EntityViewerRemoveEvent.class, event -> {
            if (event.isDisconnected()) {
                viewers.remove(event.getViewer());
            }
        });
        EntityLib.get().getEventNode().addChild(node);
    }

    public static @NotNull EntityTeam create(@NotNull String name) {
        return new EntityTeam(name);
    }

    public static @NotNull String entryOf(@NotNull WrapperEntity entity) {
        return entity instanceof WrapperPlayer ? ((WrapperPlayer) entity).getUsername() : entity.getUuid().toString();
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull Set<String> getEntries() {
        return Collections.unmodifiableSet(entries);
    }

    public @NotNull Set<UUID> getViewers() {
        return Collections.unmodifiableSet(viewers);
    }

    public @NotNull EntityTeam displayName(@NotNull Component displayName) {
        this.displayName = displayName;
        return update();
    }

    public @NotNull EntityTeam prefix(@NotNull Component prefix) {
        this.prefix = prefix;
        return update();
    }

    public @NotNull EntityTeam suffix(@NotNull Component suffix) {
        this.suffix = suffix;
        return update();
    }

    public @NotNull EntityTeam nameTagVisibility(@NotNull NameTagVisibility nameTagVisibility) {
        this.nameTagVisibility = nameTagVisibility;
        return update();
    }

    public @NotNull EntityTeam collisionRule(@NotNull CollisionRule collisionRule) {
        this.collisionRule = collisionRule;
        return update();
    }

    public @NotNull EntityTeam color(@NotNull NamedTextColor color) {
        this.color = color;
        return update();
    }

    public @NotNull EntityTeam options(@NotNull OptionData options) {
        this.options = options;
        return update();
    }

    public @NotNull EntityTeam addEntity(@NotNull WrapperEntity entity) {
        members.add(entity.getEntityId());
        for (UUID viewer : entity.getViewers()) {
            addViewer(viewer);
        }
        return addEntry(entryOf(entity));
    }

    public @NotNull EntityTeam removeEntity(@NotNull WrapperEntity entity) {
        members.remove(entity.getEntityId());
        return removeEntry(entryOf(entity));
    }

    public @NotNull EntityTeam addEntry(@NotNull String entry) {
        if (entries.add(entry)) {
            broadcast(new WrapperPlayServerTeams(name, TeamMode.ADD_ENTITIES, Optional.empty(), Collections.singletonList(entry)));
        }
        return this;
    }

    public @NotNull EntityTeam removeEntry(@NotNull String entry) {
        if (entries.remove(entry)) {
            broadcast(new WrapperPlayServerTeams(name, TeamMode.REMOVE_ENTITIES, Optional.empty(), Collections.singletonList(entry)));
        }
        return this;
    }

    public boolean addViewer(@NotNull UUID viewer) {
        if (!viewers.add(viewer)) {
            return false;
        }
        EntityLib.get().getPlatform().sendPacket(viewer,
            new WrapperPlayServerTeams(name, TeamMode.CREATE, info(), new ArrayList<>(entries)));
        return true;
    }

    public boolean removeViewer(@NotNull UUID viewer) {
        if (!viewers.remove(viewer)) {
            return false;
        }
        EntityLib.get().getPlatform().sendPacket(viewer,
            new WrapperPlayServerTeams(name, TeamMode.REMOVE, Optional.empty(), Collections.emptyList()));
        return true;
    }

    public void remove() {
        EntityLib.get().getEventNode().removeChild(node);
        for (UUID viewer : new ArrayList<>(viewers)) {
            removeViewer(viewer);
        }
        members.clear();
        entries.clear();
    }

    private ScoreBoardTeamInfo info() {
        return new ScoreBoardTeamInfo(displayName, prefix, suffix, nameTagVisibility, collisionRule, color, options);
    }

    private EntityTeam update() {
        broadcast(new WrapperPlayServerTeams(name, TeamMode.UPDATE, info(), Collections.emptyList()));
        return this;
    }

    private void broadcast(WrapperPlayServerTeams packet) {
        for (UUID viewer : viewers) {
            EntityLib.get().getPlatform().sendPacket(viewer, packet);
        }
    }

}
