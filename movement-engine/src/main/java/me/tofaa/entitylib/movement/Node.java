package me.tofaa.entitylib.movement;

import com.github.retrooper.packetevents.protocol.world.Location;
import org.jetbrains.annotations.NotNull;

public class Node implements Comparable<Node> {
    private final Location position;
    private Node parent;
    private double gCost;
    private double hCost;
    private double fCost;

    public Node(@NotNull Location position) {
        this.position = position;
    }

    public Node(@NotNull Location position, Node parent, double gCost, double hCost) {
        this.position = position;
        this.parent = parent;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = gCost + hCost;
    }

    public @NotNull Location getPosition() {
        return position;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getGCost() {
        return gCost;
    }

    public void setGCost(double gCost) {
        this.gCost = gCost;
        this.fCost = gCost + hCost;
    }

    public double getHCost() {
        return hCost;
    }

    public void setHCost(double hCost) {
        this.hCost = hCost;
        this.fCost = gCost + hCost;
    }

    public double getFCost() {
        return fCost;
    }

    @Override
    public int compareTo(@NotNull Node other) {
        return Double.compare(this.fCost, other.fCost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return position.equals(node.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
