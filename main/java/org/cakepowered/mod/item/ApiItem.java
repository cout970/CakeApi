package org.cakepowered.mod.item;

import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.item.Item;

public class ApiItem implements org.cakepowered.api.item.Item, IImplementation<Item>{

	protected Item item;
	
	public ApiItem(Item it){
		item = it;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return item.getUnlocalizedName(PluginInterface.getItemStack(stack));
	}

	@Override
	public org.cakepowered.api.item.Item getContainerItem() {
		return ForgeInterface.getItem(item.getContainerItem());
	}

	@Override
	public ItemStack createStack(int amount) {
		return createStack(amount, 0);
	}

	@Override
	public ItemStack createStack(int amount, int metadata) {
		return ForgeInterface.getItemStack(new net.minecraft.item.ItemStack(item, amount, metadata));
	}

	@Override
	public Item getMcObject() {
		return item;
	}
}
