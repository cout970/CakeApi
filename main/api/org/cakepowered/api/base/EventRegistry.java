package org.cakepowered.api.base;

import org.cakepowered.api.event.Event;

public interface EventRegistry {

	public boolean postEvent(Event e);
	
	public boolean registerEventListener(Object o);
	
}
