package org.cakepowered.api.implement;

import org.cakepowered.api.base.Player;
import org.cakepowered.api.enchantment.Enchantment;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.ApiNBTCompund;
import org.cakepowered.api.nbt.NBTCompund;
import org.cakepowered.api.nbt.NBTList;
import org.cakepowered.api.util.ForgeInterface;

import net.minecraft.item.ItemStack;

public class ApiItemStack implements org.cakepowered.api.inventory.ItemStack{

	public ItemStack stack;
	
	public ApiItemStack(ItemStack stack){
		this.stack = stack;
	}

	@Override
	public int getDamage(){
		return stack.getItemDamage();
	}
	
	@Override
	public Item getItem() {
		return null;
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
		stack.setTagCompound(((ApiNBTCompund)nbt).nbt);
	}

	@Override
	public void setStackSize(int amount) {
		stack.stackSize = amount;
	}
	
	public String toString(){
		return stack.toString();
	}

	@Override
	public org.cakepowered.api.inventory.ItemStack copy() {
		return ForgeInterface.getApiItemStack(stack.copy());
	}

	@Override
	public org.cakepowered.api.inventory.ItemStack splitStack(int amount) {
		return ForgeInterface.getApiItemStack(stack.splitStack(amount));
	}

	@Override
	public void writeToNBT(NBTCompund nbt) {
		stack.writeToNBT(((ApiNBTCompund)nbt).nbt);
	}

	@Override
	public void readFromNBT(NBTCompund nbt) {
		stack.readFromNBT(((ApiNBTCompund)nbt).nbt);
	}

	@Override
	public boolean canBeDamaged() {
		return stack.isItemStackDamageable();
	}

	@Override
	public void damageItem(int amount, Player player) {
		stack.damageItem(amount, ((ApiPlayer)player).player);
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
		stack.addEnchantment(ForgeInterface.getEnchantment(ench), level);
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
	
	public boolean equals(Object o){
		if(o instanceof ApiItemStack){
			return stack.equals(((ApiItemStack) o).stack);
		}
		return false;
	}
}
