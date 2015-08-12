package org.cakepowered.api.util;

public class Vector3d {

	public static final Vector3d NULL_VECTOR = new Vector3d(0, 0, 0);
	protected double x;
	protected double y;
	protected double z;

	public Vector3d(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d(int[] ar) {
		this(ar[0],ar[1],ar[2]);
	}

	public Vector3d getOpposite() {
		return new Vector3d(-x, -y, -z);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Vector3d)) {
			return false;
		} else {
			Vector3d vecInt = (Vector3d) obj;
			return this.getX() != vecInt.getX() ? false : (this.getY() != vecInt.getY() ? false : this.getZ() == vecInt.getZ());
		}
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}
	
	public String toString() {
		return "x: "+getX()+", y: "+getY()+", z: "+getZ();
	}
	
	public Vector3d multiply(double i) {
		x *= i;
		y *= i;
		z *= i;
		return this;
	}

	public Vector3d add(Vector3d v) {
		x += v.x;
		y += v.y;
		z += v.z;
		return this;
	}
	
	public Vector3d add(double a, double b, double c) {
		x += a;
		y += b;
		z += c;
		return this;
	}

	public Vector3d copy() {
		return new Vector3d(x,y,z);
	}
	
	public double[] doubleArray() {
		return new double[]{x,y,z};
	}

	public double squareDistance() {
		return x*x+y*y+z*z;
	}
	
	public double distance(Vector3d vector) {
		Vector3d line = vector.copy().add(getOpposite());
		return Math.sqrt(line.squareDistance());
	}
}
