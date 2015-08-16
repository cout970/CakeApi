package org.cakepowered.api.world;

public interface WorldManager {

	public World createWorld(int id, long seed, String type);

	public World getWorld(int id);

	public int getNextID();

	public void registerWorlds();

}