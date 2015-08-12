package com.cout970.testplugin;

import org.cakepowered.api.base.CakePlugin;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Log;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.InitializationEvent;
import org.cakepowered.api.event.PlayerChatEvent;
import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.scoreboard.ApiTeam;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.text.TextFormating;
import org.cakepowered.api.util.text.TextModifier;

@CakePlugin(id = "plugin_id", name = "plugin_nombre", version = "plugin_0.0.0")
public class Plugin {

	public Log logger;
	public Game game;
	public static Plugin INSTANCE;
	
	@EventSuscribe
	public void onInit(InitializationEvent event){
		logger = event.getLogger("plugin_id");
		game = event.getGame();
		logger.info("debug plugin loaded Successful");
		INSTANCE = this;
//		game.getCommandDispacher().registerCommand(new CommandKillPlayer());
	}
	
//	@EventSuscribe
//	public void onPlayerChat(PlayerChatEvent event){
//		logger.info("Player: "+event.getPlayer().getUserName()+" write: "+event.getMessage());
//		event.setEventCanceled(true);
//		Team t = getTeam(event.getPlayer());
//		String message = "/"+event.getPlayer().getUserName()+" ";
//		boolean found = false;
//		for(Player p : t.getPlayers()){
//			if(p.getUniqueID().equals(event.getPlayer().getUniqueID())){
//				found = true;
//				break;
//			}
//		}
//		if(!found){
//			message += TextFormating.RED + event.getMessage();
//		}else{
//			message += TextFormating.DARK_AQUA + event.getMessage();
//		}
//		event.getPlayer().sendMessage(message);
//	}
//
//	@EventSuscribe
//	public void on(PlayerJoinEvent e){
//		Team t = getTeam(e.getPlayer());
//		t.addPlayer(e.getPlayer());
//	}
//	
//	public Team getTeam(Player p){
//		Team t = p.getWorld().getScoreboard().getTeam("admin");
//		if(t == null){
//			t = p.getWorld().getScoreboard().addTeam("admin");
//			t.setColor(TextFormating.DARK_AQUA);
//		}
//		return t;
//	}
}
