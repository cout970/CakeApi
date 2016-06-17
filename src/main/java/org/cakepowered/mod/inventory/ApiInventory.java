package org.cakepowered.mod.inventory;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.inventory.IInventory;

public class ApiInventory implements Inventory, IImplementation<IInventory> {

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
		return inv.isUseableByPlayer(PluginInterface.getPlayer(player));
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
