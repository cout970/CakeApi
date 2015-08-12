package org.cakepowered.api.event;

import org.cakepowered.api.base.Server;

public interface ServerUpdateEvent extends Event{

	Server getServer();
	
	Phase getPhase();
	
	public enum Phase{
		START,END
	}
}
