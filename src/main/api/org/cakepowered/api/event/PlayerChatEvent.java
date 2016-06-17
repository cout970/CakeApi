package org.cakepowered.api.event;

import org.cakepowered.api.entity.Player;

public interface PlayerChatEvent extends Event {

	String getMessage();

	String getUsername();

	Player getPlayer();
}
