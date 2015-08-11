package org.cakepowered.api.plugin;

import java.util.List;

import org.cakepowered.api.implement.ApiEventRegistry;

import com.google.common.collect.Lists;

public class PluginManager {
	
	public static List<PluginContainer> loadedPlugins = Lists.newArrayList();

	public static void registerPlugin(PluginContainer container, Object instance) {
		loadedPlugins.add(container);
		ApiEventRegistry.INSTANCE.registerEvent(instance);
	}

}
