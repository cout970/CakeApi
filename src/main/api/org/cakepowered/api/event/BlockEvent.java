package org.cakepowered.api.event;

import org.cakepowered.api.util.vector.Vector3i;
import org.cakepowered.api.world.World;

public interface BlockEvent extends Event {

	Vector3i getPosition();

	World getWorld();
}
