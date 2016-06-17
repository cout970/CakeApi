package org.cakepowered.api.base;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;

public interface MinecraftFinder {

	public Item findItem(String domain, String identifier);

	public Block findBlock(String domain, String identifier);

	public String getIdentifier(Item item);

	public String getIdentifier(Block block);

	public String getDomain(Item item);

	public String getDomain(Block block);

	public String getCompleteName(Item item);

	public String getCompleteName(Block block);

}
