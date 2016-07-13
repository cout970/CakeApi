package org.cakepowered.api.world;

import org.cakepowered.api.world.biome.Biome;

public interface WorldManager {

	World createFlatWorld(int id);

	World createNormalWorld(int id, long seed);

	World getWorld(int id);

	int getNextID();

	void unloadDimension(int id);

	Biome getBiome(int id);
}