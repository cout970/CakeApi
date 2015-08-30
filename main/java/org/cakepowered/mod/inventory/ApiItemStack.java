package org.cakepowered.mod.inventory;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompund;
import org.cakepowered.api.nbt.NBTList;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.item.ItemStack;

public class ApiItemStack implements org.cakepowered.api.inventory.ItemStack, IImplementation<ItemStack> {

	protected ItemStack stack;

	public ApiItemStack(ItemStack stack) {
		this.stack = stack;
	}

	@Override
	public int getDamage() {
		return stack.getItemDamage();
	}

	@Override
	public Item getItem() {
		return ForgeInterface.getItem(stack.getItem());
	}

	@Override
	public int getMaxDamage() {
		return stack.getMaxDamage();
	}

	@Override
	public int getMaxStackSize() {
		return stack.getMaxStackSize();
	}

	@Override
	public int getMetadata() {
		return stack.getMetadata();
	}

	@Override
	public NBTCompund getNBTCompound() {
		return (NBTCompund) ForgeInterface.fromNBT(stack.getTagCompound());
	}

	@Override
	public int getStackSize() {
		return stack.stackSize;
	}

	@Override
	public void setDamage(int meta) {
		stack.setItemDamage(meta);
	}

	@Override
	public void setItem(Item item) {

	}

	@Override
	public void setNBTCopound(NBTCompund nbt) {
		stack.setTagCompound(PluginInterface.getNBT(nbt));
	}

	@Override
	public void setStackSize(int amount) {
		stack.stackSize = amount;
	}

	@Override
	public String toString() {
		return stack.toString();
	}

	@Override
	public org.cakepowered.api.inventory.ItemStack copy() {
		return ForgeInterface.getItemStack(stack.copy());
	}

	@Override
	public org.cakepowered.api.inventory.ItemStack splitStack(int amount) {
		return ForgeInterface.getItemStack(stack.splitStack(amount));
	}

	@Override
	public void writeToNBT(NBTCompund nbt) {
		stack.writeToNBT(PluginInterface.getNBT(nbt));
	}

	@Override
	public void readFromNBT(NBTCompund nbt) {
		stack.readFromNBT(PluginInterface.getNBT(nbt));
	}

	@Override
	public boolean canBeDamaged() {
		return stack.isItemStackDamageable();
	}

	@Override
	public void damageItem(int amount, Player player) {
		stack.damageItem(amount, PluginInterface.getPlayer(player));
	}

	@Override
	public String getUnlocalizedName() {
		return stack.getUnlocalizedName();
	}

	@Override
	public NBTList getEnchantmentTagList() {
		return (NBTList) ForgeInterface.fromNBT(stack.getEnchantmentTagList());
	}

	@Override
	public String getDisplayName() {
		return stack.getDisplayName();
	}

	@Override
	public void setDisplayName(String name) {
		stack.setStackDisplayName(name);
	}

	@Override
	public void clearCustomName() {
		stack.clearCustomName();
	}

	@Override
	public void addEnchantment(Enchantment ench, int level) {
		stack.addEnchantment(PluginInterface.getEnchantment(ench), level);
	}

	@Override
	public boolean canBeEnchanted() {
		return stack.isItemEnchantable();
	}

	@Override
	public boolean isEnchanted() {
		return stack.isItemEnchanted();
	}

	@Override
	public int getRepairCost() {
		return stack.getRepairCost();
	}

	@Override
	public void setRepairCost(int cost) {
		stack.setRepairCost(cost);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ApiItemStack) {
			return stack.equals(((ApiItemStack) o).stack);
		}
		return false;
	}

	@Override
	public ItemStack getMcObject() {
		return stack;
	}
}
