package org.cakepowered.api.world;

public interface WorldManager {

	public World createFlatWorld(int id);

	public World createNormalWorld(int id, long seed);

	public World getWorld(int id);

	public int getNextID();

	void unloadDimension(int id);
}