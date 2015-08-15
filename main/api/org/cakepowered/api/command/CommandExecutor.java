package org.cakepowered.api.command;

import java.util.List;

public interface CommandExecutor {

	String getName();

	String getCommandUsage(CommandSender commandSender);

	List<String> getAllias();

	void execute(CommandSender commandSender, String[] args);
	
}
