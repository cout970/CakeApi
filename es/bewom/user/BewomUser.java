package es.bewom.user;

import java.util.HashMap;
import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.scoreboard.Team;

import es.bewom.BewomByte;
import es.bewom.util.Ran;
import es.bewom.util.mysql.MySQL;

/**
 * 
 * @author McMacker4
 *
 */
public class BewomUser {
	
	public static final String PERM_ADMIN = "admin";
	public static final String PERM_VIP = "vip";
	public static final String PERM_USER = "miembro";
	
	public static final int PERM_LEVEL_ADMIN = 3;
	public static final int PERM_LEVEL_VIP = 2;
	public static final int PERM_LEVEL_USER = 1;
	
	private static BewomByte plugin;
	
	public MySQL m = new MySQL();
	
	static HashMap<UUID, BewomUser> onlineUsers = new HashMap<>();
	
	private boolean logout = false;
	
	private Player player;
	private UUID uuid;
	
	private boolean isAfk;
	private int lastMove;
	
	private int permissionLevel;
	
	private String registerLink = "http://bewomdev.darkaqua.net/crear/";
	private int registration = -1;
	
	/**
	 * Constructor. Creates a {@link BewomUser} from a player.
	 * @param player to create the {@link BewomUser} from.
	 */
	public BewomUser(Player player) {
		
		this.player = player;
		this.uuid = player.getUniqueID();
		lastMove = plugin.getGame().getServer().getRunningTimeTicks();
		registration = checkWebsiteRegistration(); //WebRegistration.VALID
		permissionLevel = checkPermissionLevel(); //PERM_LEVEL_USER
		
		String hash = (String) m.executeQuery("SELECT * FROM `crear` WHERE `uuid`='" + player.getUniqueID() + "'", "hash");
		if(hash != null){
			registerLink += hash;
		}
		
	}
	
	public void updatePermissions(){
		
		String perm = (String) m.executeQuery("SELECT * FROM `users` WHERE `uuid`='" + player.getUniqueID() + "'", "type");
		
		if(perm != null){
		
			if(perm.equals(BewomUser.PERM_ADMIN)){
				setPermissionLevel(3);		
			} else if (perm.equals(BewomUser.PERM_VIP)){
				setPermissionLevel(2);
			} else if(perm.equals(BewomUser.PERM_USER)){
				setPermissionLevel(1);
			}
			//TODO, McMacker4 no se que hace esto
			//player.offer(Keys.DISPLAY_NAME, Texts.of("ALMENDRUCO"));
			
			switch(permissionLevel) {
			case PERM_LEVEL_ADMIN:
				Team teamAdmin = player.getWorld().getScoreboard().getTeam(PERM_ADMIN);
				if(teamAdmin == null) {
					System.err.println("El jugador " + player.getUserName() + " no ha sido añadido a ningun equipo.");
					break;
				}
				
				if(!teamAdmin.getPlayers().contains(player)){
					for(Team team : player.getWorld().getScoreboard().getTeams()) {
						team.removePlayer(player);
					}
					teamAdmin.addPlayer(player);
				}
				break;
			case PERM_LEVEL_VIP:
				Team teamVip = player.getWorld().getScoreboard().getTeam(PERM_VIP);
				if(teamVip == null) {
					System.err.println("El jugador " + player.getUserName() + " no ha sido añadido a ningun equipo.");
					break;
				}
				
				if(!teamVip.getPlayers().contains(player)){
					for(Team team : player.getWorld().getScoreboard().getTeams()) {
						team.removePlayer(player);
					}
					teamVip.addPlayer(player);
				}
				break;
			case PERM_LEVEL_USER:
				Team teamUser = player.getWorld().getScoreboard().getTeam(PERM_USER);
				if(teamUser == null) {
					System.err.println("El jugador " + player.getUserName() + " no ha sido aÃ±adido a ningun equipo.");
					break;
				}
				
				if(!teamUser.getPlayers().contains(player)){
					for(Team team : player.getWorld().getScoreboard().getTeams()) {
						team.removePlayer(player);
					}
					teamUser.addPlayer(player);
				}
				break;
			}
			
		} else {
			
			setPermissionLevel(1);
			Team teamUser = player.getWorld().getScoreboard().getTeam(PERM_USER);
			
			if(!teamUser.getPlayers().contains(player)){
				for(Team team : player.getWorld().getScoreboard().getTeams()) {
					team.removePlayer(player);
				}
				teamUser.addPlayer(player);
			}
			
		}
		
	}

	/**
	 * Returns the {@link Player} attached to this {@link BewomUser}.
	 * @return {@link Player}
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Returns the name of the {@link Player} attached to this {@link BewomUser}.
	 * @return {@link String}
	 */
	public UUID getUUID() {
		return uuid;
	}
	
