package org.cakepowered.api.event;

import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;

public interface CommandExecuteEvent extends Event {

	CommandExecutor getCommandExecutor();

	CommandSender getCommandSender();

	String[] getArguments();

	void setArguments(String[] args);

	void setThrowable(Throwable exception);
}
