package org.cakepowered.api.util;

import org.cakepowered.api.CakeApiMod;

public class Log {

	public static void debug(Object o){
		CakeApiMod.logger.debug(o);
	}
}
