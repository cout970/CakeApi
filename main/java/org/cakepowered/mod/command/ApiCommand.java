package org.cakepowered.mod.command;

import java.util.List;

import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;

public class ApiCommand implements CommandExecutor{

	public ICommand command;
	
	public ApiCommand(ICommand command) {
		this.command = command;
	}

	@Override
	public String getName() {
		return command.getName();
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return command.getCommandUsage(PluginInterface.getCommandSender(commandSender));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllias() {
		return command.getAliases();
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		try {
			command.execute(PluginInterface.getCommandSender(commandSender), args);
		} catch (CommandException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> addTabCompletionOptions(CommandSender sender, String[] args, Vector3i pos) {
		return command.addTabCompletionOptions(PluginInterface.getCommandSender(sender), args, PluginInterface.getBlockPos(pos));
	}
}
