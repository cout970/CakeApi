package es.bewom.p;

import java.util.ArrayList;
import java.util.List;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.BlockBreakEvent;
import org.cakepowered.api.event.PlayerInteractEvent;
import org.cakepowered.api.world.World;
import org.cakepowered.api.world.block.Block;
import org.cakepowered.api.world.block.Blocks;

public class P {
	
	public static boolean first = false;
	public static boolean second = false;
	public static int lastDoor = 0;
	
	public static List<Door> doors = new ArrayList<Door>();
	
	public static void on(Game game, PlayerInteractEvent event){
		
		Player p = (Player) event.getPlayer();
		Block b = (Block) event.getPosition();
		double x = event.getPosition().getX();
		double y = event.getPosition().getY();
		double z = event.getPosition().getZ();
		World world = p.getWorld();
		
		if(b != null){
			
			if(equalsAnyWoodenDoorTypes(b)){
				
				if(doors != null){
					for (Door d : doors) {
						if(d.setDoorPos(0).isSelected(x, y, z, world)){
							event.setEventCanceled(true);
							p.moveToWorld(d.setDoorPos(1).getLocation());
						}
						if(d.setDoorPos(1).isSelected(x, y, z, world)){
							event.setEventCanceled(true);
							p.moveToWorld(d.setDoorPos(0).getLocation());
						}
					}
				}
				
				if(second){
					event.setEventCanceled(true);
					Block doorW = game.getServer().getWorld(world.getName()).getBlock((int) x, (int) y - 1, (int) z);
					if(equalsAnyWoodenDoorTypes(doorW)){
						y -= 1;
					}
					doors.get(lastDoor).setDoorPos(0).setLocation(x, y, z).setWorld(world);
					second = false;
					p.sendMessage("Puertas seleccionadas.");
				}
				if(first){
					event.setEventCanceled(true);
					Block doorW = game.getServer().getWorld(world.getName()).getBlock((int) x, (int) y - 1, (int) z);
					if(equalsAnyWoodenDoorTypes(doorW)){
						y -= 1;
					}
					doors.get(lastDoor).setDoorPos(1).setLocation(x, y, z).setWorld(world);
					first = false;
					second = true;
					p.sendMessage("Selecciona la segunda puerta.");
				}
				
			}
			
		}
		
	}
	
	public static boolean equalsAnyWoodenDoorTypes(Block b){
		if(b == Blocks.WOODEN_DOOR
				|| b == Blocks.ACACIA_DOOR
				|| b == Blocks.BIRCH_DOOR
				|| b == Blocks.DARK_OAK_DOOR
				|| b == Blocks.JUNGLE_DOOR
				|| b == Blocks.SPRUCE_DOOR){
			return true;
		}
		return false;
	}
	
	public static void on(Game game, BlockBreakEvent event){
		
		Player p = (Player) event.getPlayer();
		double x = event.getPosition().getX();
		double y = event.getPosition().getY();
		double z = event.getPosition().getZ();
		
		Block b = game.getServer().getWorld(p.getWorld().getName()).getBlock((int) x, (int) y + 1, (int) z);
		
		if(b != null){
			
			if(b == Blocks.WOODEN_DOOR
					|| b == Blocks.ACACIA_DOOR
					|| b == Blocks.BIRCH_DOOR
					|| b == Blocks.DARK_OAK_DOOR
					|| b == Blocks.JUNGLE_DOOR
					|| b == Blocks.SPRUCE_DOOR){
				
				event.setEventCanceled(true);
				
			}
			
		}
		
	}
	
}
