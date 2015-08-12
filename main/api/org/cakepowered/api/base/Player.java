package org.cakepowered.api.base;

import java.util.UUID;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

public interface Player extends Entity{

	public String getUserName();
	
	public void sendMessage(String s);
}
