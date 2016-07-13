package org.cakepowered.mod.scoreboard;

import com.google.common.collect.Lists;
import net.minecraft.scoreboard.ScorePlayerTeam;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.text.TextModifier;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;
import org.cakepowered.mod.util.TextUtils;

import java.util.List;

public class ApiTeam implements Team, IImplementation<ScorePlayerTeam> {

    protected net.minecraft.scoreboard.ScorePlayerTeam team;

    public ApiTeam(net.minecraft.scoreboard.ScorePlayerTeam team) {
        this.team = team;
    }

    @Override
    public String getName() {
        return this.team.getRegisteredName();
    }

    @Override
    public String getColorSuffix() {
        return team.getColorSuffix();
    }

    @Override
    public void setColorSuffix(String sufix) {
        team.setNameSuffix(sufix);
    }

    @Override
    public String getColorPrefix() {
        return team.getColorPrefix();
    }

    @Override
    public void setColorPrefix(String preffix) {
        team.setNamePrefix(preffix);
    }

    @Override
    public TextModifier getColor() {
        return TextUtils.modifiers.get(team.getChatFormat());
    }

    @Override
    public void setColor(TextModifier color) throws IllegalArgumentException {
        this.team.setChatFormat(PluginInterface.getEnumChatFormatting(color));
    }

    @Override
    public void setName(String name) throws IllegalArgumentException {
        this.team.setTeamName(name);
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> players = Lists.newArrayList();
        team.getMembershipCollection().stream().filter(o -> o != null).forEach(o -> {
            Player p = ForgeInterface.getGame().getServer().getPlayer(o);
            if (p != null) {
                players.add(p);
            }
        });

        return players;

    }

    @Override
    public ScorePlayerTeam getMcObject() {
        return team;
    }
}
