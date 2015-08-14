package org.cakepowered.api.world.tileentity;

import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.World;

public interface TileEntity {

	public World getWorld();
	
	public Vector3i getPosition();
	
	public boolean isEquivalentTo(TileEntity t);
	
}
