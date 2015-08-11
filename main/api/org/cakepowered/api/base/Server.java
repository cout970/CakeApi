package org.cakepowered.api.base;

import java.util.Collection;
import java.util.UUID;

public interface Server {

	public Collection<Player> getOnlinePlayers();
	
	public int getMaxPlayers();
	
	public Player getPlayer(UUID uniqueId);
	
	public Player getPlayer(String username);
	
	public World getWorld(String name);
}
