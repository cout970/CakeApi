package org.cakepowered.api.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.world.World;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class ApiServer implements Server{

	public MinecraftServer server;
	
	public ApiServer(MinecraftServer minecraftServer){
		server = minecraftServer;
	}

	@Override
	public Collection<Player> getOnlinePlayers() {
		List<Player> list = new ArrayList<Player>();
		GameProfile[] players = server.getGameProfiles();
		if(players == null)return list;
		for(GameProfile p : players){
			Player pl = getPlayer(p.getId());
			if(pl != null)list.add(pl);
		}
		return list;
	}

	@Override
	public int getMaxPlayers() {
		return server.getMaxPlayers();
	}

	@Override
	public Player getPlayer(UUID uniqueId) {
		Entity t = server.getEntityFromUuid(uniqueId);
		if(t instanceof EntityPlayer)return ForgeInterface.getPlayer((EntityPlayer) t);
		return null;
	}

	@Override
	public Player getPlayer(String username) {
		GameProfile[] players = server.getGameProfiles();
		if(players == null)return null;
		for(GameProfile p : players){
			if(p.getName().equals(username)){
				return getPlayer(p.getId());
			}
		}
		return null;
	}

	@Override
	public World getWorld(String name) {
		for (WorldServer world : server.worldServers) {
			if(world.getWorldInfo().getWorldName().equals(name)){
				return new ApiWorld(world);
			}
		}
		return null;
	}

	@Override
	public int getRunningTimeTicks() {
		return server.getTickCounter();
	}

	@Override
	public void sendMessageToAll(String message) {
		for(Player p : getOnlinePlayers()){
			p.sendMessage(message);
		}
	}

}
