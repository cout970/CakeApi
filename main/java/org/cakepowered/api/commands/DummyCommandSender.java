package org.cakepowered.api.commands;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class DummyCommandSender implements ICommandSender{
	
	public CommandSender sender;

	public DummyCommandSender(CommandSender sender) {
		this.sender = sender;
	}

	@Override
	public String getName() {
		return sender.getName();
	}

	@Override
	public IChatComponent getDisplayName() {
		return new ChatComponentText(sender.getDisplayName());
	}

	@Override
	public void addChatMessage(IChatComponent message) {
		if(sender instanceof ApiCommandSender)((ApiCommandSender) sender).sender.addChatMessage(message);
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		if(sender instanceof ApiCommandSender) return ((ApiCommandSender) sender).sender.canUseCommand(permLevel, commandName);
		return false;
	}

	@Override
	public BlockPos getPosition() {
		if(sender instanceof ApiCommandSender) return ((ApiCommandSender) sender).sender.getPosition();
		return ForgeInterface.getBlockPos(sender.getPositionVector());
	}

	@Override
	public Vec3 getPositionVector() {
		if(sender instanceof ApiCommandSender) return ((ApiCommandSender) sender).sender.getPositionVector();
		return ForgeInterface.getVec3(sender.getPositionVector());
	}

	@Override
	public World getEntityWorld() {
		if(sender instanceof ApiCommandSender) return ((ApiCommandSender) sender).sender.getEntityWorld();
		return null;
	}

	@Override
	public Entity getCommandSenderEntity() {
		if(sender instanceof ApiCommandSender) return ((ApiCommandSender) sender).sender.getCommandSenderEntity();
		return null;
	}

	@Override
	public boolean sendCommandFeedback() {
		if(sender instanceof ApiCommandSender) return ((ApiCommandSender) sender).sender.sendCommandFeedback();
		return false;
	}

	@Override
	public void setCommandStat(Type type, int amount) {
		if(sender instanceof ApiCommandSender) ((ApiCommandSender) sender).sender.setCommandStat(type, amount);
	}
}
