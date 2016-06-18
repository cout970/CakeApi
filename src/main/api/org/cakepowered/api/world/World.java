package org.cakepowered.api.world;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.core.Server;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.firework.FireworkProperties;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.util.BlockLocation;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.biome.Biome;

import java.util.List;

public interface World {

	WorldDifficulty getDifficulty();

	String getName();

	int getDimension();

	Scoreboard getScoreboard();

	Biome getBiome(int x, int z);

	void setBiome(Biome biome, int x, int z);

	BlockLocation getSpawnLocation();

	Block getBlock(Vector3 position);

	TileEntity getTileEntity(Vector3 pos);

	List<Entity> getEntities();

	boolean isAirBlock(Vector3 pos);

	boolean isBlockLoaded(Vector3 pos);

	boolean setBlockToAir(Vector3 pos);

	boolean setBlockState(Vector3 pos, BlockState state);

	boolean setBlockState(Vector3 pos, BlockState state, int flags);

	BlockState getBlockState(Vector3 pos);

	boolean isDaytime();

	/**
	 * volume and pitch must between 0 and 1
	 */
	void playSoundAtEntity(Entity entity, String soundName, float volume, float pitch);

	void playSoundEffect(double x, double y, double z, String soundName, float volume, float pitch);

	boolean spawnEntityInWorld(Entity entity);

	List<Entity> getEntitiesExcludingType(Entity type, int minX, int minY, int minZ, int maxX, int maxY, int maxZ);

	void setWorldTime(long time);

	Server getServer();
	
	boolean canBlockSeeSky(int x, int y, int z);
	
	boolean spawnFirework(Vector3 pos, FireworkProperties prop);
	
	void loadChunk(int x, int y);
}
