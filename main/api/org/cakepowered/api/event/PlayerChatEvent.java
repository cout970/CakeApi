package org.cakepowered.api.event;

import org.cakepowered.api.base.Player;

public interface PlayerChatEvent extends Event{

	public String getMessage();
	public String getUsername();
	public Player getPlayer();	
}
