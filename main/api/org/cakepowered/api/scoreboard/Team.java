package org.cakepowered.api.scoreboard;

import java.util.Set;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.text.TextModifier;

public interface Team {
	
	String getName();
	String getDisplayName();
	TextModifier getColor();
	void setColor(TextModifier color) throws IllegalArgumentException;
	void setDisplayName(String displayName) throws IllegalArgumentException;
	Set<Player> getPlayers();
	void addPlayer(Player player);
	boolean removeUser(Player player);
	Set<Scoreboard> getScoreboards();
	
}
