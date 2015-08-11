package org.cakepowered.api.base;

public interface Game {
	
	public EventRegistry getEventRegistry();
	
	//only available after the event ServerStatingEvent has been fired
	public Server getServer();
}
