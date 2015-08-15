package org.cakepowered.api.command;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandBase implements CommandExecutor{

	public String name;
	public List<String> alias;
	
	public CommandBase(String name, String... alias){
		this.name = name;
		this.alias = new ArrayList<String>(alias.length);
		for(String s : alias)
			this.alias.add(s);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "";
	}

	@Override
	public List<String> getAllias() {
		return alias;
	}
	
}
