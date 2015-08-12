package org.cakepowered.api.event;

import org.cakepowered.api.util.Direction;
import org.cakepowered.api.util.Vector3i;

public interface PlayerInteractEvent extends PlayerEvent{

	public Vector3i getPosition();
	public Direction getFace();
	public ClickAction getAction();
	
	public enum ClickAction{
		RIGHT_CLICK_AIR,
        RIGHT_CLICK_BLOCK,
        LEFT_CLICK_BLOCK
	}
}
