package org.cakepowered.api.command;

public interface CommandDispatcher {

	public boolean register(Object plugin, CommandDescription desc, String... alias);
	
	public CommandResult process(CommandSender src, CommandArguments args);
	
}
