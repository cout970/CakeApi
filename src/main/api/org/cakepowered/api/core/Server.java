package org.cakepowered.api.core;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.world.World;

import java.util.List;
import java.util.UUID;

public interface Server {

	List<Player> getOnlinePlayers();

	int getMaxPlayers();

	Player getPlayer(UUID uniqueId);

	Player getPlayer(String username);

	World getWorld(int i);

	int getRunningTimeTicks();

	void sendMessageToAll(String message);

	List<Player> getPlayersOP();

	void setPlayerOP(Player p, boolean op);

	CommandSender getCommandSender();
	
	void stop();

	double getTicks();
}
