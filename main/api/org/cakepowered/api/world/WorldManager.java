package org.cakepowered.api.world;

public interface WorldManager {

	public void createWorld(int id);
	
	public World getWorld(int id);
	
	public int getNextID();
}
