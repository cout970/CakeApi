package org.cakepowered.api.scoreboard;

import java.util.HashSet;
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
		return TextUtils.modifiers.get(this.team.func_178775_l());
	}

	@Override
	public void setColor(TextModifier color) throws IllegalArgumentException {
		this.team.func_178774_a(ForgeInterface.getEnumChatFormatting(color));
	}

	@Override
	public void setName(String name) throws IllegalArgumentException {
		this.team.setTeamName(name);
	}

	@Override
	public Set<Player> getPlayers() {
		HashSet<Player> players = Sets.newHashSet();
		for(Object o : team.getMembershipCollection()){
			if(o instanceof String){
				UUID id = UUID.fromString((String) o);
				Player p = ForgeInterface.getGame().getServer().getPlayer(id);
				if(p != null)
					players.add(p);
			}
		}
		return players;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addPlayer(Player player) {
		this.team.getMembershipCollection().add(player.getUniqueID().toString());
	}

	@Override
	public boolean removePlayer(Player player) {
		this.team.getMembershipCollection().remove(player.getUniqueID().toString());
		return true;
	}

}
