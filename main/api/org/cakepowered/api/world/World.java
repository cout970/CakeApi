package org.cakepowered.api.world;

import java.util.List;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.block.Block;
import org.cakepowered.api.world.tileentity.TileEntity;

public interface World {

	public int getDifficulty();
	
	public String getName();
	
	public int getDimension();
		
	public Scoreboard getScoreboard();
	
	public Location getSpawnLocation();
	
	public Block getBlock(int x, int i, int z);

	public TileEntity getTileEntity(Vector3i position);
	
	public List<Entity> getEntities();
}
