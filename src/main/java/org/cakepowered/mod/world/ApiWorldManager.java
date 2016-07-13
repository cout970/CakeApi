package org.cakepowered.mod.world;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.network.ForgeMessage;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.FMLOutboundHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.cakepowered.api.world.World;
import org.cakepowered.api.world.WorldManager;
import org.cakepowered.api.world.biome.Biome;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.util.ForgeInterface;

import java.util.HashMap;

public class ApiWorldManager implements WorldManager {

	public static final ApiWorldManager INSTANCE = new ApiWorldManager();
	static HashMap<Integer, Long> seeds = new HashMap<>();
	public static DimensionType flatWorld = DimensionType.register("FlatWorld", "_flat", DimensionType.values()[DimensionType.values().length-1].getId() + 1, FlatWorldProvider.class, true);
	public static DimensionType surfaceWorld = DimensionType.register("SurfaceWorld", "_surface", DimensionType.values()[DimensionType.values().length-1].getId() + 1, SurfaceWorldProvider.class, true);

	@Override
	public World createFlatWorld(int id) {

		DimensionManager.registerDimension(id, flatWorld);
		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}

	@Override
	public World getWorld(int id) {
		return ForgeInterface.getWorld(CakeApiCore.getServer().worldServerForDimension(id));
	}

	@Override
	public int getNextID() {
		return DimensionManager.getNextFreeDimId();
	}

	@Override
	public World createNormalWorld(int id, long seed) {
		DimensionManager.registerDimension(id, surfaceWorld);
		seeds.put(id, seed);

		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}

	@Override
	public void unloadDimension(int id) {
		DimensionManager.unloadWorld(id);
	}

	@Override
	public Biome getBiome(int id) {
		return ForgeInterface.getBiome(net.minecraft.world.biome.Biome.getBiome(id));
	}

	public void sendDimensionData(EntityPlayer player) {
		for (int id : DimensionManager.getIDs()) {
			if (id != -1 && id != 0 && id != 1) {
				FMLEmbeddedChannel serverChannel = NetworkRegistry.INSTANCE.getChannel("FORGE", Side.SERVER);
				serverChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
				serverChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
				serverChannel.writeOutbound(new ForgeMessage.DimensionRegisterMessage(id, DimensionType.getById(id).getName()));
			}
		}
	}
}
