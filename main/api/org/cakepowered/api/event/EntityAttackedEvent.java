package org.cakepowered.api.event;

import org.cakepowered.api.base.Entity;

public interface EntityAttackedEvent extends PlayerEvent{

	public Entity getEntity();
}
