package org.cakepowered.api.commands;

import java.util.List;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.implement.ApiServer;

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
			try{
				if(CakeApiMod.server == null){
					CakeApiMod.logger.error("Invalid Registration before the server is started");
					return false;
				}
				MinecraftServer server = ((ApiServer)CakeApiMod.server).server;
				CommandHandler handler = (CommandHandler) server.getCommandManager(); 
				DummyCommand dummy = new DummyCommand(command);
				handler.registerCommand(dummy);
				registeredCommands.add(command);
				return true;
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public void executeCommand(CommandSender sender, String command) {
		MinecraftServer.getServer().getCommandManager().executeCommand(new DummyCommandSender(sender), command);
	}
}
