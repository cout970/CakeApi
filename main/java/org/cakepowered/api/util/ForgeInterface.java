package org.cakepowered.api.util;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.Event.EventResult;
import org.cakepowered.api.implement.ApiPlayer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ForgeInterface {
	

	public static Player getPlayer(EntityPlayer ep){
		return new ApiPlayer(ep);
	}

	public static EventResult getEventResult(Event.Result result) {
		if(result == null)return null;
		return EventResult.values()[result.ordinal()];
	}

	public static Game getGame() {
		return CakeApiMod.game;
	}

	public static Vector3i getBlockPos(net.minecraft.util.BlockPos pos) {
		if(pos == null)return null;
		return new Vector3i(pos.getX(), pos.getY(), pos.getZ());
	}

	public static Direction getDirection(EnumFacing face) {
		if(face == null)return null;
		return Direction.values()[face.getIndex()];
	}
}
