package org.cakepowered.mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityEnderChest;

public class FakeTileEntityChest extends TileEntityEnderChest {

	// is player near the ender chest?
	@Override
	public boolean canBeUsed(EntityPlayer p_145971_1_) {
		return true;
	}

	// change block state
	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}
}
