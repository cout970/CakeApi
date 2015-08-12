package org.cakepowered.api.event;

import org.cakepowered.api.base.Player;

public interface BlockPlaceEvent extends BlockEvent{

	public Player getPlayer();
}
