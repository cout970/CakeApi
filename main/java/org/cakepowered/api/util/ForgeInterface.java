package org.cakepowered.api.util;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.commands.ApiCommandSender;
import org.cakepowered.api.event.Event.EventResult;
import org.cakepowered.api.implement.ApiPlayer;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
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

	public static Vector3i getVector3(net.minecraft.util.BlockPos pos) {
		if(pos == null)return null;
		return new Vector3i(pos.getX(), pos.getY(), pos.getZ());
	}

	public static Direction getDirection(EnumFacing face) {
		if(face == null)return null;
		return Direction.values()[face.getIndex()];
	}

	public static CommandSender getCommandSender(ICommandSender sender) {
		return new ApiCommandSender(sender);
	}

	public static Vec3 getVec3(Vector3d v) {
		return new Vec3(v.getX(), v.getY(), v.getZ());
	}

	public static BlockPos getBlockPos(Vector3d v) {
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static Vector3d getVector3(Vec3 v) {
		return new Vector3d(v.xCoord, v.yCoord, v.zCoord);
	}
}
