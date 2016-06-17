package org.cakepowered.mod.event;

import org.cakepowered.api.core.Game;
import org.cakepowered.api.util.Log;
import org.cakepowered.api.event.InitializationEvent;
import org.cakepowered.mod.core.ApiLog;

public class ApiInitializationEvent implements InitializationEvent {

	public Game game;

	public ApiInitializationEvent(Game g) {
		game = g;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public boolean isEventCancelable() {
		return false;
	}

	@Override
	public void setEventCanceled(boolean value) {
	}

	@Override
	public boolean isEventCanceled() {
		return false;
	}

	@Override
	public boolean hasEventResult() {
		return false;
	}

	@Override
	public EventResult getEventResult() {
		return EventResult.DEFAULT;
	}

	@Override
	public Log getLogger(String pluginId) {
		return new ApiLog(pluginId);
	}

}
