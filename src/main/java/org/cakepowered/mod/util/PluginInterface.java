package org.cakepowered.mod.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.core.Server;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.event.Event;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTBase;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.text.TextModifier;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.mod.block.ApiBlock;
import org.cakepowered.mod.block.ApiBlockState;
import org.cakepowered.mod.command.ApiCommandSender;
import org.cakepowered.mod.core.ApiServer;
import org.cakepowered.mod.enchantment.ApiEnchantment;
import org.cakepowered.mod.entity.ApiEntity;
import org.cakepowered.mod.entity.ApiPlayer;
import org.cakepowered.mod.inventory.ApiInventory;
import org.cakepowered.mod.inventory.ApiItemStack;
import org.cakepowered.mod.item.ApiItem;
import org.cakepowered.mod.nbt.ApiNBTBase;
import org.cakepowered.mod.nbt.ApiNBTCompound;

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

	public static TextFormatting getEnumChatFormatting(TextModifier color) {
		if (color == null)
			return null;

		for (TextFormatting s : TextFormatting.values()) {
			if (s.name().equals(color.name)) {
				return s;
			}
		}
		return null;
	}

	public static BlockPos getBlockPos(Vector3 v) {
		if (v == null)
			return null;
		return new BlockPos(v.getXi(), v.getYi(), v.getZi());
	}

	public static Vec3d getVec3(Vector3 v) {
		if (v == null)
			return null;
		return new Vec3d(v.getXd(), v.getYd(), v.getZd());
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
		return (NBTTagCompound) ((ApiNBTCompound) nbt).getMcObject();
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

	public static net.minecraftforge.fml.common.eventhandler.Event.Result getEventResult(Event.EventResult result) {
		if(result == null)return null;
		return net.minecraftforge.fml.common.eventhandler.Event.Result.values()[result.ordinal()];
	}
}
