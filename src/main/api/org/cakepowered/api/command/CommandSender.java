package org.cakepowered.api.command;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

public interface CommandSender {

	public String getName();

	public String getDisplayName();

	public boolean canUseCommand(int permLevel, String commandName);

	public Vector3d getPositionVector();

	// can be null
	public Player getPlayer();

	public World getWorld();

	public void sendMessage(String message);
}
