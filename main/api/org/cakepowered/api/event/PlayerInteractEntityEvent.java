package org.cakepowered.api.event;

import org.cakepowered.api.base.Entity;

public interface PlayerInteractEntityEvent extends PlayerEvent{

	Entity getEntity();
}
