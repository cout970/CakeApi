package org.cakepowered.api.interplugin;

public interface MessageDispatcher {

	void register(MessageListener listener, Object plugin);

	PluginMessage sendMessage(Object plugin, String receiver, PluginMessage message);
}
