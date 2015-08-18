package org.cakepowered.api.util;

import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.world.World;

public class Location {

	protected int dimension;
	protected Vector3i position;
	
	public Location(int d, int x, int y, int z){
		this(d, new Vector3i(x, y, z));
	}
	
	public Location(int d, Vector3i pos){
		dimension = d;
		pos = pos.copy();
	}

	public int getDimension() {
		return dimension;
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
}
