package org.cakepowered.mod.recipe;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.recipe.RecipeManager;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ApiRecipeManager implements RecipeManager {

	public static final ApiRecipeManager INSTANCE = new ApiRecipeManager();

	@Override
	public void addFurnaceRecipe(ItemStack input, ItemStack output, float experience) {
		GameRegistry.addSmelting(PluginInterface.getItemStack(input), PluginInterface.getItemStack(output), experience);
	}

	@Override
	public void addCraftingRecipe(ItemStack output, Object... recipe) {
		for(int i = 0; i < recipe.length; i++){
			if(recipe[i] instanceof ItemStack){
				recipe[i] = PluginInterface.getItemStack((ItemStack) recipe[i]);
			}else if(recipe[i] instanceof Block){
				recipe[i] = PluginInterface.getBlock((Block) recipe[i]);
			}else if(recipe[i] instanceof Item){
				recipe[i] = PluginInterface.getItem((Item) recipe[i]);
			}
		}
		GameRegistry.addRecipe(PluginInterface.getItemStack(output), recipe);
	}

}