	/**
	 * Returns whether this {@link BewomUser} is Afk or not.
	 * @return boolean
	 */
	public boolean isAfk() {
		return isAfk;
	}
	
	/**
	 * Set the last time the player moved.
	 * @param time in ticks.
	 */
	public void setLastMove(int time) {
		this.lastMove = time;
	}
	
	/**
	 * Get the last time the player moved.
	 * @return Last time player moved.
	 */
	public int getLastMove() {
		return lastMove;
	}
	
	/**
	 * Returns the {@link WebRegistration} value of the player.
	 * @return Registration value.
	 */
	public int getRegistration() {
		return registration;
	}
	
	public void createHashFirstTime(){
		Ran r = new Ran();
		String h = r.next(32);
		
		registerLink += h;
		
		m.executeQuery("INSERT INTO `crear`(`uuid`, `user`, `hash`) VALUES ('" + player.getUniqueID() + "', '" + player.getUserName() + "', '" + h + "')", null);
	}
	
	/**
	 * Runs when player joins.
	 * Grabs {@link WebRegistration} value from web server.
	 * @return 
	 */
	private int checkWebsiteRegistration() {
		//TODO: Check Registration in the database.
				
		String perm = (String) m.executeQuery("SELECT * FROM `crear` WHERE `uuid`='" + player.getUniqueID() + "'", "hash");
		if(perm != null){
			boolean perm2 = (boolean) m.executeQuery("SELECT * FROM `users_info` WHERE `uuid`='" + player.getUniqueID() + "'", "active");
			if(perm2){
				return WebRegistration.VALID;
			} else {
				return WebRegistration.NOT_VALID;
			}
		}
		
		return WebRegistration.NOT_REGISTERED;
	}
	
	private int checkPermissionLevel() {
		updatePermissions();
		return this.permissionLevel;
	}
	
	public boolean isAdmin(){
		if(this.permissionLevel == PERM_LEVEL_ADMIN){
			return true;
		}
		return false;
	}
	
	public boolean isVip(){
		if(this.permissionLevel == PERM_LEVEL_VIP){
			return true;
		}
		return false;
	}
	
	public boolean isUser(){
		if(this.permissionLevel == PERM_LEVEL_USER){
			return true;
		}
		return false;
	}
	
	public String getPermissionType(){
		
		switch (permissionLevel) {
		case PERM_LEVEL_ADMIN:
			return PERM_ADMIN;
		case PERM_LEVEL_VIP:
			return PERM_VIP;
		case PERM_LEVEL_USER:
			return PERM_USER;
		}
		
		return null;
		
	}
	
	public int getPermissionLevel() {
		return permissionLevel;
	}
	
	public String setPermissionLevel(int level) {
		if(level < PERM_LEVEL_USER || level > PERM_LEVEL_ADMIN) {
			return "Este grupo no existe.";
		}
		this.permissionLevel = level;
		//TODO: Save to database.	
		m.executeQuery("UPDATE `users` SET `type`='" + getPermissionType() + "' WHERE `uuid`='" + player.getUniqueID() + "'", null);	
		return null;
	}
	
	/**
	 * Gets a {@link BewomUser} that is online.
	 * @param name of the player.
	 * @return The {@link BewomUser} specified.
	 */
	public static BewomUser getUser(UUID uuid) {
		return onlineUsers.get(uuid);
	}
	
	/**
	 * Gets a {@link BewomUser} that is online.
	 * @param player
	 * @return The {@link BewomUser} or null if not found.
	 */
	public static BewomUser getUser(Player player) {
		return getUser(player.getUniqueID());
	}
	
	/**
	 * Adds the {@link BewomUser} to the onlineUsers {@link HashMap}
	 * @param user
	 */
	public static void addUser(BewomUser user) {
		onlineUsers.put(user.getUUID(), user);
	}
	
	/**
	 * Removes user from the online users list.
	 */
	public void remove() {
		onlineUsers.remove(this.uuid);
	}
	public static void remove(BewomUser user) {
		onlineUsers.remove(user.getUUID());
	}
	
	public static void remove(UUID uuid) {
		onlineUsers.remove(uuid);
	}
	
	/**
	 * DO NOT USE.
	 * This function sets the current plugin.
	 * This should only be used from BewomByte.class and just once when server starts.
	 * @param game
	 */
	public static void setGame(BewomByte plugin) {
		BewomUser.plugin = plugin;
	}

	public String getRegisterLink() {
		return registerLink;
	}

	public void setRegisterLink(String registerLink) {
		this.registerLink = registerLink;
	}

	public boolean isLogout() {
		return this.logout;
	}

	public void setLogout(boolean logout) {
		this.logout = logout;
	}
	
}
