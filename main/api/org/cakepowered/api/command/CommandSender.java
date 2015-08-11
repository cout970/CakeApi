package org.cakepowered.api.command;

public interface CommandSender {

	public String getName();
	
	public void sendMessage(String... messages);
	
	public void sendMessage(Iterable<String> messages);
	
	public String getIdentifier();

	public boolean hasPermission(String permission);
}
