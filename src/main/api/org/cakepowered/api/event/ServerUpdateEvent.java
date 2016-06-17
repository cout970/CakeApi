package org.cakepowered.api.event;

import org.cakepowered.api.core.Server;

public interface ServerUpdateEvent extends Event {

	Server getServer();

	Phase getPhase();

	enum Phase {
		START, END
	}
}
