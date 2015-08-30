package org.cakepowered.mod.command;

import java.util.List;

import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public class DummyForgeCommand extends CommandBase {

	public CommandExecutor command;

	public DummyForgeCommand(CommandExecutor command) {
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

	@SuppressWarnings("rawtypes")
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
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		return command.addTabCompletionOptions(ForgeInterface.getCommandSender(sender), args,
				ForgeInterface.getVector3i(pos));
	}
}
