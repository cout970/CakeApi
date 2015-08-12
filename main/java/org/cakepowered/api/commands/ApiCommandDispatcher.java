package org.cakepowered.api.commands;

import java.util.List;

import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;

public class ApiCommandDispatcher implements CommandDispatcher{

	public static ApiCommandDispatcher INSTANCE = new ApiCommandDispatcher();
	
	public List<CommandExecutor> registeredCommands = Lists.newArrayList();
	
	@Override
	public boolean registerCommand(CommandExecutor command) {
		if(command == null)return false;
		if(!registeredCommands.contains(command)){
			registeredCommands.add(command);
			((CommandHandler)MinecraftServer.getServer().getCommandManager()).registerCommand(new DummyCommand(command));
		}
		return false;
	}

	@Override
	public void executeCommand(CommandSender sender, String command) {
		MinecraftServer.getServer().getCommandManager().executeCommand(new DummyCommandSender(sender), command);
	}
}
