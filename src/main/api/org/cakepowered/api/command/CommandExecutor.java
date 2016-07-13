package org.cakepowered.api.command;

import org.cakepowered.api.util.Vector3;

import java.util.List;

public interface CommandExecutor {

	String getName();

	String getCommandUsage(CommandSender commandSender);

	List<String> getAlias();

	void execute(CommandSender commandSender, String[] args);

	List<String> addTabCompletionOptions(CommandSender sender, String[] args, Vector3 pos);

	boolean canBeUsedBy(CommandSender commandSender);

}
