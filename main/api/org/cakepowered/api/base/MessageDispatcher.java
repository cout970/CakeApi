package org.cakepowered.api.base;

import org.cakepowered.api.util.MessageListener;
import org.cakepowered.api.util.PluginMessage;

public interface MessageDispatcher {

	public void register(MessageListener listener, Object plugin);
	
	public PluginMessage sendMessage(Object plugin, String receiver, PluginMessage message);
}
