package es.bewom.teleport.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.BewomByte;
import es.bewom.teleport.TPManager;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandTPA extends CommandBase {

	public CommandTPA() {
		super("tpa");
	}
	
	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Enviar una solicitud a un jugador para teletransportarte a su posición";
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
		if(user.getPermissionLevel() < BewomUser.PERM_LEVEL_VIP) {
			player.sendMessage(TextMessages.NO_PERMISSIONS);
			return;
		}
		
		Player player2 = BewomByte.game.getServer().getPlayer(args[0]);
		
		TPManager.newRequest(player, player2, 2);
		
		commandSender.sendMessage(TextMessages.TP_REQUEST_SENT);
		player2.sendMessage("" + TextFormating.GREEN + TextFormating.BOLD + player.getUserName() + TextFormating.RED + TextFormating.RESET + " quiere teletransportarse a ti:");
		player2.sendMessage(TextFormating.RED + "    Usa /tpaccept para aceptar la solicitud.");
		player2.sendMessage(TextFormating.RED + "    Usa /tpdeny para denegar la solicitud.");
	}
}
