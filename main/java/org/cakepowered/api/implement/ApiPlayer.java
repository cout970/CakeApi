package org.cakepowered.api.implement;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Vector3d;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ApiPlayer extends ApiEntity implements Player{
	
	public EntityPlayer player;

	public ApiPlayer(EntityPlayer player){
		super(player);
		this.player = player;
	}

	@Override
	public String getUserName() {
		return player.getName();
	}

	@Override
	public void sendMessage(String s) {
		player.addChatMessage(new ChatComponentText(s));
	}
	
	public boolean equals(Object o){
		if(o instanceof Player){
			return getUniqueID().equals(((Player) o).getUniqueID());
		}
		return false;
	}

	@Override
	public void setSpawnLocation(Vector3d loc) {
		player.setSpawnPoint(ForgeInterface.getBlockPos(loc), false);
	}

	@Override
	public void moveToWorld(PreciseLocation loc) {
		player.setPosition(loc.getX(), loc.getY(), loc.getZ());
		player.travelToDimension(loc.getWorld().getDimension());
		player.setPosition(loc.getX(), loc.getY(), loc.getZ());
	}

	@Override
	public PreciseLocation getLocation() {
		return new PreciseLocation(getWorld(), getPosition());
	}
}
