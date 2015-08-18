package org.cakepowered.api.implement;

import org.cakepowered.api.enchantment.Enchantment;

public class ApiEnchantment implements Enchantment{

	public net.minecraft.enchantment.Enchantment ench;
	
	public ApiEnchantment(net.minecraft.enchantment.Enchantment ench){
		this.ench = ench;
	}

	@Override
	public int getLevel() {
		return ench.getWeight();
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
		return ench.effectId;
	}
}
