package org.cakepowered.api.event;

import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.world.World;

public interface EntitySpawnEvent extends Event {

	World getWorld();

	Entity getEntity();
}
