package org.cakepowered.api.base;

import java.util.List;
import java.util.UUID;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.world.World;

public interface Server {

	public List<Player> getOnlinePlayers();

	public int getMaxPlayers();

	public Player getPlayer(UUID uniqueId);

	public Player getPlayer(String username);

	public World getWorld(int i);

	public int getRunningTimeTicks();

	public void sendMessageToAll(String message);

	public List<Player> getPlayersOP();

	public void setPlayerOP(Player p, boolean op);

	public CommandSender getCommandSender();
	
	public void stop();
}
