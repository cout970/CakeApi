package org.cakepowered.api.implement;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.DirectionYaw;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Vector3d;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldSettings.GameType;

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
		player.travelToDimension(loc.getWorld().getDimension());
	}

	@Override
	public PreciseLocation getLocation() {
		return new PreciseLocation(getWorld(), getPosition(), player.rotationYaw, player.rotationPitch);
	}

	@Override
	public int getGameMode() {
		return ((EntityPlayerMP)player).theItemInWorldManager.getGameType().getID();
	}

	@Override
	public void setGameMode(int value) {
		GameType mode = GameType.getByID(value);
		player.setGameType(mode);
	}

	@Override
	public boolean isOP() {
		for(String s : ((ApiServer)CakeApiMod.server).server.getConfigurationManager().getOppedPlayerNames()){
			if(getUserName().equals(s)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void setLocation(PreciseLocation loc) {
		((EntityPlayerMP)player).playerNetServerHandler.setPlayerLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		
	}

	@Override
	public int getDirection() {
		float yaw = player.rotationYaw;
		if(yaw >= 135f && yaw < 225f){
			return DirectionYaw.NORTH;
		} else if(yaw >= 45f && yaw < 135){
			return DirectionYaw.WEST;
		} else if((yaw >= 0 && yaw < 45) || (yaw >= 315 && yaw <= 360)){
			return DirectionYaw.SOUTH;
		} else if(yaw >= 225 && yaw < 315){
			return DirectionYaw.EAST;
		}
		return 0;
	}
	
}
