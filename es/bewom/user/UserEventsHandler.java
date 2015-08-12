package es.bewom.user;

import java.util.UUID;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.BlockBreakEvent;
import org.cakepowered.api.event.BlockPlaceEvent;
import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.PlayerChatEvent;
import org.cakepowered.api.event.PlayerInteractEntityEvent;
import org.cakepowered.api.event.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.event.PlayerQuitEvent;
import org.cakepowered.api.event.PlayerRespawnEvent;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.text.TextFormating;

import es.bewom.centrospokemon.CentroManager;
import es.bewom.centrospokemon.CentroPokemon;
import es.bewom.p.P;

public class UserEventsHandler {
	
	private Game game;
	
	public UserEventsHandler(Game game) {
		this.game = game;
	}

	/**
	 * Event triggered when a player joins the server.
	 * 
	 * @param event
	 */
	@EventSuscribe
	public void onUserJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		CentroPokemon cp = CentroManager.getClosest(player.getLocation());
		if(cp != null) {
			Vector3d vec = cp.getVector().add(0.5, 0, 0.5);
			player.setPosition(vec);
		}
		
		BewomUser user = new BewomUser(player);
		BewomUser.addUser(user);
		
		System.out.println(user.getLastMove());
		
		player.sendMessage("//login");
		
		if (user.getRegistration() == WebRegistration.VALID) {
//			player.sendTitle(
//				Titles.builder()
//					.title(Texts.of(TextColors.DARK_AQUA, "Bienvenid@!"))
//					.subtitle(Texts.of(TextColors.WHITE, "Hazte con todos..."))
//					.stay(120)
//					.build());
			user.updatePermissions();
		} else if (user.getRegistration() == WebRegistration.NOT_VALID) {
//			player.sendTitle(
//				Titles.builder()
//					.title(Texts.of(TextColors.DARK_RED, "Verifica tu correo!"))
//					.subtitle(Texts.of(TextColors.WHITE, "Si no encuentras el correo, busca en spam..."))
//					.stay(72000)
//					.build());
			
//			Sigo sin saber que hace esto de player.offer
//			player.offer(event.getUser().getGameModeData().type().set(GameModes.SPECTATOR));
			
		} else if (user.getRegistration() == WebRegistration.NOT_REGISTERED) {
			user.createHashFirstTime();
			
//			player.sendTitle(
//				Titles.builder()
//					.title(Texts.of(TextColors.DARK_RED, "Porfavor, registrate!"))
//					.subtitle(Texts.of(TextColors.WHITE, "Haz click en el link del chat..."))
//					.stay(72000)
//					.build());
			player.sendMessage(TextFormating.DARK_AQUA+"http://bewom.es/crear");
//			algun dia lo descubrire
//			event.getUser().offer(event.getUser().getGameModeData().type().set(GameModes.SPECTATOR));
			
		} else if (user.getRegistration() == WebRegistration.BANNED) {
			user.updatePermissions();
//			o no
//			player.offer(player.getGameModeData().type().set(GameModes.SPECTATOR));
		}

	}
	
	@EventSuscribe
	public void onUserChat(PlayerChatEvent event) {
		
		BewomUser b = BewomUser.getUser(event.getPlayer());
		
		if (b.getRegistration() == WebRegistration.VALID) {
			String message = "";
			String postName = event.getMessage();
			String name = event.getUsername();
					
			switch(b.getPermissionLevel()) {
			case BewomUser.PERM_LEVEL_USER:
				message = TextFormating.GRAY + "/" + name + TextFormating.WHITE + " <" + postName;
			case BewomUser.PERM_LEVEL_VIP:
				message = TextFormating.DARK_AQUA + "/" + name + TextFormating.WHITE + " <" + postName;
			case BewomUser.PERM_LEVEL_ADMIN:
				message = TextFormating.DARK_RED + "/" + name + TextFormating.WHITE + " <" + TextFormating.BOLD + postName;
			}
			game.getServer().sendMessageToAll(message);		
		}
		
		event.setEventCanceled(true);
	}

	/**
	 * Event triggered when a player leaves the server.
	 * 
	 * @param event
	 */
	@EventSuscribe
	public void onUserQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		UUID uuid = player.getUniqueID();
		BewomUser u = BewomUser.getUser(uuid);
		if(u != null){
			
			if(!u.isLogout()){
				
				player.sendMessage("//logout");
				u.setLogout(true);
				u.remove();
				
			}
			
		}
		
	}

	/**
	 * Event triggered when a player moves. If the player is not registered in
	 * the website he cannot move.
	 * 
	 * @param event
	 */
//	evento no disponible en forge, se tiene que implementar usando un ServerUpdateEvent
//	@Subscribe
//	public void onUserMoved(PlayerMoveEvent event) {
//		BewomUser b = BewomUser.getUser(event.getUser());
//		
//		if (b.getRegistration() != WebRegistration.VALID) {
//			event.setCancelled(true);
//		}
//		
//	}
	
	@EventSuscribe
	public void onUserRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		CentroPokemon cp = CentroManager.getClosest(player.getLocation());
		if(cp == null) {
			return;
		}
		Vector3d vec = cp.getVector().add(0.5, 0, 0.5);
		player.setSpawnLocation(vec);
	}
	
	@EventSuscribe
	public void on(PlayerInteractEvent event){

		Player player = event.getPlayer();
		BewomUser user = BewomUser.getUser(player);
		
		if (!user.isAdmin() && player.getWorld().getName().equals("world")) {
			event.setEventCanceled(true);
		}
		
		P.on(game, event);
	}
	
	@EventSuscribe
	public void on(PlayerInteractEntityEvent event){
		
		Player player = event.getPlayer();
		BewomUser user = BewomUser.getUser(player);
		
		if (!user.isAdmin() && player.getWorld().getName().equals("world")) {
			event.setEventCanceled(true);
		}
		
	}
	
	@EventSuscribe
	public void on(BlockPlaceEvent event){
		
		Player player = event.getPlayer();
		BewomUser user = BewomUser.getUser(player);
		
		if (!user.isAdmin()) {
			if(player.getWorld().getName().equals("world")){
				event.setEventCanceled(true);			
			}
			DeniedBlocks.on(game, event);
		}
		
	}
	
	@EventSuscribe
	public void on(BlockBreakEvent event){
		
		Player player = event.getPlayer();
		BewomUser user = BewomUser.getUser(player);
		
		if (!user.isAdmin() && player.getWorld().getName().equals("world")) {
			event.setEventCanceled(true);
		}
		
		P.on(game, event);
		
	}
	
}
