package org.cakepowered.api.base;

import org.cakepowered.api.util.DirectionYaw;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Vector3d;

public interface Player extends Entity{

	public String getUserName();
	
	public void sendMessage(String s);
	
	public void setSpawnLocation(Vector3d vec);

	public void moveToWorld(PreciseLocation loc);
	
	public void setLocation(PreciseLocation loc);

	public PreciseLocation getLocation();
	
	public int getDirection();
	
	public int getGameMode();
	public void setGameMode(int value);
	
	public boolean isOP();
}
