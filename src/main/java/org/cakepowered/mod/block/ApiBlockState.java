package org.cakepowered.mod.block;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;

import net.minecraft.block.state.IBlockState;

public class ApiBlockState implements BlockState, IImplementation<IBlockState> {

	protected IBlockState state;

	public ApiBlockState(IBlockState state) {
		this.state = state;
	}

	@Override
	public IBlockState getMcObject() {
		return state;
	}

	@Override
	public Block getBlock() {
		return ForgeInterface.getBlock(state.getBlock());
	}

	@Override
	public int getMetadata() {
		return getBlock().getMetadataFromState(this);
	}
}
