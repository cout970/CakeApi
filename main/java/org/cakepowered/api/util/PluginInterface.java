package org.cakepowered.api.util;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.implement.ApiBlock;
import org.cakepowered.api.implement.ApiBlockState;
import org.cakepowered.api.implement.ApiEnchantment;
import org.cakepowered.api.implement.ApiEntity;
import org.cakepowered.api.implement.ApiItem;
import org.cakepowered.api.implement.ApiItemStack;
import org.cakepowered.api.implement.ApiServer;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.ApiNBTCompund;
import org.cakepowered.api.nbt.NBTCompund;
import org.cakepowered.api.util.text.TextModifier;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;

public class PluginInterface {

	public static IBlockState getBlockState(BlockState state) {
		if(state == null)return null;
		return ((ApiBlockState)state).getMcObject();
	}

	public static net.minecraft.item.ItemStack getItemStack(ItemStack stack) {
		if(stack == null)return null;
		return ((ApiItemStack)stack).getMcObject();
	}

	public static net.minecraft.enchantment.Enchantment getEnchantment(Enchantment ench) {
		if(ench == null)return null;
		return ((ApiEnchantment)ench).getMcObject();
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

	public static BlockPos getBlockPos(Vector3i v) {
		if(v == null)return null;
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static BlockPos getBlockPos(Vector3d v) {
		if(v == null)return null;
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static Vec3 getVec3(Vector3d v) {
		if(v == null)return null;
		return new Vec3(v.getX(), v.getY(), v.getZ());
	}

	public static net.minecraft.block.Block getBlock(Block block) {
		if(block == null)return null;
		return ((ApiBlock) block).getMcObject();
	}

	public static net.minecraft.item.Item getItem(Item item) {
		if(item == null)return null;
		return ((ApiItem)item).getMcObject();
	}

	public static net.minecraft.entity.Entity getEntity(Entity entity) {
		if(entity == null)return null;
		return ((ApiEntity)entity).getMcObject();
	}

	public static MinecraftServer getServer(Server server) {
		if(server == null)return null;
		return ((ApiServer)server).getMcObject();
	}

	public static NBTTagCompound getNBT(NBTCompund nbt) {
		return (NBTTagCompound) ((ApiNBTCompund)nbt).getMcObject();
	}
}
