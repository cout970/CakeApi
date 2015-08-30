package org.cakepowered.mod.event;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.command.CommandExecutor;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.event.CommandExecuteEvent;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.event.CommandEvent;

public class ApiCommandExecuteEvent implements CommandExecuteEvent{

	public CommandEvent event;
	
	public ApiCommandExecuteEvent(CommandEvent e){
		event = e;
	}

	@Override
	public Game getGame() {
		return ForgeInterface.getGame();
	}

	@Override
	public boolean isEventCancelable() {
		return event.isCancelable();
	}

	@Override
	public void setEventCanceled(boolean value) {
		event.setCanceled(value);
	}

	@Override
	public boolean hasEventResult() {
		return event.hasResult();
	}

	@Override
	public EventResult getEventResult() {
		return ForgeInterface.getEventResult(event.getResult());
	}

	@Override
	public boolean isEventCanceled() {
		return event.isCanceled();
	}

	@Override
	public CommandExecutor getCommandExecutor() {
		return ForgeInterface.getCommandExecutor(event.command);
	}

	@Override
	public CommandSender getCommandSender() {
		return ForgeInterface.getCommandSender(event.sender);
	}

	@Override
	public String[] getArguments() {
		return event.parameters;
	}

	@Override
	public void setArguments(String[] args) {
		event.parameters = args;
	}

	@Override
	public void setThrowable(Throwable exception) {
		event.exception = exception;
	}
}
