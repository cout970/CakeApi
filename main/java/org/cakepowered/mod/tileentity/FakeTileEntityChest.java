package org.cakepowered.mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityEnderChest;

public class FakeTileEntityChest extends TileEntityEnderChest {

	// is player near the ender chest?
	@Override
	public boolean func_145971_a(EntityPlayer p_145971_1_) {
		return true;
	}

	// change block state
	@Override
	public void func_145969_a() {
	}

	@Override
	public void func_145970_b() {
	}
}