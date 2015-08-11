package org.cakepowered.api.implement;

import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.base.World;
import org.cakepowered.api.util.Location;

import net.minecraft.entity.player.EntityPlayer;

public class ApiPlayer implements Player{
	
	public EntityPlayer player;

	public ApiPlayer(EntityPlayer player){
		this.player = player;
	}

	@Override
	public String getUserName() {
		return player.getName();
	}

	@Override
	public UUID getUniqueID() {
		return player.getUniqueID();
	}

	@Override
	public double getX() {
		return player.posX;
	}

	@Override
	public double getY() {
		return player.posY;
	}

	@Override
	public double getZ() {
		return player.posZ;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public void setLocation() {
	}
}
