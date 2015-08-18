package org.cakepowered.api.inventory;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.item.Item;

public interface PlayerInventory extends Inventory{
	
	public Player getPlayer();
	
	public int getFirstEmptySlot();
	
	public boolean consumeInventoryItem(Item item);
	
	public boolean hasItem(Item item);
	
	public boolean addItemStackToInventory(final ItemStack stack);
	
	public ItemStack armorItemInSlot(int slot);
	
	public void dropAllItems();
	
	public boolean hasItemStack(ItemStack stack);
}
