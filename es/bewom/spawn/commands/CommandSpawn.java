package es.bewom.spawn.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.BewomByte;
import es.bewom.spawn.SpawnManager;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandSpawn extends CommandBase {

	public CommandSpawn() {
		super("spawn");
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Ir al spawn.";
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

		if(SpawnManager.getSpawn() == null) {
			player.sendMessage(TextFormating.RED + "No hay un spawn.");
			return;
		}
		
		PreciseLocation loc = new PreciseLocation(
				BewomByte.game.getServer().getWorld(SpawnManager.getSpawn().getWorld()),
				SpawnManager.getSpawn().getVector());
		player.moveToWorld(loc);
		player.sendMessage(TextMessages.TP_SUCCESS);
	}

}
