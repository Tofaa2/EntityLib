package me.tofaa.entitylib.bb.animation;


import com.github.retrooper.packetevents.util.Vector3d;

public interface FrameProvider {
    Vector3d RotationMul = new Vector3d(-1, -1, 1);
    Vector3d TranslationMul = new Vector3d(-1, 1, 1);

    Vector3d getFrame(int tick);
}