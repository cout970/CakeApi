package org.cakepowered.api.util.text;

import java.util.ArrayList;
import java.util.List;

public class TextFormating {

	public static List<TextModifier> modifiers = new ArrayList<TextModifier>();

	public static TextModifier BLACK;
	public static TextModifier DARK_BLUE;
	public static TextModifier DARK_GREEN;
	public static TextModifier DARK_AQUA;
	public static TextModifier DARK_RED;
	public static TextModifier DARK_PURPLE;
	public static TextModifier GOLD;
	public static TextModifier GRAY;
	public static TextModifier DARK_GRAY;
	public static TextModifier BLUE;
	public static TextModifier GREEN;
	public static TextModifier AQUA;
	public static TextModifier RED;
	public static TextModifier LIGHT_PURPLE;
	public static TextModifier YELLOW;
	public static TextModifier WHITE;
	public static TextModifier RESET;
	public static TextModifier OBFUSCATED;
	public static TextModifier BOLD;
	public static TextModifier STRIKETHROUGH;
	public static TextModifier UNDERLINE;
	public static TextModifier ITALIC;

	public static String toPlainString(String str) {
		for (TextModifier mod : modifiers) {
			str = str.replaceAll(mod.controlString, "");
		}
		return str;
	}
}
