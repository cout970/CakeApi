package org.cakepowered.api.scoreboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.TextUtils;
import org.cakepowered.api.util.text.TextModifier;

import com.google.common.collect.Sets;

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
	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		for(Object o : team.getMembershipCollection()){
			if(o instanceof String){
				Player p = ForgeInterface.getGame().getServer().getPlayer(o.toString());
				if(p != null){
					players.add(p);
				}
			}
		}
		return players;
	}

	@Override
	public void addPlayer(Player player) {
		this.team.getMembershipCollection().add(player.getUserName());
	}

	@Override
	public boolean removePlayer(Player player) {
		this.team.getMembershipCollection().remove(player.getUserName());
		return true;
	}

}
