package org.cakepowered.api.implement;

import org.cakepowered.api.base.MinecraftFinder;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.PluginInterface;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.UniqueIdentifier;

public class ApiMinecraftFinder implements MinecraftFinder{

	public static ApiMinecraftFinder INSTANCE = new ApiMinecraftFinder();
	
	@Override
	public Item findItem(String domain, String unlocalizedName) {
		net.minecraft.item.Item i = GameRegistry.findItem(domain, unlocalizedName);
		if(i == null)return null;
		return ForgeInterface.getItem(i);
	}

	@Override
	public Block findBlock(String domain, String unlocalizedName) {
		net.minecraft.block.Block i = GameRegistry.findBlock(domain, unlocalizedName);
		if(i == null)return null;
		return ForgeInterface.getBlock(i);
	}

	@Override
	public String getIdentifier(Item item) {
		UniqueIdentifier id =  GameRegistry.findUniqueIdentifierFor(PluginInterface.getItem(item));
		if(id == null)return null;
		return id.name;
	}

	@Override
	public String getIdentifier(Block block) {
		UniqueIdentifier id =  GameRegistry.findUniqueIdentifierFor(PluginInterface.getBlock(block));
		if(id == null)return null;
		return id.name;
	}

	@Override
	public String getDomain(Item item) {
		UniqueIdentifier id =  GameRegistry.findUniqueIdentifierFor(PluginInterface.getItem(item));
		if(id == null)return null;
		return id.modId;
	}

	@Override
	public String getDomain(Block block) {
		UniqueIdentifier id =  GameRegistry.findUniqueIdentifierFor(PluginInterface.getBlock(block));
		if(id == null)return null;
		return id.modId;
	}
	
	@Override
	public String getCompleteName(Item item) {
		return getDomain(item) + ":" + getIdentifier(item);
	}
	
	@Override
	public String getCompleteName(Block block) {
		return getDomain(block) + ":" + getIdentifier(block);
	}

}
