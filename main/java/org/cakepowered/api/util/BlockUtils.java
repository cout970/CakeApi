package org.cakepowered.api.util;

import org.cakepowered.api.world.block.Blocks;
import org.cakepowered.api.world.tileentity.TileEntities;

import net.minecraft.tileentity.TileEntitySign;

public class BlockUtils {

	public static void registerBlocks() {
		Blocks.PISTON = ForgeInterface.getBlock(net.minecraft.init.Blocks.piston);
		Blocks.PISTON_EXTENSION = ForgeInterface.getBlock(net.minecraft.init.Blocks.piston_extension);
		Blocks.PISTON_HEAD = ForgeInterface.getBlock(net.minecraft.init.Blocks.piston_head);
		Blocks.STICKY_PISTON = ForgeInterface.getBlock(net.minecraft.init.Blocks.sticky_piston);
		Blocks.DISPENSER = ForgeInterface.getBlock(net.minecraft.init.Blocks.dispenser);
		Blocks.DROPPER = ForgeInterface.getBlock(net.minecraft.init.Blocks.dropper);
		Blocks.TNT = ForgeInterface.getBlock(net.minecraft.init.Blocks.tnt);
		Blocks.WOODEN_DOOR = ForgeInterface.getBlock(net.minecraft.init.Blocks.oak_door);
		Blocks.ACACIA_DOOR = ForgeInterface.getBlock(net.minecraft.init.Blocks.acacia_door);
		Blocks.BIRCH_DOOR = ForgeInterface.getBlock(net.minecraft.init.Blocks.birch_door);
		Blocks.DARK_OAK_DOOR = ForgeInterface.getBlock(net.minecraft.init.Blocks.dark_oak_door);
		Blocks.JUNGLE_DOOR = ForgeInterface.getBlock(net.minecraft.init.Blocks.jungle_door);
		Blocks.SPRUCE_DOOR = ForgeInterface.getBlock(net.minecraft.init.Blocks.spruce_door);
		
	}

	public static void registerEntities() {
		TileEntities.SIGN = ForgeInterface.getTileEntity(new TileEntitySign());
	}

}
