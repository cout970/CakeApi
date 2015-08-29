package org.cakepowered.api.event;

import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;

public interface CommandExecuteEvent extends Event{

	public CommandExecutor getCommandExecutor();
	
	public CommandSender getCommandSender();
	
	public String[] getArguments();
	
	public void setArguments(String[] args);
	
	public void setThrowable(Throwable exception);
}
