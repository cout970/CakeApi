package org.cakepowered.api.implement;

import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.World;

import net.minecraft.tileentity.TileEntity;

public class ApiTileEntity implements org.cakepowered.api.world.tileentity.TileEntity{

	public TileEntity tile;
	
	public ApiTileEntity(TileEntity t){
		tile = t;
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(tile.getWorld());
	}

	@Override
	public Vector3i getPosition() {
		return ForgeInterface.getVector3i(tile.getPos());
	}

	@Override
	public boolean isEquivalentTo(org.cakepowered.api.world.tileentity.TileEntity t) {
		if(t instanceof ApiTileEntity){
			return ((ApiTileEntity) t).tile.getClass().equals(tile.getClass());
		}
		return false;
	}
	
	public boolean equals(Object o){
		if(o instanceof ApiTileEntity){
			return tile.equals(((ApiTileEntity) o).tile);
		}
		return false;
	}
}
