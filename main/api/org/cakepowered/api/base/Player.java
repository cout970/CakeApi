package org.cakepowered.api.base;

import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

public interface Player extends Entity{

	public String getUserName();
	
	public void sendMessage(String s);
	
	public void setSpawnLocation(Vector3d vec);

	public void moveToWorld(PreciseLocation loc);
}
