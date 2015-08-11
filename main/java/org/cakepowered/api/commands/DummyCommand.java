package org.cakepowered.api.commands;

import java.util.List;

import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public class DummyCommand extends CommandBase{
		
	public CommandExecutor command;
	
	public DummyCommand(CommandExecutor command){
		this.command = command;
	}

	@Override
	public String getName() {
		return command.getName();
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		
		return command.getCommandUsage(ForgeInterface.getCommandSender(sender));
	}

	@Override
	public List getAliases() {
		return command.getAllias();
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		command.execute(ForgeInterface.getCommandSender(sender), args);
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		return command.canCommandSenderUse(ForgeInterface.getCommandSender(sender));
	}
}
