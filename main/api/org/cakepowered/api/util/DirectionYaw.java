package org.cakepowered.api.util;

public class DirectionYaw {
	
	public static final int NORTH  = 0;
	public static final int WEST  = 1;
	public static final int SOUTH  = 2;
	public static final int EAST  = 3;
	
	public static final float EAST_f = 270f;
	public static final float NORTH_f = 180f;
	public static final float WEST_f = 90f;
	public static final float SOUTH_f = 0f;
	
	public static float getYawFromDirection(int dir){
		
		switch (dir) {
		case NORTH:
			return NORTH_f;

		case WEST:
			return WEST_f;
			
		case SOUTH:
			return SOUTH_f;
			
		case EAST:
			return EAST_f;
			
		default:
			return NORTH_f;
		}
		
	}
	
	public static float getOpossiteYawFromDirection(int dir){
		
		switch (dir) {
		case NORTH:
			return SOUTH_f;

		case WEST:
			return EAST_f;
			
		case SOUTH:
			return NORTH_f;
			
		case EAST:
			return WEST_f;
			
		default:
			return 180f;
		}
		
	}

}
