package org.cakepowered.api.core;

import org.cakepowered.api.event.Event;
import org.cakepowered.api.event.EventSubscribe;

public interface EventRegistry {

	/**
	 * Fires an event that will listened by any registered methods that have this event or other event that
	 * extends/implements this event as parameter
	 */
	boolean postEvent(Event e);

	/**
	 * Register an event listener
	 * @param o
	 *            The instance of a class with one or more methods with the annotation {@link EventSubscribe}
	 *            and one event as parameter
	 */
	boolean registerEventListener(Object o);

}
