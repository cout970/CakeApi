package org.cakepowered.mod.base;

import org.apache.logging.log4j.Level;
import org.cakepowered.api.base.Log;

import net.minecraftforge.fml.common.FMLLog;

public class ApiLog implements Log {

	public String plugin;

	public ApiLog(String plugin) {
		this.plugin = plugin;
	}

	@Override
	public void error(String s) {
		FMLLog.log(plugin, Level.ERROR, s);
	}

	@Override
	public void debug(Object s) {
		FMLLog.log(plugin + "[DEBUG]", Level.INFO, String.valueOf(s));
	}

	@Override
	public void info(String s) {
		FMLLog.log(plugin, Level.INFO, s);
	}

	@Override
	public void warn(String s) {
		FMLLog.log(plugin, Level.WARN, s);
	}

	@Override
	public void raw(Object s) {
		FMLLog.log(plugin, Level.INFO, String.valueOf(s));
	}

}
