package org.cakepowered.mod.world;

import java.util.HashMap;

import org.cakepowered.api.world.World;
import org.cakepowered.api.world.WorldManager;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.network.ForgeMessage;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.FMLOutboundHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ApiWorldManager implements WorldManager {

	public static final ApiWorldManager INSTANCE = new ApiWorldManager();
	public static HashMap<Integer, Long> seeds = new HashMap<Integer, Long>();

	@Override
	public World createFlatWorld(int id) {
		DimensionManager.registerProviderType(2, FlatWorldProvider.class, true);
		DimensionManager.registerDimension(id, 2);

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
	public World createNormalWorld(int id, long seed) {
		DimensionManager.registerProviderType(3, SurfaceWorldProvider.class, true);
		DimensionManager.registerDimension(id, 3);
		seeds.put(id, seed);

		return ForgeInterface.getWorld(DimensionManager.getWorld(id));
	}

	@Override
	public void unloadDimension(int id) {
		DimensionManager.unloadWorld(id);
	}

	public void sendDimensionData(EntityPlayer player) {
		for (int id : DimensionManager.getIDs()) {
			if (id != -1 && id != 0 && id != 1) {
				FMLEmbeddedChannel serverChannel = NetworkRegistry.INSTANCE.getChannel("FORGE", Side.SERVER);
				serverChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
				serverChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
				serverChannel.writeOutbound(new ForgeMessage.DimensionRegisterMessage(id, 0));
			}
		}
	}
}
