package org.cakepowered.mod.event;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.PlayerChatEvent;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.event.ServerChatEvent;

public class ApiPlayerChatEvent implements PlayerChatEvent{

	public ServerChatEvent event;
	
	public ApiPlayerChatEvent(ServerChatEvent e){
		event = e;
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
	public boolean isEventCanceled() {
		return event.isCanceled();
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
	public String getMessage() {
		return event.message;
	}

	@Override
	public String getUsername() {
		return ForgeInterface.getPlayer(event.player).getUserName();
	}

	@Override
	public Player getPlayer() {
		return ForgeInterface.getPlayer(event.player);
	}
}
