package org.cakepowered.api.base;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;

public interface MinecraftFinder {

	public Item findItem(String unlocalizedName);
	
	public Block findBlock(String unlocalizedName);
}
