package org.cakepowered.mod.base;

import org.cakepowered.api.base.EventRegistry;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.MessageDispatcher;
import org.cakepowered.api.base.MinecraftFinder;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.nbt.NBTFactory;
import org.cakepowered.api.recipe.RecipeManager;
import org.cakepowered.api.world.WorldManager;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.command.ApiCommandDispatcher;
import org.cakepowered.mod.nbt.ApiNBTFactory;
import org.cakepowered.mod.recipe.ApiRecipeManager;
import org.cakepowered.mod.world.ApiWorldManager;

public class ApiGame implements Game {

	public ApiGame() {
	}

	@Override
	public EventRegistry getEventRegistry() {
		return ApiEventRegistry.INSTANCE;
	}

	@Override
	public Server getServer() {
		return CakeApiCore.server;
	}

	@Override
	public CommandDispatcher getCommandDispacher() {
		return ApiCommandDispatcher.INSTANCE;
	}

	@Override
	public WorldManager getWorldManager() {
		return ApiWorldManager.INSTANCE;
	}

	@Override
	public NBTFactory getNBTFactory() {
		return ApiNBTFactory.INSTANCE;
	}

	@Override
	public MinecraftFinder getFinder() {
		return ApiMinecraftFinder.INSTANCE;
	}

	@Override
	public MessageDispatcher getMessageDispatcher() {
		return ApiMessageDispatcher.INSTANCE;
	}

	@Override
	public RecipeManager getRecipeManager() {
		return ApiRecipeManager.INSTANCE;
	}
}
