package org.cakepowered.api.command;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.Vector3i;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public interface CommandSender {

	String getName();
	
	String getDisplayName();
	
	boolean canUseCommand(int permLevel, String commandName);
	
	Vector3d getPositionVector();
	
	//can be null
	Player getPlayer();
}
