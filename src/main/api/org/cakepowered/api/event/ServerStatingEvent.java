package org.cakepowered.api.event;

import org.cakepowered.api.core.Server;

public interface ServerStatingEvent extends Event {

	Server getServer();
}
