package org.cakepowered.api.inventory;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.nbt.NBTList;

public interface ItemStack {

	public Item getItem();

	public void setItem(Item item);

	public int getStackSize();

	public void setStackSize(int amount);

	public int getMaxStackSize();

	public int getMetadata();

	public int getDamage();

	public void setDamage(int value);

	public int getMaxDamage();

	public NBTCompound getNBTCompound();

	public void setNBTCopound(NBTCompound nbt);

	public ItemStack copy();

	public ItemStack splitStack(int amount);

	public void writeToNBT(NBTCompound nbt);

	public void readFromNBT(NBTCompound nbt);

	public boolean canBeDamaged();

	public void damageItem(int amount, Player player);

	public String getUnlocalizedName();

	public NBTList getEnchantmentTagList();

	public String getDisplayName();

	public void setDisplayName(String name);

	public void clearCustomName();

	public void addEnchantment(Enchantment ench, int level);

	public boolean canBeEnchanted();

	public boolean isEnchanted();

	public int getRepairCost();

	public void setRepairCost(int cost);
}
