package org.cakepowered.mod.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.world.ApiWorld;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.WorldServer;

public class ApiServer implements Server, IImplementation<MinecraftServer> {

	protected MinecraftServer server;
	public ServerConfigurationManager config;

	public ApiServer(MinecraftServer minecraftServer) {
		server = minecraftServer;
		config = server.getConfigurationManager();
	}

	@Override
	public List<Player> getOnlinePlayers() {
		List<Player> list = new ArrayList<Player>();
		GameProfile[] players = server.getGameProfiles();
		if (players == null)
			return list;
		for (GameProfile p : players) {
			Player pl = getPlayer(p.getId());
			if (pl != null)
				list.add(pl);
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
		if (t instanceof EntityPlayer)
			return ForgeInterface.getPlayer((EntityPlayer) t);
		return null;
	}

	@Override
	public Player getPlayer(String username) {
		GameProfile[] players = server.getGameProfiles();
		if (players == null)
			return null;
		for (GameProfile p : players) {
			if (p.getName().toLowerCase().equals(username.toLowerCase())) {
				return getPlayer(p.getId());
			}
		}
		return null;
	}

	@Override
	public World getWorld(int id) {
		for (WorldServer world : server.worldServers) {
			if (world.provider.getDimensionId() == id) {
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
		for (Player p : getOnlinePlayers()) {
			p.sendMessage(message);
		}
	}

	@Override
	public List<Player> getPlayersOP() {
		List<Player> ops = Lists.newArrayList();
		for (String s : config.getOppedPlayerNames()) {
			Player p = getPlayer(s);
			if (p != null)
				ops.add(p);
		}
		return ops;
	}

	@Override
	public void setPlayerOP(Player p, boolean op) {
		if (op) {// op
			if (!p.isOP()) {
				for (GameProfile gp : server.getGameProfiles()) {
					if (gp.getId().equals(p.getUniqueID())) {
						config.addOp(gp);
						break;
					}
				}
			}
		} else {// deop
			if (p.isOP()) {
				for (GameProfile gp : server.getGameProfiles()) {
					if (gp.getId().equals(p.getUniqueID())) {
						config.removeOp(gp);
						break;
					}
				}

			}
		}
	}

	@Override
	public CommandSender getCommandSender() {
		return ForgeInterface.getCommandSender(server);
	}

	@Override
	public MinecraftServer getMcObject() {
		return server;
	}
}
