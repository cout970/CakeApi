package org.cakepowered.mod.block;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

public class ApiBlock implements Block, IImplementation<net.minecraft.block.Block> {

	protected net.minecraft.block.Block block;

	public ApiBlock(net.minecraft.block.Block bl) {
		block = bl;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ApiBlock) {
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
		return ForgeInterface.getItemStack(new net.minecraft.item.ItemStack(block, amount, metadata));
	}

	@Override
	public BlockState getDefuldBlockState() {
		return ForgeInterface.getBlockState(block.getDefaultState());
	}

	@Override
	public int getMetadataFromState(BlockState state) {
		return block.getMetaFromState(PluginInterface.getBlockState(state));
	}

	@Override
	public BlockState getStateFromMetadata(int meta) {
		return ForgeInterface.getBlockState(block.getStateFromMeta(meta));
	}

	@Override
	public net.minecraft.block.Block getMcObject() {
		return block;
	}

	@Override
	public Item toItem() {
		return ForgeInterface.getItem(net.minecraft.item.Item.getItemFromBlock(block));
	}
}
