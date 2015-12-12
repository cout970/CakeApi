package org.cakepowered.api.base;

import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.nbt.NBTFactory;
import org.cakepowered.api.recipe.RecipeManager;
import org.cakepowered.api.world.WorldManager;

public interface Game {

	EventRegistry getEventRegistry();

	Server getServer();

	CommandDispatcher getCommandDispacher();

	WorldManager getWorldManager();

	NBTFactory getNBTFactory();

	MinecraftFinder getFinder();

	MessageDispatcher getMessageDispatcher();

	RecipeManager getRecipeManager();

	ModInteractionHandler getModInteractionHandler();
}
