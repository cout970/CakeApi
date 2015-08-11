package org.cakepowered.api.command;

public interface CommandExecutor {

	CommandResult execute(CommandSender src, CommandArguments args) throws CommandException;
}
