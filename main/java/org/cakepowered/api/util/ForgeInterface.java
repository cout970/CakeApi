package org.cakepowered.api.util;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.commands.ApiCommandSender;
import org.cakepowered.api.event.Event.EventResult;
import org.cakepowered.api.implement.ApiBlock;
import org.cakepowered.api.implement.ApiEntity;
import org.cakepowered.api.implement.ApiPlayer;
import org.cakepowered.api.implement.ApiTileEntity;
import org.cakepowered.api.implement.ApiWorld;
import org.cakepowered.api.util.text.TextModifier;
import org.cakepowered.api.world.World;
import org.cakepowered.api.world.block.Block;
import org.cakepowered.api.world.tileentity.TileEntity;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ForgeInterface {
	

	public static Player getPlayer(EntityPlayer ep){
		if(ep == null)return null;
		return new ApiPlayer(ep);
	}

	public static EventResult getEventResult(Event.Result result) {
		if(result == null)return null;
		return EventResult.values()[result.ordinal()];
	}

	public static Game getGame() {
		return CakeApiMod.game;
	}

	public static Vector3i getVector3i(net.minecraft.util.BlockPos pos) {
		if(pos == null)return null;
		return new Vector3i(pos.getX(), pos.getY(), pos.getZ());
	}

	public static Direction getDirection(EnumFacing face) {
		if(face == null)return null;
		return Direction.values()[face.getIndex()];
	}

	public static CommandSender getCommandSender(ICommandSender sender) {
		if(sender == null)return null;
		return new ApiCommandSender(sender);
	}

	public static Vec3 getVec3(Vector3d v) {
		if(v == null)return null;
		return new Vec3(v.getX(), v.getY(), v.getZ());
	}

	public static BlockPos getBlockPos(Vector3d v) {
		if(v == null)return null;
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static Vector3d getVector3(Vec3 v) {
		return new Vector3d(v.xCoord, v.yCoord, v.zCoord);
	}

	public static Entity getEntity(net.minecraft.entity.Entity target) {
		if(target == null)return null;
		return new ApiEntity(target);
	}

	public static World getWorld(net.minecraft.world.World entityWorld) {
		if(entityWorld == null)return null;
		return new ApiWorld(entityWorld);
	}

	public static BlockPos getBlockPos(Vector3i v) {
		if(v == null)return null;
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static Block getBlock(net.minecraft.block.Block bl) {
		if(bl == null)return null;
		return new ApiBlock(bl);
	}

	public static TileEntity getTileEntity(net.minecraft.tileentity.TileEntity tile) {
		if(tile == null)return null;
		return new ApiTileEntity(tile);
	}

	public static EnumChatFormatting getEnumChatFormatting(TextModifier color) {
		if(color == null)return null;
		for(EnumChatFormatting s : EnumChatFormatting.values()){
			if(s.name().equals(color.name)){
				return s;
			}
		}
		return null;
	}
}
