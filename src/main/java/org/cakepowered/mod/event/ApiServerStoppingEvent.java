package org.cakepowered.mod.event;

import org.cakepowered.api.core.Game;
import org.cakepowered.api.core.Server;
import org.cakepowered.api.event.ServerStoppingEvent;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

public class ApiServerStoppingEvent implements ServerStoppingEvent {

	public FMLServerStoppingEvent event;
	public Server server;

	public ApiServerStoppingEvent(FMLServerStoppingEvent e, Server server) {
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
	public void setEventCanceled(boolean value) {
	}

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
