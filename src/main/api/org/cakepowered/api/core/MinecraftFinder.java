package org.cakepowered.api.core;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;

public interface MinecraftFinder {

	Item findItem(String domain, String identifier);

	Block findBlock(String domain, String identifier);

	String getIdentifier(Item item);

	String getIdentifier(Block block);

	String getDomain(Item item);

	String getDomain(Block block);

	String getCompleteName(Item item);

	String getCompleteName(Block block);

}
