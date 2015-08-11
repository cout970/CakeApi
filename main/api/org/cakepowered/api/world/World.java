package org.cakepowered.api.world;

import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.util.Location;

import net.minecraft.world.gen.feature.WorldGenerator;

public interface World {

	int getDifficulty();
	String getName();
	int getDimension();
	void setWorldGenerator(WorldGenerator generator);
	Scoreboard getScoreboard();
	Location getSpawnLocation();
	
}
