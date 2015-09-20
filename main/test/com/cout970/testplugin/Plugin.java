package com.cout970.testplugin;

import java.util.Random;

import org.cakepowered.api.base.CakePlugin;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Log;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.InitializationEvent;
import org.cakepowered.api.event.PlayerChatEvent;
import org.cakepowered.api.util.Color;
import org.cakepowered.api.util.DyeColor;
import org.cakepowered.api.util.FireworkProperties;
import org.cakepowered.api.util.FireworkProperties.FireworkExplosion;
import org.cakepowered.api.util.FireworkProperties.FireworkType;
import org.cakepowered.api.world.World;

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
		Random r = new Random();
		game.getWorldManager().createNormalWorld(5, r.nextLong());
		game.getWorldManager().createNormalWorld(6, r.nextLong());
		game.getWorldManager().createNormalWorld(7, r.nextLong());
	}
	
	@EventSuscribe
	public void onChat(PlayerChatEvent event){
		Player p = event.getPlayer();
		World w = p.getWorld();
		FireworkExplosion explosion = new FireworkExplosion(FireworkType.LARGE, new Color[]{DyeColor.BLUE.getColor(),DyeColor.LIME.getColor()}, false, false, new Color[]{DyeColor.RED.getColor(),DyeColor.SILVER.getColor()});
		FireworkExplosion explosion1 = new FireworkExplosion(FireworkType.STAR, new Color[]{DyeColor.MAGENTA.getColor(),DyeColor.BROWN.getColor()}, false, false);
		FireworkProperties properties = new FireworkProperties((byte)0, explosion, explosion1);
		w.spawnFirework(p.getPosition(), properties);
	}
}
