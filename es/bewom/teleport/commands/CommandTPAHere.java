package es.bewom.teleport.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.BewomByte;
import es.bewom.teleport.TPManager;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandTPAHere extends CommandBase {
	
	public CommandTPAHere(String name, String[] alias) {
		super("tpahere");
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Enviar una solicitud a un jugador para teletransportarlo a tu posici�n.";
	}
	
	@Override
	public void execute(CommandSender commandSender, String[] args) {
		Player player1;

		if(commandSender.getPlayer() != null) {
			player1 = commandSender.getPlayer();
		} else {
			commandSender.sendMessage(TextMessages.NOT_CONSOLE_COMPATIBLE);
			return;
		}
		
		BewomUser user = BewomUser.getUser(player1);
		if(user.getPermissionLevel() < BewomUser.PERM_LEVEL_VIP) {
			player1.sendMessage(TextMessages.NO_PERMISSIONS);
			return;
		}
		
		Player player2 = BewomByte.game.getServer().getPlayer(args[0]);
		
		TPManager.newRequest(player1, player2, 1);
		
		commandSender.sendMessage(TextFormating.RED + "Teleport request sent.");
		player2.sendMessage("" + TextFormating.GREEN + TextFormating.BOLD + player1.getUserName() + TextFormating.RED + TextFormating.RESET + " quiere que te teletransportes a él:");
		player2.sendMessage(TextFormating.RED + "    Usa /tpaccept para aceptar la solicitud.");
		player2.sendMessage(TextFormating.RED + "    Usa /tpdeny para denegar la solicitud.");
		
	}
}
