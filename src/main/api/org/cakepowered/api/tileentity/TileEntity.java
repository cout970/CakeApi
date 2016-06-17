package org.cakepowered.api.tileentity;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.World;

public interface TileEntity {

	public World getWorld();

	public Vector3i getPosition();

	public boolean isEquivalentTo(TileEntity t);

	/**
	 * Returns the inventory associated with the tileEntity, can be null.
	 */
	public Inventory getInventory();

	public void readFromNBT(NBTCompound nbt);

	public void writeToNBT(NBTCompound nbt);

	public void syncPlayer(Player p);
}
