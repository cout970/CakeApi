package org.cakepowered.api.command;

import java.util.ArrayList;
import java.util.List;

import org.cakepowered.api.util.Vector3i;

public abstract class CommandBase implements CommandExecutor {

	public String name;
	public List<String> alias;

	public CommandBase(String name, String... alias) {
		this.name = name;
		this.alias = new ArrayList<String>(alias.length);
		for (String s : alias)
			this.alias.add(s);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "/" + getName() + " ";
	}

	@Override
	public List<String> getAllias() {
		return alias;
	}

	@Override
	public List<String> addTabCompletionOptions(CommandSender sender, String[] args, Vector3i pos) {
		return null;
	}
	
	@Override
	public boolean canBeUsedBy(CommandSender commandSender){
		return true;
	}
}
