package org.cakepowered.api;

import java.util.ArrayList;

import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.events.ApiPlayerJoinEvent;
import org.cakepowered.api.implement.ApiEventRegistry;
import org.cakepowered.api.util.MethodCaller;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventRedirect {
	
	@SubscribeEvent
	public void onPlayerJoinEvent(PlayerLoggedInEvent e){
		PlayerJoinEvent event = new ApiPlayerJoinEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
}
