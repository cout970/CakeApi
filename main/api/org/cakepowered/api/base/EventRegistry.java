package org.cakepowered.api.base;

import org.cakepowered.api.event.Event;
import org.cakepowered.api.event.EventSuscribe;

public interface EventRegistry {

	/**
	 * Fires an event that will listened by any registered methods that have this event or other event that extends/implements this event as parameter
	 */
	public boolean postEvent(Event e);
	
	/**
	 * Register an event listener
	 * @param o The instance of a class with one or more methods with the annotation {@link EventSuscribe} and one event as parameter 
	 */
	public boolean registerEventListener(Object o);
	
}
