package com.cout970.testplugin;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;

public class CommandKillPlayer extends CommandBase{

	public CommandKillPlayer() {
		super("killme");
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		Player p = commandSender.getPlayer();
		if(p != null)
			Plugin.INSTANCE.game.getCommandDispacher().executeCommand(p.getCommandSender(), "/kill "+p.getUserName());
	}
}
