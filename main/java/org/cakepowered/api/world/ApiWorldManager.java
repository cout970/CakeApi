package org.cakepowered.api.world;

import org.cakepowered.api.util.ForgeInterface;

import net.minecraftforge.common.DimensionManager;

public class ApiWorldManager implements WorldManager{
	
	public static final ApiWorldManager INSTANCE = new ApiWorldManager();

	public void createWorld(int id){
		DimensionManager.registerDimension(id, 0);
	}

	@Override
	public World getWorld(int id) {
		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}

	@Override
	public int getNextID() {
		return DimensionManager.getNextFreeDimId();
	}
}
