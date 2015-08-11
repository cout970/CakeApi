package org.cakepowered.api.base;

import org.cakepowered.api.command.CommandDispatcher;

public interface Game {
	
	public EventRegistry getEventRegistry();
	
	public Server getServer();
	
	public CommandDispatcher getCommandDispacher();
}
