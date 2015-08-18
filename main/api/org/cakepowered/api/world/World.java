package org.cakepowered.api.world;

import java.util.List;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3i;

public interface World {

	public int getDifficulty();
	
	public String getName();
	
	public int getDimension();
		
	public Scoreboard getScoreboard();
	
	public Location getSpawnLocation();
	
	public Block getBlock(Vector3i position);

	public TileEntity getTileEntity(Vector3i position);
	
	public List<Entity> getEntities();
}
