package org.cakepowered.api.util;

import org.cakepowered.api.world.World;
import org.cakepowered.api.world.tileentity.TileEntity;

public class Location {

	protected World world;
	protected Vector3i position;
	
	public Location(World w, int x, int y, int z){
		this(w, new Vector3i(x, y, z));
	}
	
	public Location(World w, Vector3i pos){
		world = w;
		pos = pos.copy();
	}

	public World getWorld() {
		return world;
	}

	public Vector3i getPosition() {
		return position;
	}
	
	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}

	public int getZ() {
		return position.getZ();
	}

	public TileEntity getTileEntity() {
		return world.getTileEntity(position);
	}
}
