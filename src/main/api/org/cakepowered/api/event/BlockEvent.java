package org.cakepowered.api.event;

import org.cakepowered.api.util.vector.Vector3;
import org.cakepowered.api.world.World;

public interface BlockEvent extends Event {

	Vector3 getPosition();

	World getWorld();
}
