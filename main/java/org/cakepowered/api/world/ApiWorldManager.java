package org.cakepowered.api.world;

import org.cakepowered.api.util.ForgeInterface;

import net.minecraftforge.common.DimensionManager;

public class ApiWorldManager implements WorldManager{
	
	public static final ApiWorldManager INSTANCE = new ApiWorldManager();
	
	@Override
	public World createFlatWorld(int id){

		DimensionManager.registerProviderType(2, CustomWorldProvider.class, true);
		DimensionManager.registerDimension(id, 2);
//		DimensionManager.initDimension(id);

		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}
	
	@Override
	public World getWorld(int id) {
		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}
	
	@Override
	public int getNextID() {
		return DimensionManager.getNextFreeDimId();
	}

	@Override
	public World createNormalWorld(int id) {
		DimensionManager.registerDimension(id, 0);
//		DimensionManager.initDimension(id);

		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}
}