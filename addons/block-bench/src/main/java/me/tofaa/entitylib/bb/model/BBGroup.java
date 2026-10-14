package me.tofaa.entitylib.bb.model;

import me.tofaa.entitylib.display.math.Vec3;

import java.util.List;
import java.util.UUID;

public record BBGroup(UUID uuid, String name, Vec3 origin, Vec3 rotation, boolean visible, List<BBGroup> groups,
                      List<BBCube> cubes) {
}
