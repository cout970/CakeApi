package org.cakepowered.api.event;

import org.cakepowered.api.base.Server;

public interface ServerStoppingEvent extends Event{

	public Server getServer();
}
