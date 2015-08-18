package org.cakepowered.api.implement;

import org.cakepowered.api.base.MinecraftFinder;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ApiMinecraftFinder implements MinecraftFinder{

	public static ApiMinecraftFinder INSTANCE = new ApiMinecraftFinder();
	
	@Override
	public Item findItem(String unlocalizedName) {
		net.minecraft.item.Item i = GameRegistry.findItem("minecraft", unlocalizedName);
		if(i == null)return null;
		return ForgeInterface.getItem(i);
	}

	@Override
	public Block findBlock(String unlocalizedName) {
		net.minecraft.block.Block i = GameRegistry.findBlock("minecraft", unlocalizedName);
		if(i == null)return null;
		return ForgeInterface.getBlock(i);
	}

}
