package org.cakepowered.api.command;

public interface CommandDispatcher {

	boolean registerCommand(CommandExecutor command);

	void executeCommand(CommandSender sender, String command);
}
