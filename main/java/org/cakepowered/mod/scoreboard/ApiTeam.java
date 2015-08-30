package org.cakepowered.mod.scoreboard;

import java.util.List;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.text.TextModifier;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;
import org.cakepowered.mod.util.TextUtils;

import com.google.common.collect.Lists;

import net.minecraft.scoreboard.ScorePlayerTeam;

public class ApiTeam implements Team, IImplementation<ScorePlayerTeam>{

	protected net.minecraft.scoreboard.ScorePlayerTeam team;
	
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
		this.team.func_178774_a(PluginInterface.getEnumChatFormatting(color));
	}

	@Override
	public void setName(String name) throws IllegalArgumentException {
		this.team.setTeamName(name);
	}

	@Override
	public List<Player> getPlayers() {
		List<Player> players = Lists.newArrayList();
		for(Object o : team.getMembershipCollection()){
			if(o instanceof String){
				Player p = ForgeInterface.getGame().getServer().getPlayer((String)o);
				if(p != null){
					players.add(p);
				}
			}
		}
		
		return players;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addPlayer(Player player) {
		this.team.getMembershipCollection().add(player.getUserName());
	}

	@Override
	public boolean removePlayer(Player player) {
		this.team.getMembershipCollection().remove(player.getUserName());
		return true;
	}

	@Override
	public ScorePlayerTeam getMcObject() {
		return team;
	}
}
