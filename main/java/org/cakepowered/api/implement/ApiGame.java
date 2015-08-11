package org.cakepowered.api.implement;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.CakePlugin;
import org.cakepowered.api.base.EventRegistry;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Log;
import org.cakepowered.api.base.Server;

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
}
