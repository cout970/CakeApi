package org.cakepowered.api.command;

import java.util.ArrayList;
import java.util.List;

import org.cakepowered.api.world.World;

public class CommandUtil {

	public static boolean checkArguments(String[] args, ArgumentType[] pattern, World w){
		if(args == null)return false;
		if(args.length != pattern.length)return false;
		for(int i = 0; i < pattern.length; i++){
			if(pattern[i].matches(args[i], w)){
				return false;
			}
		}
		return true;
	}
	
	public static List<String> getStringsMachingLastWord(String[] args, String... options){
		List<String> list = new ArrayList<String>();
		String arg = args[args.length-1];
		for(String str : options){
			if (startStringWith(arg, str)){
				list.add(str);
			}
		}
		return list;
	}
	
	public static boolean startStringWith(String arg, String str) {
		return str.regionMatches(true, 0, arg, 0, arg.length());
	}

	public enum ArgumentType{
		STRING, INTEGER, PLAYER, BOOLEAN, FLOAT;

		public boolean matches(String s, World w) {
			switch(this){
			case STRING:
				return s != null;
			case INTEGER:
				try{
					Integer.parseInt(s);
					return true;
				}catch(NumberFormatException e){
					return false;
				}
			case PLAYER:
				return w.getServer().getPlayer(s) != null;
			case BOOLEAN:
				return "false".equalsIgnoreCase(s) || "true".equalsIgnoreCase(s) || "0".equalsIgnoreCase(s) || "1".equalsIgnoreCase(s);
			case FLOAT:
				try{
					Float.parseFloat(s);
					return true;
				}catch(NumberFormatException e){
					return false;
				}
			}
			return false;
		}
	}
}
