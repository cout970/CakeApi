package org.cakepowered.api.scoreboard;

import java.util.HashSet;
import java.util.Set;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.TextUtils;
import org.cakepowered.api.util.text.TextModifier;

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
		return TextUtils.modifiers.get(this.team.getColorPrefix());
	}

	@Override
	public void setColor(TextModifier color) throws IllegalArgumentException {
		this.team.setNamePrefix(color.name.toLowerCase());
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
		this.team.getMembershipCollection().add(player.getUniqueID());
	}

	@Override
	public boolean removePlayer(Player player) {
		this.team.getMembershipCollection().remove(player.getUniqueID());
		return true;
	}

}
