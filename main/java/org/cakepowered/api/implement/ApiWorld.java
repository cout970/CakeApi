package org.cakepowered.api.implement;

import java.util.ArrayList;
import java.util.List;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.scoreboard.ApiScoreboard;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.Difficulties;
import org.cakepowered.api.world.World;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;

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

	@Override
	public int getDimension() {
		return world.provider.getDimensionId();
	}

	@Override
	public Scoreboard getScoreboard() {
		return new ApiScoreboard(this.world.getScoreboard());
	}

	@Override
	public Location getSpawnLocation() {
		return new Location(world.provider.getDimensionId(), world.getSpawnPoint().getX(), world.getSpawnPoint().getY(), world.getSpawnPoint().getZ());
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		IBlockState state = world.getBlockState(new BlockPos(x, y, z));
		return ForgeInterface.getBlock(state.getBlock());
	}

	@Override
	public TileEntity getTileEntity(Vector3i position) {
		return ForgeInterface.getTileEntity(world.getTileEntity(ForgeInterface.getBlockPos(position)));
	}

	@Override
	public List<Entity> getEntities() {
		List<Entity> list = new ArrayList<Entity>();
		for(Object e : world.getLoadedEntityList()){
			if(e instanceof net.minecraft.entity.Entity){
				list.add(ForgeInterface.getEntity((net.minecraft.entity.Entity) e));
			}
		}
		return list;
	}
	
}
