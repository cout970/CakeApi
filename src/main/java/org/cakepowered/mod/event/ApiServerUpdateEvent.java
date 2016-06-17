package org.cakepowered.mod.event;

import org.cakepowered.api.core.Game;
import org.cakepowered.api.core.Server;
import org.cakepowered.api.event.ServerUpdateEvent;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class ApiServerUpdateEvent implements ServerUpdateEvent {

	public ServerTickEvent event;
	public Server server;

	public ApiServerUpdateEvent(ServerTickEvent e, Server server) {
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

	@Override
	public Phase getPhase() {
		return Phase.values()[event.phase.ordinal()];
	}
}
