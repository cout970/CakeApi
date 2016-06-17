package org.cakepowered.api.util;

public final class EntityLocation {

	protected int dimension;
	protected Vector3 position;
	protected float yaw;
	protected float pitch;

	public EntityLocation(int d, Vector3 pos, float y, float p) {
		dimension = d;
		position = pos;
		yaw = y;
		pitch = p;
	}

	public EntityLocation(int d, double x, double y, double z, float yaw, float pitch) {
		this(d, new Vector3(x, y, z), yaw, pitch);
	}

	public int getDimension() {
		return dimension;
	}

	public Vector3 getPosition() {
		return position;
	}

	public double getX() {
		return position.getXd();
	}

	public double getY() {
		return position.getYd();
	}

	public double getZ() {
		return position.getZd();
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public BlockLocation toBlockLocation() {
		return new BlockLocation(dimension, getPosition());
	}
}
