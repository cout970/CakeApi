package org.cakepowered.api.inventory;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.nbt.NBTList;

public interface ItemStack {

	Item getItem();

	void setItem(Item item);

	int getStackSize();

	void setStackSize(int amount);

	int getMaxStackSize();

	int getMetadata();

	int getDamage();

	void setDamage(int value);

	int getMaxDamage();

	NBTCompound getNBTCompound();

	void setNBTCopound(NBTCompound nbt);

	ItemStack copy();

	ItemStack splitStack(int amount);

	void writeToNBT(NBTCompound nbt);

	void readFromNBT(NBTCompound nbt);

	boolean canBeDamaged();

	void damageItem(int amount, Player player);

	String getUnlocalizedName();

	NBTList getEnchantmentTagList();

	String getDisplayName();

	void setDisplayName(String name);

	void clearCustomName();

	void addEnchantment(Enchantment ench, int level);

	boolean canBeEnchanted();

	boolean isEnchanted();

	int getRepairCost();

	void setRepairCost(int cost);
}
