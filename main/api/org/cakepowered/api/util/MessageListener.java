package org.cakepowered.api.util;

public interface MessageListener {

	public PluginMessage handleMessage(String sender, PluginMessage message);
}
