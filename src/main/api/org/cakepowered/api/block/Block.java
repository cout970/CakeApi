package org.cakepowered.api.block;

import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;

public interface Block {

	/**
	 * Returns the internal name for this block
	 */
	String getUnlocalizedName();

	/**
	 * Creates a new ItemStack using this block and the amount
	 */
	ItemStack createStack(int amount);

	/**
	 * Creates a new ItemStack using this block, the amount (fist arg) and the metadata (second arg)
	 */
	ItemStack createStack(int amount, int metadata);

	BlockState getDefuldBlockState();

	int getMetadataFromState(BlockState state);

	BlockState getStateFromMetadata(int meta);

	Item toItem();

	boolean hasTileEntity(BlockState state);
}
