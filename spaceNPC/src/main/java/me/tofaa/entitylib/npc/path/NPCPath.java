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
                int previousIndex = currentIndex;
                currentIndex = 0;
                recomputeYaw(previousIndex, currentIndex);
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
        currentIndex++;
        if (currentIndex >= waypoints.size()) {
            currentIndex = looping ? 0 : waypoints.size() - 1;
        }

        recomputeYaw(previousIndex, currentIndex);
    }

    private void recomputeYaw(int fromIndex, int toIndex) {
        if (waypoints.size() < 2) return;
        if (fromIndex == toIndex) return;
        if (fromIndex < 0 || fromIndex >= waypoints.size()) return;
        if (toIndex < 0 || toIndex >= waypoints.size()) return;

        Location from = waypoints.get(fromIndex);
        Location to = waypoints.get(toIndex);

        this.yaw = (float) Math.toDegrees(Math.atan2(
                -(to.getX() - from.getX()),
                to.getZ() - from.getZ()
        ));
    }

    public void setIndex(int index) {
        if (index >= 0 && index < waypoints.size()) {
            int previousIndex = this.currentIndex;
            this.currentIndex = index;
            recomputeYaw(previousIndex, currentIndex);
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
        int previousIndex = currentIndex;
        currentIndex = 0;
        started = false;
        recomputeYaw(previousIndex, currentIndex);
    }

    public float getYaw() {
        return yaw;
    }
}
