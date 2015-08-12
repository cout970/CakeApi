package org.cakepowered.api.command;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.Vector3d;

public interface CommandSender {

	String getName();
	
	String getDisplayName();
	
	boolean canUseCommand(int permLevel, String commandName);
	
	Vector3d getPositionVector();
	
	//can be null
	Player getPlayer();
}
