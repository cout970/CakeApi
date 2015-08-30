package org.cakepowered.api.implement;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.IImplementation;

import net.minecraft.block.state.IBlockState;

public class ApiBlockState implements BlockState, IImplementation<IBlockState>{

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
}
