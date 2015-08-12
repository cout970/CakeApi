package org.cakepowered.api.util;

import org.cakepowered.api.world.World;

public class PreciseLocation {

	protected World world;
	protected Vector3d position;
	
	public PreciseLocation(World w, double x, double y, double z){
		this(w, new Vector3d(x, y, z));
	}
	
	public PreciseLocation(World w, Vector3d pos){
		world = w;
		pos = pos.copy();
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
}
