package org.cakepowered.api.events;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.PlayerQuitEvent;
import org.cakepowered.api.event.Event.EventResult;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class ApiPlayerQuitEvent implements PlayerQuitEvent{

	public PlayerLoggedOutEvent event;
	
	public ApiPlayerQuitEvent(PlayerLoggedOutEvent e){
		event = e;
	}

	@Override
	public Player getPlayer() {
		return ForgeInterface.getPlayer(event.player);
	}

	@Override
	public Game getGame() {
		return ForgeInterface.getGame();
	}

	@Override
	public boolean isEventCancelable() {
		return event.isCancelable();
	}

	@Override
	public void setEventCanceled(boolean value) {
		event.setCanceled(value);
	}

	@Override
	public boolean hasEventResult() {
		return event.hasResult();
	}

	@Override
	public EventResult getEventResult() {
		return ForgeInterface.getEventResult(event.getResult());
	}

	@Override
	public boolean isEventCanceled() {
		return event.isCanceled();
	}
}
