package org.cakepowered.api.util;

import org.cakepowered.api.base.World;

public class Location {

	protected World world;
	protected Vector3d position;
	
	public Location(World w, int x, int y, int z){
		this(w, new Vector3d(x, y, z));
	}
	
	public Location(World w, Vector3d pos){
		world = w;
		pos = pos.copy();
	}

	public World getWorld() {
		return world;
	}

	public Vector3d getPosition() {
		return position;
	}
}
