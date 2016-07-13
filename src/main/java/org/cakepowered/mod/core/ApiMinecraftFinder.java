package org.cakepowered.mod.core;

import net.minecraft.util.ResourceLocation;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.core.MinecraftFinder;
import org.cakepowered.api.item.Item;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.PluginInterface;

public class ApiMinecraftFinder implements MinecraftFinder {

	public static ApiMinecraftFinder INSTANCE = new ApiMinecraftFinder();

	@Override
	public Item findItem(String domain, String identifier) {
		net.minecraft.item.Item i = net.minecraft.item.Item.REGISTRY.getObject(new ResourceLocation(domain, identifier));
		return ForgeInterface.getItem(i);
	}

	@Override
	public Block findBlock(String domain, String identifier) {
		net.minecraft.block.Block i = net.minecraft.block.Block.REGISTRY.getObject(new ResourceLocation(domain, identifier));
		return ForgeInterface.getBlock(i);
	}

	@Override
	public String getIdentifier(Item item) {
		return PluginInterface.getItem(item).getRegistryName().getResourcePath();
	}

	@Override
	public String getIdentifier(Block block) {
		return PluginInterface.getBlock(block).getRegistryName().getResourcePath();
	}

	@Override
	public String getDomain(Item item) {
		return PluginInterface.getItem(item).getRegistryName().getResourceDomain();
	}

	@Override
	public String getDomain(Block block) {
		return PluginInterface.getBlock(block).getRegistryName().getResourceDomain();
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
