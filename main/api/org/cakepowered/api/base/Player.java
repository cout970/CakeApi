package org.cakepowered.api.base;

import java.util.UUID;

import org.cakepowered.api.util.Location;
import org.cakepowered.api.world.World;

public interface Player {

	public String getUserName();
	
	public UUID getUniqueID();
	
	public Location getLocation();
	public void setLocation();
	
	public World getWorld();
	
	public double getX();
	public double getY();
	public double getZ();
	
}
