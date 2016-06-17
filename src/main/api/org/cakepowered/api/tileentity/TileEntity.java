package org.cakepowered.api.tileentity;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.util.vector.Vector3i;
import org.cakepowered.api.world.World;

public interface TileEntity {

	World getWorld();

	Vector3i getPosition();

	boolean isEquivalentTo(TileEntity t);

	/**
	 * Returns the inventory associated with the tileEntity, can be null.
	 */
	Inventory getInventory();

	void readFromNBT(NBTCompound nbt);

	void writeToNBT(NBTCompound nbt);

	void syncPlayer(Player p);
}
