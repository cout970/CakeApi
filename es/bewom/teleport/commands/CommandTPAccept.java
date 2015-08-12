package es.bewom.teleport.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;

import es.bewom.teleport.TPManager;
import es.bewom.teleport.TPRequest;
import es.bewom.texts.TextMessages;

public class CommandTPAccept extends CommandBase {

	public CommandTPAccept() {
		super("tpaccept");
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Aceptar la última solicitud de teletransporte.";
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
		
		if(TPManager.validateRequest(request)) {
			
			if(request.getObjective() == 2) {
				Player player1 = request.getPlayer1();
				if(player1.getDimensionID() != player2.getDimensionID()){
					player1.moveToWorld(player2.getLocation());
				}else{
					player1.setPosition(player2.getPosition());
				}
				player1.sendMessage(TextMessages.TP_SUCCESS);
				return;
			} else {
				Player player1 = request.getPlayer1();
				if(player2.getDimensionID() != player1.getDimensionID()){
					player2.moveToWorld(player1.getLocation());
				}else{
					player2.setPosition(player1.getPosition());
				}
				player2.sendMessage(TextMessages.TP_SUCCESS);
				return;
			}
			
		}
		
		commandSender.sendMessage(TextMessages.TP_EXPIRED);
	}
}
