package org.cakepowered.api.implement;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.EventRegistry;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.commands.ApiCommandDispatcher;
import org.cakepowered.api.world.ApiWorldManager;
import org.cakepowered.api.world.WorldManager;

public class ApiGame implements Game{

	public ApiGame(){}

	@Override
	public EventRegistry getEventRegistry() {
		return ApiEventRegistry.INSTANCE;
	}

	@Override
	public Server getServer() {
		return CakeApiMod.server;
	}

	@Override
	public CommandDispatcher getCommandDispacher() {
		return ApiCommandDispatcher.INSTANCE;
	}

	@Override
	public WorldManager getWorldManager() {
		return ApiWorldManager.INSTANCE;
	}
}
