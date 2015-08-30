package org.cakepowered.api.command;

public interface CommandDispatcher {

	public boolean registerCommand(CommandExecutor command);

	public void executeCommand(CommandSender sender, String command);
}
