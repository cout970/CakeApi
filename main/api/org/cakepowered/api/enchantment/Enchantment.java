package org.cakepowered.api.enchantment;

public interface Enchantment {
	
	public int getID();
	
	public int getLevel();
	
	public int getMinLevel();
	
	public int getMaxLevel();
	
	public String getName();
	
	public boolean canBeInBook();
}
