package org.cakepowered.mod.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.vector.Vector3;
import org.cakepowered.mod.util.PluginInterface;

import java.util.List;

public class ApiCommand implements CommandExecutor {

	public ICommand command;

	public ApiCommand(ICommand command) {
		this.command = command;
	}

	@Override
	public String getName() {
		return command.getCommandName();
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return command.getCommandUsage(PluginInterface.getCommandSender(commandSender));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAlias() {
		return command.getCommandAliases();
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		try {
			command.processCommand(PluginInterface.getCommandSender(commandSender), args);
		} catch (CommandException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> addTabCompletionOptions(CommandSender sender, String[] args, Vector3 pos) {
		return command.addTabCompletionOptions(PluginInterface.getCommandSender(sender), args,
				PluginInterface.getBlockPos(pos));
	}

	@Override
	public boolean canBeUsedBy(CommandSender commandSender) {
		return command.canCommandSenderUseCommand(PluginInterface.getCommandSender(commandSender));
	}
}
