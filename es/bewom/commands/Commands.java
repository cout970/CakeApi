package es.bewom.commands;

import org.cakepowered.api.command.CommandDispatcher;

import es.bewom.BewomByte;
import es.bewom.centrospokemon.commands.CommandCentro;
import es.bewom.centrospokemon.commands.CommandPonerCentro;
import es.bewom.centrospokemon.commands.CommandQuitarCentro;
import es.bewom.spawn.commands.CommandSetSpawn;
import es.bewom.spawn.commands.CommandSpawn;

public class Commands {

	public void registerAll() {
		CommandDispatcher reg = BewomByte.game.getCommandDispacher();
		
		//cp
		reg.registerCommand(new CommandCentro());		
		//ponercentro
		reg.registerCommand(new CommandPonerCentro());	
		//quitarcentro
		reg.registerCommand(new CommandQuitarCentro());	
		//setspawn
		reg.registerCommand(new CommandSetSpawn());		
		//spawn
		reg.registerCommand(new CommandSpawn());		
		
	}
}
