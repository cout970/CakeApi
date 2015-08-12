package org.cakepowered.api.implement;

import org.cakepowered.api.world.block.Block;

public class ApiBlock implements Block{

	public net.minecraft.block.Block block;
	
	public ApiBlock(net.minecraft.block.Block bl) {
		block = bl;
	}

	public boolean equals(Object o){
		if(o instanceof ApiBlock){
			return block.equals(((ApiBlock) o).block);
		}
		return false;
	}
}
