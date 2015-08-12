package org.cakepowered.api.event;

import org.cakepowered.api.base.Player;

public interface BlockBreakEvent extends BlockEvent{

	Player getPlayer();
}
