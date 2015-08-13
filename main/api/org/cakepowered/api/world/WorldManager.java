package org.cakepowered.api.world;

public interface WorldManager {

	public World createWorld(String file, int id, long seed);
	
	public World getWorld(int id);
	
	public int getNextID();
}
