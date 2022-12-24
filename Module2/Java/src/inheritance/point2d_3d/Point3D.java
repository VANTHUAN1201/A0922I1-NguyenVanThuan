package inheritance.point2d_3d;

import inheritance.point2d_3d.Point2D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D() {
        super();
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float X, float Y, float Z) {
        setXY(X, Y);
        this.z = Z;
    }

    public float[] getXYZ() {
        float[] arr = {getX(), getY(), getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" + getX() + "," + getY() +","+getZ()+"}";
    }
}
