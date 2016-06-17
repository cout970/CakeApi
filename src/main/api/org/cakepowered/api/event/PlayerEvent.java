package org.cakepowered.api.event;

import org.cakepowered.api.base.Player;

public interface PlayerEvent extends Event {

	public Player getPlayer();
}
