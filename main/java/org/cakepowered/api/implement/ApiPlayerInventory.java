package org.cakepowered.api.implement;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.inventory.PlayerInventory;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraft.entity.player.InventoryPlayer;

public class ApiPlayerInventory extends ApiInventory implements PlayerInventory{

	public InventoryPlayer player;
	
	public ApiPlayerInventory(InventoryPlayer inventory) {
		super(inventory);
		player = inventory;
	}

	@Override
	public Player getPlayer() {
		return ForgeInterface.getPlayer(player.player);
	}

	@Override
	public int getFirstEmptySlot() {
		return player.getFirstEmptyStack();
	}

	@Override
	public boolean consumeInventoryItem(Item item) {
		return player.consumeInventoryItem(((ApiItem)item).item);
	}

	@Override
	public boolean hasItem(Item item) {
		return player.hasItem(((ApiItem)item).item);
	}

	@Override
	public boolean addItemStackToInventory(ItemStack stack) {
		return player.addItemStackToInventory(((ApiItemStack)stack).stack);
	}

	@Override
	public ItemStack armorItemInSlot(int slot) {
		return ForgeInterface.getApiItemStack(player.armorItemInSlot(slot));
	}

	@Override
	public void dropAllItems() {
		player.dropAllItems();
	}

	@Override
	public boolean hasItemStack(ItemStack stack) {
		return player.hasItemStack(((ApiItemStack)stack).stack);
	}

	
}
