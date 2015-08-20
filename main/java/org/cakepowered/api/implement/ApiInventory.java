package org.cakepowered.api.implement;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.IImplementation;
import org.cakepowered.api.util.PluginInterface;

import net.minecraft.inventory.IInventory;

public class ApiInventory implements Inventory, IImplementation<IInventory>{

	protected IInventory inv;
	
	public ApiInventory(IInventory inv) {
		this.inv = inv;
	}

	@Override
	public int getSize() {
		return inv.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return ForgeInterface.getItemStack(inv.getStackInSlot(index));
	}

	@Override
	public void setStackInSlot(int index, ItemStack stack) {
		inv.setInventorySlotContents(index, PluginInterface.getItemStack(stack));
		inv.markDirty();
	}

	@Override
	public ItemStack extractAmount(int index, int amount) {
		return ForgeInterface.getItemStack(inv.decrStackSize(index, amount));
	}

	@Override
	public int getMaxStackSize() {
		return inv.getInventoryStackLimit();
	}

	@Override
	public boolean canPlayerUse(Player player) {
		return inv.isUseableByPlayer(((ApiPlayer)player).player);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack stack) {
		return inv.isItemValidForSlot(index, PluginInterface.getItemStack(stack));
	}

	@Override
	public void clear() {
		inv.clear();
	}

	@Override
	public IInventory getMcObject() {
		return inv;
	}
}
