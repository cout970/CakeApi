package org.cakepowered.mod.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;

public class ApiCommandSender implements CommandSender, IImplementation<ICommandSender> {

	protected ICommandSender sender;

	public ApiCommandSender(ICommandSender sender) {
		this.sender = sender;
	}

	@Override
	public String getName() {
		return sender.getName();
	}

	@Override
	public String getDisplayName() {
		ITextComponent comp = sender.getDisplayName();
		if (comp == null)
			return getName();
		return comp.getUnformattedText();
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		return sender.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public Vector3 getPositionVector() {
		return ForgeInterface.getVector3(sender.getPositionVector());
	}

	@Override
	public Player getPlayer() {
		if (sender instanceof EntityPlayer)
			return ForgeInterface.getPlayer((EntityPlayer) sender);
		return null;
	}

	@Override
	public void sendMessage(String message) {
		sender.addChatMessage(new TextComponentString(message));
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(sender.getEntityWorld());
	}

	@Override
	public ICommandSender getMcObject() {
		return sender;
	}
}
