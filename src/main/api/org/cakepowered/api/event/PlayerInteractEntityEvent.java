package org.cakepowered.api.event;

import org.cakepowered.api.entity.Entity;

public interface PlayerInteractEntityEvent extends PlayerEvent {

	Entity getEntity();
}
