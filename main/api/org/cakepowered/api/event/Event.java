package org.cakepowered.api.event;

import org.cakepowered.api.base.Game;

public interface Event {

	public Game getGame();
	
	public boolean isEventCancelable();
	public void setEventCanceled(boolean value);
	public boolean isEventCanceled();
	
	public boolean hasEventResult();
	public EventResult getEventResult();
	
	public enum EventResult{
		DENY, DEFAULT, ALLOW 
	}
}
