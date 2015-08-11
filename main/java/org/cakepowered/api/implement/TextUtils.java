package org.cakepowered.api.implement;

import java.awt.Color;

import org.cakepowered.api.util.text.TextFormating;
import org.cakepowered.api.util.text.TextModifier;

import net.minecraft.util.EnumChatFormatting;

public class TextUtils{

	public static void registerModifiers(){
		for(int i = 0; i<EnumChatFormatting.values().length; i++)
			addModifier(EnumChatFormatting.values()[i]);

	}

	private static void addModifier(EnumChatFormatting f) {
		TextModifier color = new TextModifier(f.name(), f.toString(), f.getColorIndex());
		switch (f.ordinal()) {
		case 0:
			TextFormating.BLACK = color;
			break;
		case 1:
			TextFormating.DARK_BLUE = color;
			break;
		case 2:
			TextFormating.DARK_GREEN = color;
			break;
		case 3:
			TextFormating.DARK_AQUA = color;
			break;
		case 4:
			TextFormating.DARK_RED = color;
			break;
		case 5:
			TextFormating.DARK_PURPLE = color;
			break;
		case 6:
			TextFormating.GOLD = color;
			break;
		case 7:
			TextFormating.GRAY = color;
			break;
		case 8:
			TextFormating.DARK_GRAY = color;
			break;
		case 9:
			TextFormating.BLUE = color;
			break;
		case 10:
			TextFormating.GREEN = color;
			break;
		case 11:
			TextFormating.AQUA = color;
			break;
		case 12:
			TextFormating.RED = color;
			break;
		case 13:
			TextFormating.LIGHT_PURPLE = color;
			break;
		case 14:
			TextFormating.YELLOW = color;
			break;
		case 15:
			TextFormating.WHITE = color;
			break;
		case 16:
			TextFormating.OBFUSCATED = color;
			break;
		case 17:
			TextFormating.BOLD = color;
			break;
		case 18:
			TextFormating.STRIKETHROUGH = color;
			break;
		case 19:
			TextFormating.UNDERLINE = color;
			break;
		case 20:
			TextFormating.ITALIC = color;
			break;
		case 21:
			TextFormating.RESET = color;
			break;
		default:
			break;
		}
	}
}
