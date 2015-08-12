package es.bewom.teleport.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;

import es.bewom.teleport.TPManager;
import es.bewom.teleport.TPRequest;
import es.bewom.texts.TextMessages;

public class CommandTPADeny extends CommandBase {
	
	public CommandTPADeny() {
		super("tpdeny");
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Denegar la última solicitud de teletransporte.";
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		Player player2;

		if(commandSender.getPlayer() != null) {
			player2 = commandSender.getPlayer();
		} else {
			commandSender.sendMessage(TextMessages.NOT_CONSOLE_COMPATIBLE);
			return;
		}

		TPRequest request = TPManager.getRequest(player2);

		if(request == null) {
			commandSender.sendMessage(TextMessages.TP_NOT_FOUND);
			return;
		}

		Player player1 = request.getPlayer1();

		TPManager.deleteRequest(request);
		commandSender.sendMessage(TextMessages.TP_DENIED);
		player1.sendMessage(TextMessages.TP_DENIED);
	}
}
