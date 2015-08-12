package org.cakepowered.api.events;

import org.cakepowered.api.event.BlockBreakEvent;
import org.cakepowered.api.event.BlockPlaceEvent;
import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.PlayerChatEvent;
import org.cakepowered.api.event.PlayerInteractEntityEvent;
import org.cakepowered.api.event.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.event.PlayerQuitEvent;
import org.cakepowered.api.event.PlayerRespawnEvent;
import org.cakepowered.api.implement.ApiEventRegistry;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
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
	
	@SubscribeEvent
	public void onPlayerRespawn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent e){
		PlayerRespawnEvent event = new ApiPlayerRespawnEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
	
	@SubscribeEvent
	public void onPlayerInteractEvent(net.minecraftforge.event.entity.player.PlayerInteractEvent e){
		PlayerInteractEvent event = new ApiPlayerInteractEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
	
	@EventSuscribe
	public void onBlockBreak(BreakEvent e){
		BlockBreakEvent event = new ApiBlockBreakEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
	
	@EventSuscribe
	public void onBlockPlace(PlaceEvent e){
		BlockPlaceEvent event = new ApiBlockPlaceEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
	
	@EventSuscribe
	public void onEntityInteract(EntityInteractEvent e){
		PlayerInteractEntityEvent event = new ApiPlayerInteractEntityEvent(e);
		ApiEventRegistry.INSTANCE.postEvent(event);
	}
}
