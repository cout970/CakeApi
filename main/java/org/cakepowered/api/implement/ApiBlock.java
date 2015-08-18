package org.cakepowered.api.implement;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.util.ForgeInterface;

public class ApiBlock implements Block{

	public net.minecraft.block.Block block;
	
	public ApiBlock(net.minecraft.block.Block bl) {
		block = bl;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof ApiBlock){
			return block.equals(((ApiBlock) o).block);
		}
		return false;
	}

	@Override
	public String getUnlocalizedName() {
		return block.getUnlocalizedName();
	}

	@Override
	public ItemStack createStack(int amount) {
		return createStack(amount, 0);
	}

	@Override
	public ItemStack createStack(int amount, int metadata) {
		return ForgeInterface.getApiItemStack(new net.minecraft.item.ItemStack(block, amount, metadata));
	}
}
