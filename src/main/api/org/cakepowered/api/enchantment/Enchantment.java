package org.cakepowered.api.enchantment;

public interface Enchantment {

	int getID();

	int getLevel();

	int getMinLevel();

	int getMaxLevel();

	String getName();

	boolean canBeInBook();
}
