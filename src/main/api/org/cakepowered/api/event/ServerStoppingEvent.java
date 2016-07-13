package org.cakepowered.api.event;

import org.cakepowered.api.core.Server;

public interface ServerStoppingEvent extends Event {

	Server getServer();
}
