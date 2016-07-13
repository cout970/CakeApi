package org.cakepowered.api.util;

/**
 * Created by cout970 on 17/06/2016.
 */
public class Vector3 {

    public static final Vector3 ORIGIN = new Vector3();

    private final Number x;
    private final Number y;
    private final Number z;

    public Vector3() {
        this(0, 0, 0);
    }

    public Vector3(Number x, Number y, Number z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }

    public Number getZ() {
        return z;
    }

    public int getXi() {
        return x.intValue();
    }

    public int getYi() {
        return y.intValue();
    }

    public int getZi() {
        return z.intValue();
    }

    public float getXf() {
        return x.floatValue();
    }

    public float getYf() {
        return y.floatValue();
    }

    public float getZf() {
        return z.floatValue();
    }

    public double getXd() {
        return x.doubleValue();
    }

    public double getYd() {
        return y.doubleValue();
    }

    public double getZd() {
        return z.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector3)) {
            return false;
        }

        Vector3 vector3 = (Vector3) o;

        return x != null ? x.equals(vector3.x) : vector3.x == null && (y != null ? y.equals(vector3.y) :
                vector3.y == null && (z != null ? z.equals(vector3.z) : vector3.z == null));
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (z != null ? z.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Vector3 add(Number n) {
        return new Vector3(
                x.doubleValue() + n.doubleValue(),
                y.doubleValue() + n.doubleValue(),
                z.doubleValue() + n.doubleValue()
        );
    }

    public Vector3 add(Number nx, Number ny, Number nz) {
        return new Vector3(
                x.doubleValue() + nx.doubleValue(),
                y.doubleValue() + ny.doubleValue(),
                z.doubleValue() + nz.doubleValue()
        );
    }

    public Vector3 add(Vector3 n) {
        return new Vector3(
                x.doubleValue() + n.x.doubleValue(),
                y.doubleValue() + n.y.doubleValue(),
                z.doubleValue() + n.z.doubleValue()
        );
    }

    public Vector3 sub(Number n) {
        return new Vector3(
                x.doubleValue() - n.doubleValue(),
                y.doubleValue() - n.doubleValue(),
                z.doubleValue() - n.doubleValue()
        );
    }

    public Vector3 sub(Number nx, Number ny, Number nz) {
        return new Vector3(
                x.doubleValue() - nx.doubleValue(),
                y.doubleValue() - ny.doubleValue(),
                z.doubleValue() - nz.doubleValue()
        );
    }

    public Vector3 sub(Vector3 n) {
        return new Vector3(
                x.doubleValue() - n.x.doubleValue(),
                y.doubleValue() - n.y.doubleValue(),
                z.doubleValue() - n.z.doubleValue()
        );
    }

    public Vector3 mul(Number n) {
        return new Vector3(
                x.doubleValue() * n.doubleValue(),
                y.doubleValue() * n.doubleValue(),
                z.doubleValue() * n.doubleValue()
        );
    }

    public Vector3 mul(Number nx, Number ny, Number nz) {
        return new Vector3(
                x.doubleValue() * nx.doubleValue(),
                y.doubleValue() * ny.doubleValue(),
                z.doubleValue() * nz.doubleValue()
        );
    }

    public Vector3 mul(Vector3 n) {
        return new Vector3(
                x.doubleValue() * n.x.doubleValue(),
                y.doubleValue() * n.y.doubleValue(),
                z.doubleValue() * n.z.doubleValue()
        );
    }

    public Vector3 div(Number n) {
        return new Vector3(
                x.doubleValue() / n.doubleValue(),
                y.doubleValue() / n.doubleValue(),
                z.doubleValue() / n.doubleValue()
        );
    }

    public Vector3 div(Number nx, Number ny, Number nz) {
        return new Vector3(
                x.doubleValue() / nx.doubleValue(),
                y.doubleValue() / ny.doubleValue(),
                z.doubleValue() / nz.doubleValue()
        );
    }

    public Vector3 div(Vector3 n) {
        return new Vector3(
                x.doubleValue() / n.x.doubleValue(),
                y.doubleValue() / n.y.doubleValue(),
                z.doubleValue() / n.z.doubleValue()
        );
    }

    public Vector3 toRadians() {
        return new Vector3(
                Math.toRadians(getXd()),
                Math.toRadians(getYd()),
                Math.toRadians(getZd())
        );
    }

    public Vector3 toDegrees() {
        return new Vector3(
                Math.toDegrees(getXd()),
                Math.toDegrees(getYd()),
                Math.toDegrees(getZd())
        );
    }

    public Vector3 opposite() {
        return new Vector3(-getXd(), -getYd(), -getZd());
    }

    public Vector3 inverse() {
        return new Vector3(1 / getXd(), 1 / getYd(), 1 / getZd());
    }

    public Vector3 move(Direction dir) {
        return new Vector3(
                getXd() + dir.getOffsetX(),
                getYd() + dir.getOffsetY(),
                getZd() + dir.getOffsetZ()
        );
    }

    public Vector3 move(Direction dir, int times) {
        return new Vector3(
                getXd() + dir.getOffsetX() * times,
                getYd() + dir.getOffsetY() * times,
                getZd() + dir.getOffsetZ() * times
        );
    }

    public double magSquared() {
        return getXd() * getXd() + getYd() * getYd() + getZd() * getZd();
    }

    public double mag() {
        return Math.sqrt(magSquared());
    }

    public double distanceSquared(Vector3 v) {
        double i = getXd() - v.getXd();
        double j = getYd() - v.getYd();
        double k = getZd() - v.getZd();
        return i * i + j * j + k * k;
    }

    public double distance(Vector3 v) {
        return Math.sqrt(distanceSquared(v));
    }

    public Vector3 normalize() {
        double mag = mag();
        if (mag == 0.0) { return new Vector3(); }
        return new Vector3(
                getXd() / mag,
                getYd() / mag,
                getZd() / mag
        );
    }

    public double dot(Vector3 v) {
        return v.getXd() * getXd() + v.getYd() * getYd() + v.getZd() * getZd();
    }

    public Vector3 cross(Vector3 v) {
        return new Vector3(
                (getYd() * v.getZd()) - (getZd() * v.getYd()),
                (getZd() * v.getXd()) - (getXd() * v.getZd()),
                (getXd() * v.getYd()) - (getYd() * v.getXd())
        );
    }

    public double angle(Vector3 vec) {
        double mul = mag() * vec.mag();
        if (mul == 0) { return 0; }
        return Math.acos(dot(vec) / mul);
    }

    public Vector3 rotateX(double angle) {
        Vector3[] rotationMatrix = {
                new Vector3(1, 0, 0),
                new Vector3(0, Math.cos(angle), -Math.sin(angle)),
                new Vector3(0, Math.sin(angle), Math.cos(angle))
        };

        double i, j, k;
        i = dot(rotationMatrix[0]);
        j = dot(rotationMatrix[1]);
        k = dot(rotationMatrix[2]);
        return new Vector3(i, j, k);
    }

    public Vector3 rotateY(double angle) {
        Vector3[] rotationMatrix = {
                new Vector3(Math.cos(angle), 0, Math.sin(angle)),
                new Vector3(0, 1, 0),
                new Vector3(-Math.sin(angle), 0, Math.cos(angle))
        };

        double i, j, k;
        i = dot(rotationMatrix[0]);
        j = dot(rotationMatrix[1]);
        k = dot(rotationMatrix[2]);
        return new Vector3(i, j, k);
    }

    public Vector3 rotateZ(double angle) {
        Vector3[] rotationMatrix = {
                new Vector3(Math.cos(angle), -Math.sin(angle), 0),
                new Vector3(Math.sin(angle), Math.cos(angle), 0),
                new Vector3(0, 0, 1)};

        double i, j, k;
        i = dot(rotationMatrix[0]);
        j = dot(rotationMatrix[1]);
        k = dot(rotationMatrix[2]);
        return new Vector3(i, j, k);
    }

    public Vector3 rotateCustom(double angle, Vector3 axis) {
        if (axis.hasZeroLenght()) { return this; }

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        Vector3[] rotationMatrix = {
                new Vector3(cos + axis.getXd() * axis.getXd() * (1 - cos), axis.getYd() * axis.getXd() * (1 - cos) + axis.getZd() * sin, axis.getZd() * axis.getXd() * (1 - cos) - axis.getYd() * sin),
                new Vector3(axis.getXd() * axis.getYd() * (1 - cos) - axis.getZd() * sin, cos + axis.getYd() * axis.getYd() * (1 - cos), axis.getZd() * axis.getYd() * (1 - cos) + axis.getZd() * sin),
                new Vector3(axis.getXd() * axis.getZd() * (1 - cos) + axis.getYd() * sin, axis.getYd() * axis.getZd() * (1 - cos), cos + axis.getZd() * axis.getZd() * (1 - cos))
        };

        double i, j, k;
        i = dot(rotationMatrix[0]);
        j = dot(rotationMatrix[1]);
        k = dot(rotationMatrix[2]);
        return new Vector3(i, j, k);
    }

    public boolean hasZeroLenght(){
        return getXd() == 0 && getYd() == 0 && getZd() == 0;
    }
}
