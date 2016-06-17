package org.cakepowered.mod;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModContainerFactory;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.*;
import org.cakepowered.api.base.*;
import org.cakepowered.mod.base.ApiEventRegistry;
import org.cakepowered.mod.base.ApiGame;
import org.cakepowered.mod.base.ApiLog;
import org.cakepowered.mod.base.ApiServer;
import org.cakepowered.mod.event.ApiInitializationEvent;
import org.cakepowered.mod.event.ApiServerStartingEvent;
import org.cakepowered.mod.event.ApiServerStoppingEvent;
import org.cakepowered.mod.event.EventRedirect;
import org.cakepowered.mod.plugin.PluginContainer;
import org.cakepowered.mod.util.ApiFiller;
import org.cakepowered.mod.util.Ref;
import org.cakepowered.mod.util.TextUtils;
import org.objectweb.asm.Type;

public class CakeApiCore extends DummyModContainer {

	public static Log logger;
	public static Game game;
	public static Server server;

	public CakeApiCore INSTANCE;

	public CakeApiCore() {
		super(new ModMetadata());
		// plugin loader
		ModContainerFactory.instance().registerContainerType(Type.getType(CakePlugin.class), PluginContainer.class);
		INSTANCE = this;
	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {
		logger = new ApiLog(Ref.MODID);
		game = new ApiGame();
		References.GAME = game;

		TextUtils.registerModifiers();
		ApiFiller.registerTileEntities();
		ApiFiller.registerEnchantments();

		MinecraftForge.EVENT_BUS.register(new EventRedirect());
	}

	@Subscribe
	public void Init(FMLInitializationEvent event) {
		server = new ApiServer(MinecraftServer.getServer());
		References.SERVER = server;
		logger.info("Starting Plugin InitializationEvent");
		ApiEventRegistry.INSTANCE.postEvent(new ApiInitializationEvent(game));

	}

	@Subscribe
	public void postInit(FMLPostInitializationEvent event) {
	}

	@Subscribe
	public void onServerStart(FMLServerStartingEvent event) {
		ApiEventRegistry.INSTANCE.postEvent(new ApiServerStartingEvent(event, server));
	}

	@Subscribe
	public void onServerStop(FMLServerStoppingEvent event) {
		ApiEventRegistry.INSTANCE.postEvent(new ApiServerStoppingEvent(event, server));
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(INSTANCE);
		return true;
	}

	@Override
	public Object getMod() {
		return this;
	}

	@Override
	public String getModId() {
		return Ref.MODID;
	}

	@Override
	public String getName() {
		return Ref.MODNAME;
	}

	@Override
	public String getVersion() {
		return Ref.VERSION;
	}

	@Override
	public boolean matches(Object mod) {
		return mod == INSTANCE;
	}

	@Override
	public String getDisplayVersion() {
		return getVersion();
	}
}
