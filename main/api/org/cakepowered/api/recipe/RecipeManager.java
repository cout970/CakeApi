package org.cakepowered.api.recipe;

import org.cakepowered.api.inventory.ItemStack;

public interface RecipeManager {

	/**
	 * add a furnace recipe
	 * @param input
	 *            must no be null
	 * @param output
	 *            must no be null
	 * @param experience
	 *            must be positive
	 */
	public void addFurnaceRecipe(ItemStack input, ItemStack output, float experience);

	/**
	 * recipe example: addCraftingRecipe( new ItemStack(Blocks.bookshelf, 1), new Object[] { "###", "XXX",
	 * "###", '#', Blocks.planks, 'X', Items.book});
	 * @param output
	 * @param recipe
	 */
	public void addCraftingRecipe(ItemStack output, Object... recipe);
}
