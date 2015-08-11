package org.cakepowered.api.event;

import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.util.Direction;

public interface PlayerInteractEvent extends PlayerEvent{

	public Vector3i getBlock();
	public Direction getFace();
	public ClickAction getAction();
	
	public enum ClickAction{
		RIGHT_CLICK_AIR,
        RIGHT_CLICK_BLOCK,
        LEFT_CLICK_BLOCK
	}
}
