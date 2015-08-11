package org.cakepowered.api.implement;

import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.world.Difficulties;
import org.cakepowered.api.world.DimensionTypes;
import org.cakepowered.api.world.World;

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
		switch (world.provider.getDimensionId()) {
		case -1:
			return DimensionTypes.NETHER;
		case 0:
			return DimensionTypes.OVERWORLD;
		case 1:
			return DimensionTypes.END;
		default:
			return DimensionTypes.OVERWORLD;
		}
	}

	@Override
	public void setWorldGenerator(WorldGenerator generator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scoreboard getScoreboard() {
		return null;
	}

	@Override
	public Location getSpawnLocation() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
