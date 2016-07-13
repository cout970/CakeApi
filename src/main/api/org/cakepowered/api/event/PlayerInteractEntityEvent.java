package org.cakepowered.api.event;

import org.cakepowered.api.entity.Entity;

//Usad PlayerClickEntityEvent en vez de esta clase
@Deprecated
public interface PlayerInteractEntityEvent extends PlayerClickEntityEvent {

	default Entity getEntity(){
		return getTarget();
	}
}
