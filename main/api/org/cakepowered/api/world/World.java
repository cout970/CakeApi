package org.cakepowered.api.world;

import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.util.Location;

public interface World {

	int getDifficulty();
	String getName();
	int getDimension();
	void setWorldGenerator(WorldCreationSettings generator);
	Scoreboard getScoreboard();
	Location getSpawnLocation();
	
}
