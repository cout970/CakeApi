package com.cout970.testplugin;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.text.TextFormating;

public class CommandKillPlayer extends CommandBase{

	public CommandKillPlayer() {
		super("killme");
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		Player p = commandSender.getPlayer();
		System.out.println(args);
		if(args != null)
			for(String a : args)
				System.out.println(a);
		if(p != null){
			p.sendMessage(TextFormating.DARK_AQUA+"I don't want to kill you");
			p.sendMessage(TextFormating.DARK_RED+"BUT I WILL DO IT!!!");
		}
	}
}
