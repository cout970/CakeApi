package org.cakepowered.api;

import org.cakepowered.api.base.CakePlugin;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Log;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.events.ApiInitializationEvent;
import org.cakepowered.api.events.ApiServerStartingEvent;
import org.cakepowered.api.events.ApiServerStoppingEvent;
import org.cakepowered.api.events.EventRedirect;
import org.cakepowered.api.implement.ApiEventRegistry;
import org.cakepowered.api.implement.ApiGame;
import org.cakepowered.api.implement.ApiLog;
import org.cakepowered.api.implement.ApiServer;
import org.cakepowered.api.plugin.PluginContainer;
import org.cakepowered.api.util.BlockUtils;
import org.cakepowered.api.util.Ref;
import org.cakepowered.api.util.TextUtils;
import org.cakepowered.api.world.ApiWorldManager;
import org.objectweb.asm.Type;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModContainerFactory;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

public class CakeApiMod extends DummyModContainer{

	public static Log logger;
	public static Game game;
	public static Server server;
	
	public CakeApiMod INSTANCE;
	
	public CakeApiMod(){
		super(new ModMetadata());
		//plugin loader
		ModContainerFactory.instance().registerContainerType(Type.getType(CakePlugin.class), PluginContainer.class);
		INSTANCE = this;
		TextUtils.registerModifiers();
		BlockUtils.registerBlocks();
		BlockUtils.registerEntities();
	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent event){
		logger = new ApiLog(Ref.MODID);
		game = new ApiGame();
		
		MinecraftForge.EVENT_BUS.register(new EventRedirect());
		FMLCommonHandler.instance().bus().register(new EventRedirect());
	}

	@Subscribe
	public void Init(FMLInitializationEvent event){
		server = new ApiServer(MinecraftServer.getServer());
		logger.info("Starting Plugin InitializationEvent");
		ApiEventRegistry.INSTANCE.postEvent(new ApiInitializationEvent(game));
	}
	
	@Subscribe
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	@Subscribe
	public void onServerStart(FMLServerStartingEvent event){
		ApiWorldManager.registerWorlds();	
		ApiEventRegistry.INSTANCE.postEvent(new ApiServerStartingEvent(event, server));
	}
	
	@Subscribe
	public void onServerStop(FMLServerStoppingEvent event){
		ApiEventRegistry.INSTANCE.postEvent(new ApiServerStoppingEvent(event, server));
	}
	
	@Override
    public boolean registerBus(EventBus bus, LoadController controller){
		bus.register(INSTANCE);
        return true;
    }

	@Override
	public Object getMod() {
		return this;
	}

	@Override
	public String getModId(){
		return Ref.MODID;
	}

	@Override
	public String getName(){
		return Ref.MODNAME;
	}
	
	@Override
	public String getVersion(){
		return Ref.VERSION;
	}

	@Override
	public boolean matches(Object mod){
		return mod == INSTANCE;
	}
	
	@Override
    public String getDisplayVersion(){
        return getVersion();
    }
}
