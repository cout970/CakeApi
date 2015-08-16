package org.cakepowered.api.world;

public interface WorldManager {

	public World createFlatWorld(int id);
	
	public World createNormalWorld(int id);

	public World getWorld(int id);

	public int getNextID();
}