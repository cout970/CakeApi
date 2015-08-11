package org.cakepowered.api.scoreboard;

import java.util.HashSet;
import java.util.Set;

import org.cakepowered.api.base.Player;

import net.minecraft.scoreboard.ScorePlayerTeam;

public class ApiScoreboard implements Scoreboard {
	
	public net.minecraft.scoreboard.Scoreboard scoreboard;
	
	public ApiScoreboard(net.minecraft.scoreboard.Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	
	@Override
	public Team getPlayerTeam(Player player) {
		return new ApiTeam(this.scoreboard.getPlayersTeam(player.getUserName()));
	}

	@Override
	public Team getTeam(String teamName) {
		return new ApiTeam(this.scoreboard.getPlayersTeam(teamName));
	}

	@Override
	public void removeTeam(Team team) {
		this.scoreboard.removeTeam(new ScorePlayerTeam(scoreboard, team.getName()));
	}

	@Override
	public void addTeam(Team team) throws IllegalArgumentException {
		this.scoreboard.createTeam(team.getName());
	}

	@Override
	public Set<Team> getTeams() {
		return new HashSet<Team>(this.scoreboard.getTeams());
	}

}
