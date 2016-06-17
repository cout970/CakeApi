package org.cakepowered.api.command;

import org.cakepowered.api.util.vector.Vector3i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CommandBase implements CommandExecutor {

	public String name;
	public List<String> alias;

	public CommandBase(String name, String... alias) {
		this.name = name;
		this.alias = new ArrayList<>(alias.length);
		Collections.addAll(this.alias, alias);
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
	public List<String> getAlias() {
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
