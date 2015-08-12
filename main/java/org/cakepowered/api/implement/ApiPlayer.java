package org.cakepowered.api.implement;

import java.util.UUID;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ApiPlayer extends ApiEntity implements Player{
	
	public EntityPlayer player;

	public ApiPlayer(EntityPlayer player){
		super(player);
		this.player = player;
	}

	@Override
	public String getUserName() {
		return player.getName();
	}

	@Override
	public void sendMessage(String s) {
		player.addChatMessage(new ChatComponentText(s));
	}
}
