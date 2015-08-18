package org.cakepowered.api.block;

import org.cakepowered.api.inventory.ItemStack;

public interface Block {
	
	/**
	 * Returns the internal name for this block
	 */
	public String getUnlocalizedName();
	
	/**
	 * Creates a new ItemStack using this block and the amount
	 */
	public ItemStack createStack(int amount);
	
	/**
	 * Creates a new ItemStack using this block, the amount (fist arg) and the metadata (second arg)
	 */
	public ItemStack createStack(int amount, int metadata);
}
