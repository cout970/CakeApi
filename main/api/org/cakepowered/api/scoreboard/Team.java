package org.cakepowered.api.scoreboard;

import java.util.Set;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.text.TextModifier;

public interface Team {
	
	String getName();
	TextModifier getColor();
	void setColor(TextModifier color) throws IllegalArgumentException;
	void setName(String displayName) throws IllegalArgumentException;
	Set<Player> getPlayers();
	void addPlayer(Player player);
	boolean removePlayer(Player player);
	
}
