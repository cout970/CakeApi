package org.cakepowered.api.event;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.world.World;

public interface EntitySpawnEvent extends Event {

	public World getWorld();

	public Entity getEntity();
}
