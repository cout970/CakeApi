package org.cakepowered.api.command;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.util.vector.Vector3d;
import org.cakepowered.api.world.World;

public interface CommandSender {

	String getName();

	public String getDisplayName();

	public boolean canUseCommand(int permLevel, String commandName);

	Vector3d getPositionVector();

	// can be null
	Player getPlayer();

	World getWorld();

	void sendMessage(String message);
}
