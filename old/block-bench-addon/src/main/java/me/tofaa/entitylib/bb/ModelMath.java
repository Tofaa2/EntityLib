package me.tofaa.entitylib.bb;

import com.github.retrooper.packetevents.util.Vector3d;

class Matrix3 {
    double x1, x2, x3;
    double y1, y2, y3;
    double z1, z2, z3;

    Matrix3(double x1, double x2, double x3, double y1, double y2, double y3, double z1, double z2, double z3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.z1 = z1;
        this.z2 = z2;
        this.z3 = z3;
    }

    Matrix3 mul(Matrix3 matrix3) {
        double x1 = this.x1 * matrix3.x1 + this.x2 * matrix3.y1 + this.x3 * matrix3.z1;
        double x2 = this.x1 * matrix3.x2 + this.x2 * matrix3.y2 + this.x3 * matrix3.z2;
        double x3 = this.x1 * matrix3.x3 + this.x2 * matrix3.y3 + this.x3 * matrix3.z3;

        double y1 = this.y1 * matrix3.x1 + this.y2 * matrix3.y1 + this.y3 * matrix3.z1;
        double y2 = this.y1 * matrix3.x2 + this.y2 * matrix3.y2 + this.y3 * matrix3.z2;
        double y3 = this.y1 * matrix3.x3 + this.y2 * matrix3.y3 + this.y3 * matrix3.z3;

        double z1 = this.z1 * matrix3.x1 + this.z2 * matrix3.y1 + this.z3 * matrix3.z1;
        double z2 = this.z1 * matrix3.x2 + this.z2 * matrix3.y2 + this.z3 * matrix3.z2;
        double z3 = this.z1 * matrix3.x3 + this.z2 * matrix3.y3 + this.z3 * matrix3.z3;

        return new Matrix3(x1, x2, x3, y1, y2, y3, z1, z2, z3);
    }

    Vector3d mul(Vector3d vec) {
        double vx = vec.getX() * x1 + vec.getY() * x2 + vec.getZ() * x3;
        double vy = vec.getX() * y1 + vec.getY() * y2 + vec.getZ() * y3;
        double vz = vec.getX() * z1 + vec.getY() * z2 + vec.getZ() * z3;

        return new Vector3d(vx, vy, vz);
    }
}

public class ModelMath {
    private static final float DEGREE = 0.017453292519943295F;
    private static final float RADIAN = 57.29577951308232F;

    static Vector3d toRadians(Vector3d vector) {
        return vector.multiply(DEGREE);
    }

    static Vector3d toDegrees(Vector3d vector) {
        return vector.multiply(RADIAN);
    }

    public static Vector3d rotate(Vector3d vector, Vector3d rotation) {
        Vector3d rot = toRadians(rotation);

        double rotX = rot.getX();
        double rotY = rot.getY();
        double rotZ = rot.getZ();

        double cosX = Math.cos(rotX);
        double sinX = Math.sin(rotX);
        double cosY = Math.cos(rotY);
        double sinY = Math.sin(rotY);
        double cosZ = Math.cos(rotZ);
        double sinZ = Math.sin(rotZ);

        Matrix3 rotMatrixX = new Matrix3(1, 0, 0, 0, cosX, -sinX, 0, sinX, cosX);
        Matrix3 rotMatrixY = new Matrix3(cosY, 0, sinY, 0, 1, 0, -sinY, 0, cosY);
        Matrix3 rotMatrixZ = new Matrix3(cosZ, -sinZ, 0, sinZ, cosZ, 0, 0, 0, 1);

        return rotMatrixZ.mul(rotMatrixY).mul(rotMatrixX).mul(vector);
    }
}