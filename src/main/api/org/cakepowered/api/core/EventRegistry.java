package org.cakepowered.api.core;

import org.cakepowered.api.event.Event;
import org.cakepowered.api.event.EventSubscribe;

public interface EventRegistry {

	/**
	 * Fires an interactEvent that will listened by any registered methods that have this interactEvent or other interactEvent that
	 * extends/implements this interactEvent as parameter
	 */
	boolean postEvent(Event e);

	/**
	 * Register an interactEvent listener
	 * @param o
	 *            The instance of a class with one or more methods with the annotation {@link EventSubscribe}
	 *            and one interactEvent as parameter
	 */
	boolean registerEventListener(Object o);

}
