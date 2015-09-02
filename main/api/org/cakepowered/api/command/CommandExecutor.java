package org.cakepowered.api.command;

import java.util.List;

import org.cakepowered.api.util.Vector3i;

public interface CommandExecutor {

	String getName();

	String getCommandUsage(CommandSender commandSender);

	List<String> getAllias();

	void execute(CommandSender commandSender, String[] args);

	List<String> addTabCompletionOptions(CommandSender sender, String[] args, Vector3i pos);

	boolean canBeUsedBy(CommandSender commandSender);

}
