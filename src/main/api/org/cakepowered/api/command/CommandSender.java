package org.cakepowered.api.command;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;

public interface CommandSender {

	String getName();

	String getDisplayName();

	boolean canUseCommand(int permLevel, String commandName);

	Vector3 getPositionVector();

	// can be null
	Player getPlayer();

	World getWorld();

	void sendMessage(String message);
}
