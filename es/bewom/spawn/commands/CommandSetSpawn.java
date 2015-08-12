package es.bewom.spawn.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.spawn.SpawnManager;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandSetSpawn extends CommandBase {

	public CommandSetSpawn() {
		super("setspawn");
	}
	
	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Establecer el spawn.";
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		Player player;

		if(commandSender.getPlayer() != null) {
			player = commandSender.getPlayer();
		} else {
			commandSender.sendMessage(TextMessages.NOT_CONSOLE_COMPATIBLE);
			return;
		}

		BewomUser user = BewomUser.getUser(player);
		if(user.getPermissionLevel() < BewomUser.PERM_LEVEL_ADMIN) {
			player.sendMessage(TextMessages.NO_PERMISSIONS);
			return;
		}

		SpawnManager.setSpawn(player.getLocation());
		SpawnManager.save();
		player.sendMessage(TextFormating.RED + "Spawn establecido.");

	}
}
