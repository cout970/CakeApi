package org.cakepowered.api.implement;

import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

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
	public World getWorld() {
		return new ApiWorld(player.worldObj);
	}

	@Override
	public Vector3d getPosition() {
		return new Vector3d(player.posX, player.posY, player.posZ);
	}
	
	public void setPosition(Vector3d vec) {
		player.setPosition(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public CommandSender getCommandSender() {
		return ForgeInterface.getCommandSender(player);
	}
}
