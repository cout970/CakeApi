package org.cakepowered.mod.scoreboard;

import java.util.ArrayList;
import java.util.List;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.mod.util.IImplementation;

import net.minecraft.scoreboard.ScorePlayerTeam;

public class ApiScoreboard implements Scoreboard, IImplementation<net.minecraft.scoreboard.Scoreboard>{
	
	protected net.minecraft.scoreboard.Scoreboard scoreboard;
	
	public ApiScoreboard(net.minecraft.scoreboard.Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	
	@Override
	public Team getPlayerTeam(Player player) {
		if(this.scoreboard.getTeam(player.getUserName()) == null)return null;
		return new ApiTeam(this.scoreboard.getTeam(player.getUserName()));
	}

	@Override
	public Team getTeam(String teamName) {
		ScorePlayerTeam team = this.scoreboard.getTeam(teamName);
		if(team == null)return null;
		return new ApiTeam(this.scoreboard.getTeam(teamName));
	}

	@Override
	public void removeTeam(Team team) {
		if(team == null)return;
		ScorePlayerTeam scoreTeam = this.scoreboard.getTeam(team.getName());
		if(scoreTeam == null)return;
		this.scoreboard.removeTeam(scoreTeam);
		scoreboard.sendTeamUpdate(scoreTeam);
	}

	@Override
	public Team addTeam(String team) throws IllegalArgumentException {
		ScorePlayerTeam s = this.scoreboard.createTeam(team);
		this.scoreboard.broadcastTeamCreated(s);
		return new ApiTeam(s);
	}

	@Override
	public List<Team> getTeams() {
		List<Team> t = new ArrayList<Team>();
		for(Object s : this.scoreboard.getTeamNames()){
			t.add(new ApiTeam(this.scoreboard.getTeam(s.toString())));
		}
		return t;
	}

	@Override
	public net.minecraft.scoreboard.Scoreboard getMcObject() {
		return scoreboard;
	}

}
