package org.cakepowered.api.inventory;

import org.cakepowered.api.entity.Player;

//Attention this will be removed for the 1.9 update
public interface Inventory {

	/**
	 * Returns the number of slots in this inventory
	 */
	int getSize();

	/**
	 * Returns the stack in the slot (index), this stack can be null if the slot is empty
	 */
	ItemStack getStackInSlot(int index);

	/**
	 * Places the stack in the slot (index)
	 */
	void setStackInSlot(int index, ItemStack stack);

	/**
	 * Removes from the slot index (first arg) up to an amount of items (second arg) and returns a new
	 * ItemStack with the items removed
	 */
	ItemStack extractAmount(int index, int amount);

	/**
	 * Returns the maximum stack size for a inventory slot
	 */
	int getMaxStackSize();

	/**
	 * Returns true if this player can use this inventory, false otherwise
	 */
	boolean canPlayerUse(Player player);

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given
	 * slot (index)
	 */
	boolean canInsertItem(int index, ItemStack stack);

	/**
	 * Removes all items on this inventory
	 */
	void clear();
}
