package org.cakepowered.api.base;

import java.util.UUID;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

public interface Player {

	public String getUserName();
	
	public UUID getUniqueID();
	
	public World getWorld();
	
	public Vector3d getPosition();
	public void setPosition(Vector3d vec);

	public CommandSender getCommandSender();
	
}
