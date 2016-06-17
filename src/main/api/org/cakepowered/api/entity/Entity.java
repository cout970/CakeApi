package org.cakepowered.api.entity;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.vector.Vector3d;
import org.cakepowered.api.world.World;

import java.util.UUID;

public interface Entity {

	UUID getUniqueID();

	World getWorld();

	String getName();

	String getModID();

	Vector3d getPosition();

	void setPosition(Vector3d vec);

	/**
	 * la entidad sobre la que esta montada
	 */
	Entity getRiddingEntity();

	/**
	 * entidad que esta montada encima
	 */
	Entity getRiddingByEntity();

	int getDimensionID();

	CommandSender getCommandSender();

	void setDead();
	
	Object getEntity();
}
