package org.cakepowered.api.event;

import org.cakepowered.api.base.Server;

public interface ServerStatingEvent extends Event{

	public Server getServer();
}
