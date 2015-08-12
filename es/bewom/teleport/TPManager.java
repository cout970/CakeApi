package es.bewom.teleport;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.ServerUpdateEvent;

import es.bewom.BewomByte;

public class TPManager{
	
	private static final int MINUTES = 60;
	private static final int SECONDS = 20;

	private static ArrayList<TPRequest> requests;
	
	public static int ticks;
	
	public static void init(BewomByte plugin) {
		
		requests = new ArrayList<>();
		BewomByte.game.getEventRegistry().registerEventListener(new TPManager());
	}
	
	@EventSuscribe
	public void onTick(ServerUpdateEvent event){
		if(ticks >= 5*MINUTES*SECONDS){
			periodicCleanup();
			ticks = 0;
		}else{
			ticks++;
		}
	}
	
	public static void newRequest(Player player1, Player player2, int objective) {
		
		if(requests.size() != 0) {
		
			for(int i = 0; i < requests.size(); i++) {
				
				TPRequest request = requests.get(i);
				
				if(request.getPlayer1().equals(player1))
					requests.remove(request);
				if(request.getPlayer2().equals(player2))
					requests.remove(request);
			}
		
		}
		
		TPRequest request = new TPRequest();
		request.setPlayer1(player1);
		request.setPlayer2(player2);
		request.setObjective(objective);
		requests.add(request);
		
	}
	
	public static boolean validateRequest(TPRequest request) {
		
		if(request.isStillVaild()) {
			return true;
		} else {
			requests.remove(request);
		}
		
		return false;
		
	}
	
	public static TPRequest getRequest(Player player2) {
		
		if(requests.size() == 0) return null;
		
		for(int i = 0; i < requests.size(); i++) {
				
			TPRequest request = requests.get(i);
			
			if(request.getPlayer2().equals(player2)){
				return request;
			}
		}
		
		return null;
		
	}
	
	public static void deleteRequest(TPRequest request) {
		requests.remove(request);
	}
	
	public static void periodicCleanup() {
		for(int i = 0; i < requests.size(); i++) {
			TPRequest request = requests.get(i);
			if(!request.isStillVaild()) {
				requests.remove(request);
			}
		}
	}	
}
