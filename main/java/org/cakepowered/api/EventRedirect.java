package org.cakepowered.api;

import org.cakepowered.api.event.PlayerChatEvent;
import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.event.PlayerQuitEvent;
import org.cakepowered.api.events.ApiPlayerChatEvent;
import org.cakepowered.api.events.ApiPlayerJoinEvent;
import org.cakepowered.api.events.ApiPlayerQuitEvent;
import org.cakepowered.api.implement.ApiEventRegistry;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class EventRedirect {
	
	@SubscribeEvent
	public void onPlayerJoinEvent(PlayerLoggedInEvent e){
		PlayerJoinEvent event = new ApiPlayerJoinEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
	
	@SubscribeEvent
	public void onPlayerQuitEvent(PlayerLoggedOutEvent e){
		PlayerQuitEvent event = new ApiPlayerQuitEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
	
	@SubscribeEvent
	public void onPlayerChatEvent(ServerChatEvent e){
		PlayerChatEvent event = new ApiPlayerChatEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
}
