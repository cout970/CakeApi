package org.cakepowered.api.event;

import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.World;

public interface BlockEvent extends Event {

	public Vector3i getPosition();

	public World getWorld();
}
