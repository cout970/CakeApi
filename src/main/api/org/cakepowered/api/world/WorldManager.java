package org.cakepowered.api.world;

import org.cakepowered.api.world.biome.Biome;

public interface WorldManager {

	@Deprecated
	World createFlatWorld(int id);

	@Deprecated
	World createNormalWorld(int id, long seed);

	World getWorld(int id);

	int getNextID();

	void unloadDimension(int id);

	Biome getBiome(int id);
}