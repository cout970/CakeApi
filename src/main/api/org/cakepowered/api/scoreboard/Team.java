package org.cakepowered.api.scoreboard;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.util.text.TextModifier;

import java.util.List;

public interface Team {

	String getName();

	TextModifier getColor();

	void setColor(TextModifier color) throws IllegalArgumentException;

	void setName(String displayName) throws IllegalArgumentException;

	List<Player> getPlayers();
}
