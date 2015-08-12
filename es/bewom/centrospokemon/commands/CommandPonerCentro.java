package es.bewom.centrospokemon.commands;

import java.util.Optional;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.centrospokemon.CentroManager;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandPonerCentro extends CommandBase {

	public CommandPonerCentro() {
		super("ponercentro", "ponercp", "pcp");
	}
	
	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Establecer un centro pokemon en la posición actual.";
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		Player player = null;

		if(commandSender.getPlayer() != null) {
			player = commandSender.getPlayer();
		} else {
			commandSender.sendMessage(TextMessages.NOT_CONSOLE_COMPATIBLE);
		}

		BewomUser user = BewomUser.getUser(player);
		if(user.getPermissionLevel() < BewomUser.PERM_LEVEL_ADMIN) {
			player.sendMessage(TextFormating.RED + "No tienes permisos.");
			return;
		}

		String error = CentroManager.add(player.getLocation());

		if(error != null) {
			commandSender.sendMessage(TextFormating.RED + error);
			return;
		}

		player.sendMessage(TextFormating.RED + "Centro establecido correctamente.");
		CentroManager.save();
	}
}
