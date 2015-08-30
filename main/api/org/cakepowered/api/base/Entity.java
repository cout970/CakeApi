package org.cakepowered.api.base;

import java.util.UUID;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

public interface Entity {

	public UUID getUniqueID();

	public World getWorld();

	public String getName();

	public String getModID();

	public Vector3d getPosition();

	public void setPosition(Vector3d vec);

	/**
	 * la entidad sobre la que esta montada
	 */
	public Entity getRiddingEntity();

	/**
	 * entidad que esta montada encima
	 */
	public Entity getRiddingByEntity();

	public int getDimensionID();

	public CommandSender getCommandSender();

	public void setDead();
}
