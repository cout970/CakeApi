package org.cakepowered.api.world;

import java.util.List;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
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

	public boolean isAirBlock(Vector3i pos);

	public boolean isBlockLoaded(Vector3i pos);

	public boolean setBlockToAir(Vector3i pos);

	public boolean setBlockState(Vector3i pos, BlockState state);

	public BlockState getBlockState(Vector3i pos);

	public boolean isDaytime();

	/**
	 * volume and pitch must between 0 and 1
	 */
	public void playSoundAtEntity(Entity entity, String soundName, float volume, float pitch);

	public void playSoundEffect(double x, double y, double z, String soundName, float volume, float pitch);

	public boolean spawnEntityInWorld(Entity entity);

	public List<Entity> getEntitiesExcludingType(Entity type, int minX, int minY, int minZ, int maxX, int maxY, int maxZ);

	void setWorldTime(long time);

	public Server getServer();
}
