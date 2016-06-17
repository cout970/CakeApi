package org.cakepowered.api.event;

import org.cakepowered.api.entity.Entity;

public interface EntityAttackedEvent extends PlayerEvent {

	Entity getEntity();
}
