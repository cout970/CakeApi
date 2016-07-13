package org.cakepowered.mod.tileentity;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

public class ApiTileEntity implements org.cakepowered.api.tileentity.TileEntity, IImplementation<TileEntity> {

	protected TileEntity tile;

	public ApiTileEntity(TileEntity t) {
		tile = t;
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(tile.getWorld());
	}

	@Override
	public Vector3 getPosition() {
		return ForgeInterface.getVector3(tile.getPos());
	}

	@Override
	public boolean isEquivalentTo(org.cakepowered.api.tileentity.TileEntity t) {
		return t instanceof ApiTileEntity && ((ApiTileEntity) t).tile.getClass().equals(tile.getClass());
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof ApiTileEntity && tile.equals(((ApiTileEntity) o).tile);
	}

	@Override
	public Inventory getInventory() {
		if (tile instanceof IInventory) {
			return ForgeInterface.getInventory((IInventory) tile);
		}
		return null;
	}

	@Override
	public void readFromNBT(NBTCompound nbt) {
		NBTTagCompound tag = PluginInterface.getNBT(nbt);
		tile.readFromNBT(tag);
	}

	@Override
	public void writeToNBT(NBTCompound nbt) {
		NBTTagCompound tag = PluginInterface.getNBT(nbt);
		tile.writeToNBT(tag);
	}

	@Override
	public void syncPlayer(Player p) {
		Packet packet = tile.getUpdatePacket();
		if (packet != null) {
			EntityPlayer player = PluginInterface.getPlayer(p);
			if (player instanceof EntityPlayerMP) {
				((EntityPlayerMP) player).connection.sendPacket(packet);
			}
		}
	}

	@Override
	public TileEntity getMcObject() {
		return tile;
	}
}
