package org.cakepowered.api.scoreboard;

import java.util.HashSet;
import java.util.Set;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.text.TextModifier;

import net.minecraft.util.EnumChatFormatting;

public class ApiTeam implements Team {

	public net.minecraft.scoreboard.ScorePlayerTeam team;
	
	public ApiTeam(net.minecraft.scoreboard.ScorePlayerTeam team) {
		this.team = team;
	}
	
	@Override
	public String getName() {
		return this.team.getRegisteredName();
	}

	@Override
	public TextModifier getColor() {
		return new EnumChatFormatting.AQUA.name();
	}

	@Override
	public void setColor(TextModifier color) throws IllegalArgumentException {
		
	}

	@Override
	public void setName(String name) throws IllegalArgumentException {
		this.team.setTeamName(name);
	}

	@Override
	public Set<Player> getPlayers() {
		return new HashSet<Player>(this.team.getMembershipCollection());
	}

	@Override
	public void addPlayer(Player player) {
		this.team.getMembershipCollection().add(player);
	}

	@Override
	public boolean removePlayer(Player player) {
		this.team.getMembershipCollection().remove(player);
		return true;
	}

}
