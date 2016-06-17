package org.cakepowered.api.scoreboard;

import java.util.List;

import org.cakepowered.api.entity.Player;

public interface Scoreboard {

	Team getPlayerTeam(Player player);

	Team getTeam(String teamName);

	void removeTeam(Team team);

	Team addTeam(String team) throws IllegalArgumentException;

	List<Team> getTeams();

	void addPlayerToTeam(Player p, Team t);

	void removePlayerFromTeam(Player p, Team t);

	void removePlayerFromTeams(Player p);
}
