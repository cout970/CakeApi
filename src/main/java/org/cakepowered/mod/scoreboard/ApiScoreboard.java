package org.cakepowered.mod.scoreboard;

import net.minecraft.scoreboard.ScorePlayerTeam;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.mod.util.IImplementation;

import java.util.List;
import java.util.stream.Collectors;

public class ApiScoreboard implements Scoreboard, IImplementation<net.minecraft.scoreboard.Scoreboard> {

	protected net.minecraft.scoreboard.ServerScoreboard scoreboard;

	public ApiScoreboard(net.minecraft.scoreboard.ServerScoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}

	@Override
	public Team getPlayerTeam(Player player) {
		return new ApiTeam(this.scoreboard.getTeam(player.getUserName()));
	}

	@Override
	public Team getTeam(String teamName) {
		ScorePlayerTeam team = this.scoreboard.getTeam(teamName);
		return new ApiTeam(this.scoreboard.getTeam(teamName));
	}

	@Override
	public void removeTeam(Team team) {
		if (team == null)
			return;
		ScorePlayerTeam scoreTeam = this.scoreboard.getTeam(team.getName());
		this.scoreboard.removeTeam(scoreTeam);
	}

	@Override
	public Team addTeam(String team) throws IllegalArgumentException {
		ScorePlayerTeam s = this.scoreboard.createTeam(team);
		this.scoreboard.broadcastTeamCreated(s);
		return new ApiTeam(s);
	}

	@Override
	public List<Team> getTeams() {
		return this.scoreboard.getTeamNames().stream().map(s -> new ApiTeam(this.scoreboard.getTeam(s))).collect(Collectors.toList());
	}

	@Override
	public net.minecraft.scoreboard.ServerScoreboard getMcObject() {
		return scoreboard;
	}
	
	@Override
	public void addPlayerToTeam(Player p, Team t){
		this.scoreboard.addPlayerToTeam(p.getUserName(), t.getName());
	}
	
	@Override
	public void removePlayerFromTeam(Player p, Team t){
		this.scoreboard.removePlayerFromTeam(p.getName(), this.scoreboard.getTeam(t.getName()));
	}
	
	@Override
	public void removePlayerFromTeams(Player p){
		this.scoreboard.removePlayerFromTeams(p.getName());
	}
	

}
