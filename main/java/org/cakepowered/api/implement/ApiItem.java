package org.cakepowered.api.implement;

import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraft.item.Item;

public class ApiItem implements org.cakepowered.api.item.Item{

	public Item item;
	
	public ApiItem(Item it){
		item = it;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return item.getUnlocalizedName(ForgeInterface.getItemStack(stack));
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
		return ForgeInterface.getApiItemStack(new net.minecraft.item.ItemStack(item, amount, metadata));
	}
}
