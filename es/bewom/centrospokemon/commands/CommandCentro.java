package es.bewom.centrospokemon.commands;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandBase;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.text.TextFormating;
import org.cakepowered.api.world.World;

import es.bewom.BewomByte;
import es.bewom.centrospokemon.CentroManager;
import es.bewom.centrospokemon.CentroPokemon;
import es.bewom.texts.TextMessages;
import es.bewom.user.BewomUser;

public class CommandCentro extends CommandBase {
	
	public CommandCentro() {
		super("cp", "centro", "centropokemon");
	}
	
	@Override
	public String getCommandUsage(CommandSender commandSender) {
		return "Ir al centro pokemon más cercano.";
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

		CentroPokemon cp = CentroManager.getClosest(player.getLocation());
		if(cp == null) {
			player.sendMessage(TextFormating.RED + "No hay Centros Pokemon cercanos.");
			return;
		}
		
		World world = BewomByte.game.getServer().getWorld(cp.getWorld());
		player.moveToWorld(new PreciseLocation(world, cp.getVector()));
		player.sendMessage(TextFormating.RED + "Teletransporte exitoso.");
	}

}
