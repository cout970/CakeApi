package org.cakepowered.api.util;

import org.cakepowered.api.world.World;

public class PreciseLocation {

	protected World world;
	protected Vector3d position;
	protected float yaw;
	protected float pitch;
	
	public PreciseLocation(World w, Vector3d pos, float y, float p){
		world = w;
		position = pos.copy();
		yaw = y;
		pitch = p;
	}
	
	public PreciseLocation(World w, double x, double y, double z, float yaw, float pitch){
		this(w, new Vector3d(x, y, z), yaw, pitch);
	}
	

	public World getWorld() {
		return world;
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
		return new Location(getWorld(), getPosition().toVector3i());
	}
}
