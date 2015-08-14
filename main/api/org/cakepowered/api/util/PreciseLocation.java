package org.cakepowered.api.util;

import org.cakepowered.api.world.World;

public class PreciseLocation {
	
	protected int dimension;
	protected Vector3d position;
	protected float yaw;
	protected float pitch;
	
	public PreciseLocation(int d, Vector3d pos, float y, float p){
		dimension = d;
		position = pos.copy();
		yaw = y;
		pitch = p;
	}
	
	public PreciseLocation(int d, double x, double y, double z, float yaw, float pitch){
		this(d, new Vector3d(x, y, z), yaw, pitch);
	}
	

	public int getDimension() {
		return dimension;
	}

	public Vector3d getPosition() {
		return position;
	}
	
	public double getX() {
		return position.getX();
	}

	public double getY() {
		return position.getY();
	}

	public double getZ() {
		return position.getZ();
	}
	
	public float getPitch(){
		return pitch;
	}
	public float getYaw(){
		return yaw;
	}

	public Location toLocation() {
		return new Location(dimension, getPosition().toVector3i());
	}
}
