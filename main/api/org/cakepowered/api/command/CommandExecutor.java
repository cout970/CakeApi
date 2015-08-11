package org.cakepowered.api.command;

import java.util.List;

import org.cakepowered.api.util.ForgeInterface;

public interface CommandExecutor {

	String getName();

	String getCommandUsage(CommandSender commandSender);

	List<String> getAllias();

	void execute(CommandSender commandSender, String[] args);

	boolean canCommandSenderUse(CommandSender commandSender);
	
}
