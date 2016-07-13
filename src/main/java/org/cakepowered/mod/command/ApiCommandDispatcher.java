package org.cakepowered.mod.command;

import com.google.common.collect.Lists;
import net.minecraft.command.CommandHandler;
import net.minecraft.server.MinecraftServer;
import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.util.PluginInterface;

import java.util.List;

public class ApiCommandDispatcher implements CommandDispatcher {

	public static ApiCommandDispatcher INSTANCE = new ApiCommandDispatcher();

	public List<CommandExecutor> registeredCommands = Lists.newArrayList();

	@Override
	public boolean registerCommand(CommandExecutor command) {
		if (command == null)
			return false;
		if (!registeredCommands.contains(command)) {
			try {
				if (CakeApiCore.server == null) {
					CakeApiCore.logger.error("Invalid Registration before the server is started");
					return false;
				}
				MinecraftServer server = PluginInterface.getServer(CakeApiCore.server);
				CommandHandler handler = (CommandHandler) server.getCommandManager();
				DummyForgeCommand dummy = new DummyForgeCommand(command);
				handler.registerCommand(dummy);
				registeredCommands.add(command);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public void executeCommand(CommandSender sender, String command) {
		CakeApiCore.getServer().getCommandManager().executeCommand(PluginInterface.getCommandSender(sender), command);
	}
}
