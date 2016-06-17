package org.cakepowered.mod.plugin;

import java.util.List;

import org.cakepowered.mod.core.ApiEventRegistry;

import com.google.common.collect.Lists;

public class PluginManager {

	public static List<PluginContainer> loadedPlugins = Lists.newArrayList();

	public static void registerPlugin(PluginContainer container, Object instance) {
		loadedPlugins.add(container);
		ApiEventRegistry.INSTANCE.registerEventListener(instance);
	}

	public static String findName(Object plugin) {
		if (plugin == null)
			return null;
		for (PluginContainer o : loadedPlugins) {
			if (plugin.equals(o.pluginInstance)) {
				return o.getModId();
			}
		}
		return null;
	}
}
