package es.bewom.teleport;

import org.cakepowered.api.base.Player;

public class TPRequest {
	
	private Player player1;
	private Player player2;
	private int objective;
	
	private long time;
	
	private static final long expiration = 10000;
	
	public TPRequest() {
		time = System.currentTimeMillis();
	}
	
	public void setPlayer1(Player player) {
		player1 = player;
	}
	
	public void setPlayer2(Player player) {
		player2 = player;
	}
	
	public void setObjective(int objective) {
		this.objective = objective;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public int getObjective() {
		return objective;
	}
	
	public boolean isStillVaild() {
		
		long currentTime = System.currentTimeMillis();
		
		if(currentTime - time < expiration)
			return true;
		
		return false;
		
	}
	
}
