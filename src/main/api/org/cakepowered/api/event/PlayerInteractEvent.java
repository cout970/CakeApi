package org.cakepowered.api.event;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.util.Direction;
import org.cakepowered.api.util.vector.Vector3;
import org.cakepowered.api.world.World;

public interface PlayerInteractEvent extends PlayerEvent {

	Vector3 getPosition();

	Direction getFace();

	ClickAction getAction();

	World getWorld();

	enum ClickAction {
		RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK, LEFT_CLICK_BLOCK
	}

	Block getInteractBlock();
}
