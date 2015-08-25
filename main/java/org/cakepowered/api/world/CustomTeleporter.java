package org.cakepowered.api.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CustomTeleporter extends Teleporter {

	public CustomTeleporter(WorldServer worldIn) {
		super(worldIn);
	}

	public void placeInPortal(Entity entityIn, float rotationYaw) {
	}

	public boolean placeInExistingPortal(Entity entityIn, float p_180620_2_) {
		return false;
	}

	public boolean makePortal(Entity p_85188_1_) {
		return false;
	}

	public void removeStalePortalLocations(long p_85189_1_) {

	}
}
