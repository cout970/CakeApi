package org.cakepowered.api.world;

import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.block.Block;
import org.cakepowered.api.world.tileentity.TileEntity;

public interface World {

	int getDifficulty();
	
	String getName();
	
	int getDimension();
	
	void setWorldGenerator(WorldCreationSettings generator);
	
	Scoreboard getScoreboard();
	
	Location getSpawnLocation();
	
	Block getBlock(int x, int i, int z);

	TileEntity getTileEntity(Vector3i position);
	
}
