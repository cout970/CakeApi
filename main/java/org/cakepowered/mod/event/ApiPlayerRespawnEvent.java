package org.cakepowered.mod.event;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class ApiPlayerRespawnEvent implements org.cakepowered.api.event.PlayerRespawnEvent {

	public PlayerRespawnEvent event;

	public ApiPlayerRespawnEvent(PlayerRespawnEvent e) {
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
