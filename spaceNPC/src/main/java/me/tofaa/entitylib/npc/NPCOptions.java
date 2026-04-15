package me.tofaa.entitylib.npc;

import me.tofaa.entitylib.npc.interactions.InteractionAction;
import me.tofaa.entitylib.npc.interactions.InteractionType;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPCOptions {

    private Component displayName;
    private boolean showNameTag = true;
    private boolean hasDisplayName = false;
    private boolean lookAtPlayers = false;
    private boolean lookAtPlayersPerPlayer = false;
    private boolean lookAtPath = true;
    private boolean lookForward = true;
    private boolean collides = true;
    private boolean gravity = true;
    private boolean invulnerable = false;
    private boolean silent = false;
    private boolean clampToGround = true;
    private boolean permanentlyVisible = false;
    private boolean sitting = false;
    private boolean swimming = false;
    private boolean crouching = false;
    private double viewDistance = 128.0;
    private double movementSpeed = 4.0;
    private Map<InteractionType, List<InteractionAction>> interactions = new HashMap<>();

    public NPCOptions() {
    }

    public @NotNull NPCOptions displayName(@Nullable Component name) {
        this.displayName = name;
        this.hasDisplayName = name != null;
        return this;
    }

    public @NotNull NPCOptions showNameTag(boolean show) {
        this.showNameTag = show;
        return this;
    }

    public @NotNull NPCOptions lookAtPlayers(boolean look) {
        this.lookAtPlayers = look;
        return this;
    }

    public @NotNull NPCOptions lookAtPlayersPerPlayer(boolean look) {
        this.lookAtPlayersPerPlayer = look;
        return this;
    }

    public @NotNull NPCOptions lookAtPath(boolean look) {
        this.lookAtPath = look;
        return this;
    }

    public @NotNull NPCOptions lookForward(boolean look) {
        this.lookForward = look;
        return this;
    }

    public @NotNull NPCOptions collides(boolean collide) {
        this.collides = collide;
        return this;
    }

    public @NotNull NPCOptions gravity(boolean grav) {
        this.gravity = grav;
        return this;
    }

    public @NotNull NPCOptions invulnerable(boolean invuln) {
        this.invulnerable = invuln;
        return this;
    }

    public @NotNull NPCOptions silent(boolean silent) {
        this.silent = silent;
        return this;
    }

    public @NotNull NPCOptions clampToGround(boolean clamp) {
        this.clampToGround = clamp;
        return this;
    }

    public @NotNull NPCOptions permanentlyVisible(boolean visible) {
        this.permanentlyVisible = visible;
        return this;
    }

    public @NotNull NPCOptions sitting(boolean sitting) {
        this.sitting = sitting;
        return this;
    }

    public @NotNull NPCOptions swimming(boolean swimming) {
        this.swimming = swimming;
        return this;
    }

    public @NotNull NPCOptions crouching(boolean crouching) {
        this.crouching = crouching;
        return this;
    }

    public @NotNull NPCOptions viewDistance(double distance) {
        this.viewDistance = distance;
        return this;
    }

    public @NotNull NPCOptions movementSpeed(double speed) {
        this.movementSpeed = speed;
        return this;
    }

    public @NotNull NPCOptions addInteraction(@NotNull InteractionType type, @NotNull InteractionAction action) {
        this.interactions.computeIfAbsent(type, k -> new ArrayList<>()).add(action);
        return this;
    }

    public @NotNull NPCOptions removeInteraction(@NotNull InteractionType type, int index) {
        List<InteractionAction> actions = this.interactions.get(type);
        if (actions != null && index >= 0 && index < actions.size()) {
            actions.remove(index);
            if (actions.isEmpty()) {
                this.interactions.remove(type);
            }
        }
        return this;
    }

    public @NotNull NPCOptions clearInteractions(@NotNull InteractionType type) {
        this.interactions.remove(type);
        return this;
    }

    public @NotNull NPCOptions clearAllInteractions() {
        this.interactions.clear();
        return this;
    }

    public @NotNull List<InteractionAction> getInteractions(@NotNull InteractionType type) {
        return interactions.getOrDefault(type, new ArrayList<>());
    }

    public @NotNull Map<InteractionType, List<InteractionAction>> getAllInteractions() {
        return interactions;
    }

    public void setAllInteractions(@NotNull Map<InteractionType, List<InteractionAction>> interactions) {
        this.interactions = interactions != null ? interactions : new HashMap<>();
    }

    public boolean hasAnyInteraction() {
        return !interactions.isEmpty();
    }

    public @Nullable Component getDisplayName() {
        return displayName;
    }

    public boolean isShowNameTag() {
        return showNameTag;
    }

    public boolean hasDisplayName() {
        return hasDisplayName;
    }

    public boolean isLookAtPlayers() {
        return lookAtPlayers;
    }

    public boolean isLookAtPlayersPerPlayer() {
        return lookAtPlayersPerPlayer;
    }

    public boolean isLookAtPath() {
        return lookAtPath;
    }

    public boolean isLookForward() {
        return lookForward;
    }

    public boolean isCollides() {
        return collides;
    }

    public boolean isGravity() {
        return gravity;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }

    public boolean isSilent() {
        return silent;
    }

    public boolean isClampToGround() {
        return clampToGround;
    }

    public boolean isPermanentlyVisible() {
        return permanentlyVisible;
    }

    public boolean isSitting() {
        return sitting;
    }

    public boolean isSwimming() {
        return swimming;
    }

    public boolean isCrouching() {
        return crouching;
    }

    public double getViewDistance() {
        return viewDistance;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }
}
