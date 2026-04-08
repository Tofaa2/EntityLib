package me.tofaa.entitylib.npc;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    private double viewDistance = 128.0;
    private double movementSpeed = 4.0;

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

    public @NotNull NPCOptions viewDistance(double distance) {
        this.viewDistance = distance;
        return this;
    }

    public @NotNull NPCOptions movementSpeed(double speed) {
        this.movementSpeed = speed;
        return this;
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

    public double getViewDistance() {
        return viewDistance;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }
}
