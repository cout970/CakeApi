package org.cakepowered.mod.enchantment;

import org.cakepowered.mod.util.IImplementation;

import net.minecraft.enchantment.Enchantment;

public class ApiEnchantment
		implements org.cakepowered.api.enchantment.Enchantment, IImplementation<net.minecraft.enchantment.Enchantment> {

	protected Enchantment ench;

	public ApiEnchantment(net.minecraft.enchantment.Enchantment ench) {
		this.ench = ench;
	}

	@Override
	public int getLevel() {
		return ench.getRarity().getWeight();
	}

	@Override
	public int getMinLevel() {
		return ench.getMinLevel();
	}

	@Override
	public int getMaxLevel() {
		return ench.getMaxLevel();
	}

	@Override
	public String getName() {
		return ench.getName();
	}

	@Override
	public boolean canBeInBook() {
		return ench.isAllowedOnBooks();
	}

	@Override
	public int getID() {
		return Enchantment.getEnchantmentID(ench);
	}

	@Override
	public Enchantment getMcObject() {
		return ench;
	}
}
