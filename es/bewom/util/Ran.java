package es.bewom.util;

import java.util.Random;

public final class Ran {
	private static final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random rnd = new Random();

	public String next(int lenght) {
		
		StringBuilder sb = new StringBuilder(lenght);
		   for( int i = 0; i < lenght; i++ ) 
		      sb.append(AB.charAt(rnd.nextInt(AB.length())));
		   return sb.toString();
		
	}
}