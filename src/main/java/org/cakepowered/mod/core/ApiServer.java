package org.cakepowered.mod.core;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.WorldServer;
import net.minecraftforge.server.command.ForgeCommand;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.core.Server;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.world.ApiWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ApiServer implements Server, IImplementation<MinecraftServer> {

	protected MinecraftServer server;
	public PlayerList config;

	public ApiServer(MinecraftServer minecraftServer) {
		server = minecraftServer;
		config = server.getPlayerList();
	}

	@Override
	public List<Player> getOnlinePlayers() {
		return server.getPlayerList().getPlayerList().stream().map(p -> ForgeInterface.getPlayer(p)).collect(Collectors.toList());
	}

	@Override
	public int getMaxPlayers() {
		return server.getMaxPlayers();
	}

	@Override
	public Player getPlayer(UUID uniqueId) {
		return getOnlinePlayers().stream().filter(p -> p.getUniqueID().equals(uniqueId)).findAny().orElse(null);
	}

	@Override
	public Player getPlayer(String username) {
		return getOnlinePlayers().stream().filter(p -> p.getUserName().equalsIgnoreCase(username)).findAny().orElse(null);
	}

	@Override
	public World getWorld(int id) {
		for (WorldServer world : server.worldServers) {
			if (world.provider.getDimension() == id) {
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
	
	@Override
	public void stop(){
		server.initiateShutdown();
	}
	
	@Override
	public double getTicks(){
		double meanTickTime = 0;
		try {
			meanTickTime = ForgeCommand.class.getDeclaredField("mean").getLong(server.tickTimeArray) * 1.0E-6D;
		} catch (Exception ignored) {}

		return Math.min(1000.0/meanTickTime, 20);
	}
}
