package org.cakepowered.api.event;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.block.Block;

public interface BlockPlaceEvent extends BlockEvent{

	public Player getPlayer();
	
	public Block getBlock();
}
