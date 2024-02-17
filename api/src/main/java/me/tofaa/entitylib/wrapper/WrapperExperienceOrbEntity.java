package me.tofaa.entitylib.wrapper;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import me.tofaa.entitylib.meta.EntityMeta;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WrapperExperienceOrbEntity extends WrapperEntity {

    private short experience;
    private Location slideTowards;

    public WrapperExperienceOrbEntity(int entityId, @NotNull UUID uuid, EntityType entityType, EntityMeta meta) {
        super(entityId, uuid, entityType, meta);
    }

    /**
     * Applies a slight slide motion towards the given location.
     * <p>
     *     For this to work, this method needs to be called every tick until the entity reaches the location.
     *     We don't have ticking or updating in this library, so you'll have to do it yourself.
     *     This is an attempt to mimmick the vanilla behavior.
     * </p>
     */
    @Override
    public void tick(long time) {
        super.tick(time);
        if (hasNoGravity()) {
            setVelocity(getVelocity().add(0, -0.3f, 0));
        }

        double d = 8.0;
        Vector3d distance = new Vector3d(slideTowards.getX() - getX(), slideTowards.getY() - getY(), slideTowards.getZ() - getZ());
        double length = distance.length();
        if (length < 8.0) {
            double f = 1 - (length / 8);
            setVelocity(getVelocity().add(distance.normalize().multiply(f * f * 0.1)));
        }
        float g = 0.98f;
        if (this.isOnGround()) {
            g = 0.6f * 0.98f;
        }
        setVelocity(getVelocity().multiply(g, 0.98f, g));
        if (isOnGround()) {
            setVelocity(getVelocity().multiply(1, -0.9f, 1));
        }
    }

    public Location getSlideTowards() {
        return slideTowards;
    }

    public void setSlideTowards(Location slideTowards) {
        this.slideTowards = slideTowards;
    }

    public short getExperience() {
        return experience;
    }



    public void setExperience(short experience) {
        getViewers().forEach(this::removeViewer);
        this.experience = experience;
        getViewers().forEach(this::addViewer);
    }

}
