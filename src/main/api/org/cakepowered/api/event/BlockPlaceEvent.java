package org.cakepowered.api.event;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.block.Block;

public interface BlockPlaceEvent extends BlockEvent {

	Player getPlayer();

	Block getBlock();
}
