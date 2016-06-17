package org.cakepowered.api.interplugin;

public interface MessageListener {

	PluginMessage handleMessage(String sender, PluginMessage message);
}
