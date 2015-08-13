package org.cakepowered.api.implement;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Player;
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
		player.setPosition(loc.getX(), loc.getY(), loc.getZ());
		player.travelToDimension(loc.getWorld().getDimension());
		player.setPosition(loc.getX(), loc.getY(), loc.getZ());
	}

	@Override
	public PreciseLocation getLocation() {
		return new PreciseLocation(getWorld(), getPosition());
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
	
}
