package org.cakepowered.api.util;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.commands.ApiCommandSender;
import org.cakepowered.api.event.Event.EventResult;
import org.cakepowered.api.implement.ApiBlock;
import org.cakepowered.api.implement.ApiBlockState;
import org.cakepowered.api.implement.ApiEntity;
import org.cakepowered.api.implement.ApiInventory;
import org.cakepowered.api.implement.ApiItem;
import org.cakepowered.api.implement.ApiItemStack;
import org.cakepowered.api.implement.ApiPlayer;
import org.cakepowered.api.implement.ApiTileEntity;
import org.cakepowered.api.implement.ApiWorld;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.ApiNBTBase;
import org.cakepowered.api.nbt.ApiNBTCompund;
import org.cakepowered.api.nbt.ApiNBTList;
import org.cakepowered.api.nbt.NBTBase;
import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.world.World;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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

	public static Block getBlock(net.minecraft.block.Block bl) {
		if(bl == null)return null;
		return new ApiBlock(bl);
	}

	public static TileEntity getTileEntity(net.minecraft.tileentity.TileEntity tile) {
		if(tile == null)return null;
		return new ApiTileEntity(tile);
	}

	public static NBTBase fromNBT(net.minecraft.nbt.NBTBase tag) {
		if(tag == null)return null;
		if(tag instanceof NBTTagCompound){
			return new ApiNBTCompund((NBTTagCompound) tag);
		}
		if(tag instanceof NBTTagList){
			return new ApiNBTList((NBTTagList) tag);
		}
		return new ApiNBTBase(tag);
	}

	public static ItemStack getItemStack(net.minecraft.item.ItemStack stack) {
		if(stack == null)return null;
		return new ApiItemStack(stack);
	}

	public static Item getItem(net.minecraft.item.Item stack) {
		if(stack == null)return null;
		return new ApiItem(stack);
	}

	public static Inventory getInventory(IInventory inv) {
		if(inv == null)return null;
		return new ApiInventory(inv);
	}

	public static BlockState getBlockState(IBlockState state) {
		if(state == null)return null;
		return new ApiBlockState(state);
	}
}
