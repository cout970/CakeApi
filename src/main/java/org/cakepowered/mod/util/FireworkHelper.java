package org.cakepowered.mod.util;

import org.cakepowered.api.firework.FireworkProperties;
import org.cakepowered.api.firework.FireworkExplosion;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class FireworkHelper {

	public static void generateFirework(ItemStack stack, FireworkProperties prop) {
		if (prop.explosions == null || prop.explosions.length == 0) {
			return;
		}
		NBTTagList list = new NBTTagList();

		for (FireworkExplosion exp : prop.explosions) {
			if (exp.colors == null && exp.type == null) {
				continue;
			}
			NBTTagCompound explosion = new NBTTagCompound();

			int[] colors = new int[exp.colors.length];
			for (int i = 0; i < exp.colors.length; i++) {
				colors[i] = exp.colors[i].toInt();
			}
			explosion.setIntArray("Colors", colors);

			if (exp.fadeColors != null) {
				int[] fadeColors = new int[exp.fadeColors.length];
				for (int i = 0; i < exp.fadeColors.length; i++) {
					fadeColors[i] = exp.fadeColors[i].toInt();
				}
				explosion.setIntArray("FadeColors", fadeColors);
			}
			explosion.setByte("Type", exp.type.getId());
			explosion.setBoolean("Flicker", exp.flicker);
			explosion.setBoolean("Trail", exp.trail);
			list.appendTag(explosion);
		}

		NBTTagCompound data = new NBTTagCompound();
		data.setTag("Explosions", list);
		data.setByte("Flight", prop.flight);

		NBTTagCompound finalNBT = new NBTTagCompound();
		finalNBT.setTag("Fireworks", data);
		stack.setTagCompound(finalNBT);
	}

}
