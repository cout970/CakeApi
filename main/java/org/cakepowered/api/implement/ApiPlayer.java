package org.cakepowered.api.implement;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.DirectionYaw;
import org.cakepowered.api.scoreboard.ApiScoreboard;
import org.cakepowered.api.scoreboard.ApiTeam;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Title;
import org.cakepowered.api.util.TitleUtils;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.text.TextFormating;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
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

	public void sendTitle(Title t) {
		if(t == null)return;
		TitleUtils.sendTitle(((EntityPlayerMP)player).playerNetServerHandler, player, t);
	}

	@Override
	public Team getTeam() {
		return new ApiTeam((ScorePlayerTeam) (player.getTeam()));
	}

	@Override
	public Scoreboard getScoreboard() {
		return new ApiScoreboard(player.getWorldScoreboard());
	}

	@Override
	public void sendLink(String link) {
		IChatComponent chat = new ChatComponentText(link);
		ChatStyle style = new ChatStyle();
		style.setChatClickEvent(new ClickEvent(Action.OPEN_URL, TextFormating.toPlainString(link)));
		chat.setChatStyle(style);
		player.addChatMessage(chat);
	}
}
