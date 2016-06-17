package org.cakepowered.api.inventory;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.item.Item;

public interface PlayerInventory extends Inventory {

	Player getPlayer();

	int getFirstEmptySlot();

	boolean consumeInventoryItem(Item item);

	boolean hasItem(Item item);

	boolean addItemStackToInventory(final ItemStack stack);

	ItemStack armorItemInSlot(int slot);

	void dropAllItems();

	boolean hasItemStack(ItemStack stack);
}
