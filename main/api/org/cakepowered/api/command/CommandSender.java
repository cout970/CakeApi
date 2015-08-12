package org.cakepowered.api.command;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.Vector3d;

public interface CommandSender {

	public String getName();
	
	public String getDisplayName();
	
	public boolean canUseCommand(int permLevel, String commandName);
	
	public Vector3d getPositionVector();
	
	//can be null
	public Player getPlayer();

	public void sendMessage(String message);
}
