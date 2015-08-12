package org.cakepowered.api.util;

import java.awt.Color;
import java.util.EnumMap;

import org.cakepowered.api.util.text.TextFormating;
import org.cakepowered.api.util.text.TextModifier;

import net.minecraft.util.EnumChatFormatting;

public class TextUtils{
	
	public static EnumMap<EnumChatFormatting, TextModifier> modifiers = new EnumMap<EnumChatFormatting, TextModifier>(EnumChatFormatting.class);

	public static void registerModifiers(){
		for(int i = 0; i<EnumChatFormatting.values().length; i++)
			addModifier(EnumChatFormatting.values()[i]);

	}

	private static void addModifier(EnumChatFormatting f) {
		TextModifier modifier = new TextModifier(f.name(), f.toString(), f.getColorIndex());
		modifiers.put(f, modifier);
		TextFormating.modifiers.add(modifier);
		switch (f.ordinal()) {
		case 0:
			TextFormating.BLACK = modifier;
			break;
		case 1:
			TextFormating.DARK_BLUE = modifier;
			break;
		case 2:
			TextFormating.DARK_GREEN = modifier;
			break;
		case 3:
			TextFormating.DARK_AQUA = modifier;
			break;
		case 4:
			TextFormating.DARK_RED = modifier;
			break;
		case 5:
			TextFormating.DARK_PURPLE = modifier;
			break;
		case 6:
			TextFormating.GOLD = modifier;
			break;
		case 7:
			TextFormating.GRAY = modifier;
			break;
		case 8:
			TextFormating.DARK_GRAY = modifier;
			break;
		case 9:
			TextFormating.BLUE = modifier;
			break;
		case 10:
			TextFormating.GREEN = modifier;
			break;
		case 11:
			TextFormating.AQUA = modifier;
			break;
		case 12:
			TextFormating.RED = modifier;
			break;
		case 13:
			TextFormating.LIGHT_PURPLE = modifier;
			break;
		case 14:
			TextFormating.YELLOW = modifier;
			break;
		case 15:
			TextFormating.WHITE = modifier;
			break;
		case 16:
			TextFormating.OBFUSCATED = modifier;
			break;
		case 17:
			TextFormating.BOLD = modifier;
			break;
		case 18:
			TextFormating.STRIKETHROUGH = modifier;
			break;
		case 19:
			TextFormating.UNDERLINE = modifier;
			break;
		case 20:
			TextFormating.ITALIC = modifier;
			break;
		case 21:
			TextFormating.RESET = modifier;
			break;
		default:
			break;
		}
	}
}
