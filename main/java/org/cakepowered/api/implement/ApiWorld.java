package org.cakepowered.api.implement;

import org.cakepowered.api.scoreboard.ApiScoreboard;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.world.Difficulties;
import org.cakepowered.api.world.DimensionTypes;
import org.cakepowered.api.world.World;
import org.cakepowered.api.world.WorldCreationSettings;
import org.cakepowered.api.world.block.Block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ApiWorld implements World {
	
	public net.minecraft.world.World world;
	
	public ApiWorld(net.minecraft.world.World world){
		
		this.world = world;
		
	}
	
	@Override
	public int getDifficulty() {
		switch (world.getDifficulty()) {
		case EASY:
			return Difficulties.EASY;
		case NORMAL:
			return Difficulties.NORMAL;
		case HARD:
			return Difficulties.HARD;
		case PEACEFUL:
			return Difficulties.PEACEFUL;
		default:
			return Difficulties.NORMAL;
		}
	}

	@Override
	public String getName() {
		return world.getWorldInfo().getWorldName();
	}

	public int getDimension() {
		return world.provider.getDimensionId();
	}

	@Override
	public void setWorldGenerator(WorldCreationSettings generator) {
		
		this.world.getWorldInfo().setWorldName(generator.getWorldName());
		this.world.rand.setSeed(generator.getSeed());
		this.world.provider.setDimension(generator.getdimensionType());
		
	}

	@Override
	public Scoreboard getScoreboard() {
		return new ApiScoreboard(this.world.getScoreboard());
	}

	@Override
	public Location getSpawnLocation() {
		return new Location(new ApiWorld(world), world.getSpawnPoint().getX(), world.getSpawnPoint().getY(), world.getSpawnPoint().getZ());
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		IBlockState state = world.getBlockState(new BlockPos(x, y, z));
		return ForgeInterface.getBlock(state.getBlock());
	}
	
}
