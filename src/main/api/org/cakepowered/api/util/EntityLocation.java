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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof EntityLocation)) {
			return false;
		}

		EntityLocation that = (EntityLocation) o;

		return dimension == that.dimension && Float.compare(that.yaw, yaw) == 0 &&
				Float.compare(that.pitch, pitch) == 0 && (position != null ?
				position.equals(that.position) : that.position == null);
	}

	@Override
	public int hashCode() {
		int result = dimension;
		result = 31 * result + (position != null ? position.hashCode() : 0);
		result = 31 * result + (yaw != +0.0f ? Float.floatToIntBits(yaw) : 0);
		result = 31 * result + (pitch != +0.0f ? Float.floatToIntBits(pitch) : 0);
		return result;
	}

	@Override
	public String toString() {
		return "EntityLocation{" +
				"dimension=" + dimension +
				", position=" + position +
				", yaw=" + yaw +
				", pitch=" + pitch +
				'}';
	}
}
