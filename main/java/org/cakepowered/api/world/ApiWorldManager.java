package org.cakepowered.api.world;

import java.util.HashMap;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;

public class ApiWorldManager implements WorldManager{
	
	public static final ApiWorldManager INSTANCE = new ApiWorldManager();
	
	public static HashMap<Integer, WorldServer> dimensions = new HashMap<Integer, WorldServer>();
	
	public static void registerWorlds(){
		CakeApiMod.logger.info("Registering Dimensions");
		
		for(WorldServer s: MinecraftServer.getServer().worldServers){
			dimensions.put(Integer.valueOf(s.provider.getDimensionId()), s);
		}
		
		CakeApiMod.logger.info("Succesfully Registered Dimensions");
	}

	public World createWorld(String file, int id, long seed){
		
		try{
			if(dimensions.containsKey(Integer.valueOf(id)))return null;
			NBTTagCompound data = new NBTTagCompound();
			data.setLong("RandomSeed", seed);

			WorldInfo info = new WorldInfo(data);
			ISaveHandler handler = MinecraftServer.getServer().getActiveAnvilConverter().getSaveLoader(file, true);
			
			net.minecraftforge.common.DimensionManager.registerDimension(id, 0);
			
			WorldServer dimension = new WorldServer(MinecraftServer.getServer(), handler, info, id, MinecraftServer.getServer().theProfiler);
			
			dimension.init();
			
			dimensions.put(Integer.valueOf(id), dimension);
			
			return ForgeInterface.getWorld(dimension);
			
		}catch(Exception e){
			CakeApiMod.logger.error("Error Creating Dimension "+id+" : "+file+", with seed: "+seed);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public World getWorld(int id) {
		return ForgeInterface.getWorld(dimensions.get(Integer.valueOf(id)));
	}

	@Override
	public int getNextID() {
		return DimensionManager.getNextFreeDimId();
	}
}
