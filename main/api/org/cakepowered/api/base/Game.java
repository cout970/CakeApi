package org.cakepowered.api.base;

import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.nbt.NBTFactory;
import org.cakepowered.api.recipe.RecipeManager;
import org.cakepowered.api.world.WorldManager;

public interface Game {

	public EventRegistry getEventRegistry();

	public Server getServer();

	public CommandDispatcher getCommandDispacher();

	public WorldManager getWorldManager();

	public NBTFactory getNBTFactory();

	public MinecraftFinder getFinder();

	public MessageDispatcher getMessageDispatcher();
	
	public RecipeManager getRecipeManager();
}
