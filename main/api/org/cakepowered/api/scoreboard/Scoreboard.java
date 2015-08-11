package org.cakepowered.api.scoreboard;

import java.util.Set;

import org.cakepowered.api.base.Player;

public interface Scoreboard {
	
	Team getUserTeam(Player player);
	Team getTeam(String teamName);
	void removeTeam(Team team);
	void addTeam(Team team) throws IllegalArgumentException;
	Set<Team> getTeams();
}
