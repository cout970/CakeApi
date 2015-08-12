package es.bewom.user.commands;

import java.util.Optional;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.BewomByte;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandSetLevel extends CommandBase {

	public CommandSetLevel() {
		super("perms", "lvl", "perm");
	}

	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Establecer el nivel de permisos a un jugador.";
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		boolean permissions = false;

		if (commandSender.getPlayer() != null) {
			BewomUser user = BewomUser.getUser(commandSender.getPlayer());
			if (user.getPermissionLevel() >= BewomUser.PERM_LEVEL_ADMIN) {
				permissions = true;
			}
		}

		if(permissions == false) {
			commandSender.sendMessage(TextMessages.NO_PERMISSIONS);
			return;
		}

		Player toChange = BewomByte.game.getServer().getPlayer(args[0]);
		int level = 0;
		try{
			level = Integer.parseInt(args[1]);
		}catch(NumberFormatException e){
			commandSender.sendMessage("Invalid Level");
			return;
		}

		if (toChange != null) {

			BewomUser user = BewomUser.getUser(toChange);
			String error = user.setPermissionLevel(level);

			if (error != null) {
				commandSender.sendMessage(error);
				return;
			}

			for(Team team : toChange.getWorld().getScoreboard().getTeams()) {
				team.removePlayer(toChange);
			}

			BewomUser p = BewomUser.getUser(toChange);
			p.setPermissionLevel(level);
			p.updatePermissions();		

			commandSender.sendMessage(TextFormating.RED + toChange.getUserName() + " ahora es nivel de permisos " + level);
		}
	}

	public int getRequiredPermissionLevel(){
        return 4;
    }
}
