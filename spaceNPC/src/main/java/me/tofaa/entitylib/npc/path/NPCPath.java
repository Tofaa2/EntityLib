package me.tofaa.entitylib.npc.path;

import com.github.retrooper.packetevents.protocol.world.Location;

import java.util.ArrayList;
import java.util.List;

public class NPCPath {

    private final List<Location> waypoints;
    private int currentIndex;
    private boolean looping;
    private double speed;
    private boolean paused;
    private boolean started;
    private float yaw = 0;

    public NPCPath() {
        this.waypoints = new ArrayList<>();
        this.currentIndex = 0;
        this.looping = true;
        this.speed = 4.0;
        this.paused = false;
        this.started = false;
    }

    public void addWaypoint(Location location) {
        waypoints.add(location);
    }

    public void removeWaypoint(int index) {
        if (index >= 0 && index < waypoints.size()) {
            waypoints.remove(index);
            if (currentIndex >= waypoints.size()) {
                currentIndex = 0;
            }
        }
    }

    public void clearWaypoints() {
        waypoints.clear();
        currentIndex = 0;
    }

    public Location getCurrentWaypoint() {
        if (waypoints.isEmpty()) {
            return null;
        }
        return waypoints.get(currentIndex);
    }

    public Location getNextWaypoint() {
        if (waypoints.isEmpty()) {
            return null;
        }
        
        int nextIndex = currentIndex + 1;
        if (nextIndex >= waypoints.size()) {
            nextIndex = looping ? 0 : -1;
        }
        
        if (nextIndex < 0) {
            return null;
        }
        
        return waypoints.get(nextIndex);
    }

    public void advanceToNext() {
        if (waypoints.isEmpty()) return;

        int previousIndex = currentIndex;
        Location currentWaypoint = waypoints.get(previousIndex);
        currentIndex++;
        if (currentIndex >= waypoints.size()) {
            currentIndex = looping ? 0 : waypoints.size() - 1;
        }

        if (currentIndex == previousIndex) return; // No yaw change
        Location nextWaypoint = waypoints.get(currentIndex);

        this.yaw = (float) Math.toDegrees(Math.atan2(
                -(nextWaypoint.getX() - currentWaypoint.getX()),
                nextWaypoint.getZ() - currentWaypoint.getZ()
        ));
    }

    public void setIndex(int index) {
        if (index >= 0 && index < waypoints.size()) {
            this.currentIndex = index;
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public List<Location> getWaypoints() {
        return new ArrayList<>(waypoints);
    }

    public int getWaypointCount() {
        return waypoints.size();
    }

    public boolean isLooping() {
        return looping;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isFinished() {
        return waypoints.isEmpty() || (!looping && currentIndex >= waypoints.size() - 1);
    }

    public void reset() {
        currentIndex = 0;
        started = false;
    }

    public float getYaw() {
        return yaw;
    }
}
