package org.cakepowered.api.event;

import org.cakepowered.api.core.Game;

public interface Event {

	Game getGame();

	boolean isEventCancelable();

	void setEventCanceled(boolean value);

	boolean isEventCanceled();

	boolean hasEventResult();

	EventResult getEventResult();

	enum EventResult {
		DENY, DEFAULT, ALLOW
	}
}
