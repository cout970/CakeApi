package es.bewom.centrospokemon.commands;

import java.util.Optional;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.centrospokemon.CentroManager;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandQuitarCentro extends CommandBase {

	public CommandQuitarCentro() {
		super("quitarcentro", "quitarcp", "qcp");
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Eliminar el centro pokemon de la posición actual.";
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
		}

		String error = CentroManager.remove(player.getLocation());

		if(error != null) {
			player.sendMessage(TextFormating.RED + error);
			return;
		}

		player.sendMessage(TextFormating.RED + "Centro quitado correctamente.");
		CentroManager.save();
	}

}
