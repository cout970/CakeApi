package org.cakepowered.api.command;

public class CommandDescription {

	public CommandExecutor executor;
	public String description;
	public String args;
	
	public CommandDescription(CommandExecutor exec, String description, String args){
		executor = exec;
		this.description = description;
	}
}
