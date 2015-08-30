package org.cakepowered.api.scoreboard;

import java.util.List;

import org.cakepowered.api.base.Player;

public interface Scoreboard {

	Team getPlayerTeam(Player player);

	Team getTeam(String teamName);

	void removeTeam(Team team);

	Team addTeam(String team) throws IllegalArgumentException;

	List<Team> getTeams();
}
