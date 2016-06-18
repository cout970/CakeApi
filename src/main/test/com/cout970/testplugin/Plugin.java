package com.cout970.testplugin;

import org.cakepowered.api.core.CakePlugin;
import org.cakepowered.api.core.Game;
import org.cakepowered.api.event.EventSubscribe;
import org.cakepowered.api.event.InitializationEvent;
import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.util.Log;

@CakePlugin(id = "plugin_id", name = "plugin_nombre", version = "plugin_0.0.0")
public class Plugin {

    public Log logger;
    public Game game;
    public static Plugin INSTANCE;

    @EventSubscribe
    public void onInit(InitializationEvent event) {
        logger = event.getLogger("plugin_id");
        game = event.getGame();
        logger.info("debug plugin loaded Successfully");
        INSTANCE = this;
    }

    @EventSubscribe
    public void onChat(PlayerJoinEvent event) {
//        Player p = event.getPlayer();
//        p.moveToWorld(new PreciseLocation(5, new Vector3(0, 0, 0), 0, 0));
//        World w = p.getWorld();
//        FireworkExplosion explosion = new FireworkExplosion(FireworkType.LARGE, new Color[]{DyeColor.ORANGE.getColor(), DyeColor.RED.getColor()}, true, false, DyeColor.RED.getColor());
//        FireworkExplosion explosion1 = new FireworkExplosion(FireworkType.SMALL, new Color[]{DyeColor.YELLOW.getColor(), DyeColor.ORANGE.getColor()}, false, false, DyeColor.RED.getColor());
//        FireworkProperties properties = new FireworkProperties((byte) 0, explosion, explosion, explosion1);
//        w.spawnFirework(p.getPosition(), properties);
    }
}
