package org.cakepowered.api.base;

import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.world.WorldManager;

public interface Game {
	
	public EventRegistry getEventRegistry();
	
	public Server getServer();
	
	public CommandDispatcher getCommandDispacher();
	
	public WorldManager getWorldManager();
}
