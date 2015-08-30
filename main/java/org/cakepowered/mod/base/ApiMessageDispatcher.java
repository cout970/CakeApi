package org.cakepowered.mod.base;

import java.util.HashMap;

import org.cakepowered.api.base.MessageDispatcher;
import org.cakepowered.api.util.MessageListener;
import org.cakepowered.api.util.PluginMessage;
import org.cakepowered.mod.plugin.PluginManager;

public class ApiMessageDispatcher implements MessageDispatcher {

	public static ApiMessageDispatcher INSTANCE = new ApiMessageDispatcher();
	public HashMap<String, MessageListener> listeners = new HashMap<String, MessageListener>();

	@Override
	public void register(MessageListener listener, Object plugin) {
		String name = PluginManager.findName(plugin);
		if (name != null && !listeners.containsKey(name)) {
			listeners.put(name, listener);
			System.out.println("registrating listener for " + name);
		}
	}

	@Override
	public PluginMessage sendMessage(Object plugin, String receiver, PluginMessage message) {
		if (receiver != null && listeners.containsKey(receiver)) {
			MessageListener msg = listeners.get(receiver);
			return msg.handleMessage(receiver, message);
		}
		return null;
	}

}
