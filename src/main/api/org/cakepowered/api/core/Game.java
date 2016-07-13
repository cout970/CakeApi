package org.cakepowered.api.core;

import org.cakepowered.api.command.CommandDispatcher;
import org.cakepowered.api.interplugin.MessageDispatcher;
import org.cakepowered.api.nbt.NBTFactory;
import org.cakepowered.api.recipe.RecipeManager;
import org.cakepowered.api.world.WorldManager;

public interface Game {

	EventRegistry getEventRegistry();

	Server getServer();

	CommandDispatcher getCommandDispatcher();

	WorldManager getWorldManager();

	NBTFactory getNBTFactory();

	MinecraftFinder getFinder();

	MessageDispatcher getMessageDispatcher();

	RecipeManager getRecipeManager();

	ModInteractionHandler getModInteractionHandler();
}
