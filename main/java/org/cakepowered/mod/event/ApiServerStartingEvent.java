package org.cakepowered.mod.event;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.event.ServerStatingEvent;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ApiServerStartingEvent implements ServerStatingEvent{

	public FMLServerStartingEvent event;
	public Server server;
	
	public ApiServerStartingEvent(FMLServerStartingEvent e, Server server){
		event = e;
		this.server = server;
	}
	
	@Override
	public Game getGame() {
		return ForgeInterface.getGame();
	}

	@Override
	public boolean isEventCancelable() {
		return false;
	}

	@Override
	public void setEventCanceled(boolean value) {}

	@Override
	public boolean isEventCanceled() {
		return false;
	}

	@Override
	public boolean hasEventResult() {
		return false;
	}

	@Override
	public EventResult getEventResult() {
		return EventResult.DEFAULT;
	}

	@Override
	public Server getServer() {
		return server;
	}
}
