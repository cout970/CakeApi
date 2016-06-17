package org.cakepowered.mod.util;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTBase;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.util.text.TextModifier;
import org.cakepowered.mod.base.ApiServer;
import org.cakepowered.mod.block.ApiBlock;
import org.cakepowered.mod.block.ApiBlockState;
import org.cakepowered.mod.command.ApiCommandSender;
import org.cakepowered.mod.enchantment.ApiEnchantment;
import org.cakepowered.mod.entity.ApiEntity;
import org.cakepowered.mod.entity.ApiPlayer;
import org.cakepowered.mod.inventory.ApiInventory;
import org.cakepowered.mod.inventory.ApiItemStack;
import org.cakepowered.mod.item.ApiItem;
import org.cakepowered.mod.nbt.ApiNBTBase;
import org.cakepowered.mod.nbt.ApiNBTCompund;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;

public class PluginInterface {

	public static IBlockState getBlockState(BlockState state) {
		if (state == null)
			return null;
		return ((ApiBlockState) state).getMcObject();
	}

	public static net.minecraft.item.ItemStack getItemStack(ItemStack stack) {
		if (stack == null)
			return null;
		return ((ApiItemStack) stack).getMcObject();
	}

	public static net.minecraft.enchantment.Enchantment getEnchantment(Enchantment ench) {
		if (ench == null)
			return null;
		return ((ApiEnchantment) ench).getMcObject();
	}

	public static EnumChatFormatting getEnumChatFormatting(TextModifier color) {
		if (color == null)
			return null;
		for (EnumChatFormatting s : EnumChatFormatting.values()) {
			if (s.name().equals(color.name)) {
				return s;
			}
		}
		return null;
	}

	public static BlockPos getBlockPos(Vector3i v) {
		if (v == null)
			return null;
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static BlockPos getBlockPos(Vector3d v) {
		if (v == null)
			return null;
		return new BlockPos(v.getX(), v.getY(), v.getZ());
	}

	public static Vec3 getVec3(Vector3d v) {
		if (v == null)
			return null;
		return new Vec3(v.getX(), v.getY(), v.getZ());
	}

	public static net.minecraft.block.Block getBlock(Block block) {
		if (block == null)
			return null;
		return ((ApiBlock) block).getMcObject();
	}

	public static net.minecraft.item.Item getItem(Item item) {
		if (item == null)
			return null;
		return ((ApiItem) item).getMcObject();
	}

	public static net.minecraft.entity.Entity getEntity(Entity entity) {
		if (entity == null)
			return null;
		return ((ApiEntity) entity).getMcObject();
	}

	public static MinecraftServer getServer(Server server) {
		if (server == null)
			return null;
		return ((ApiServer) server).getMcObject();
	}

	public static NBTTagCompound getNBT(NBTCompound nbt) {
		return (NBTTagCompound) ((ApiNBTCompund) nbt).getMcObject();
	}

	public static IInventory getInventory(Inventory inv) {
		if (inv == null)
			return null;
		return ((ApiInventory) inv).getMcObject();
	}

	public static ICommandSender getCommandSender(CommandSender sender) {
		if (sender == null)
			return null;
		return ((ApiCommandSender) sender).getMcObject();
	}

	public static EntityPlayer getPlayer(Player player) {
		if (player == null)
			return null;
		return ((ApiPlayer) player).getMcPlayer();
	}

	public static net.minecraft.nbt.NBTBase getNBTBase(NBTBase nbt) {
		if (nbt == null)
			return null;
		return ((ApiNBTBase) nbt).getMcObject();
	}
}
