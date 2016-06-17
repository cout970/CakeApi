package org.cakepowered.api.util;

import org.cakepowered.api.util.text.TextFormating;
import org.cakepowered.api.util.text.TextModifier;

public enum DyeColor {

	WHITE(0, 15, "white", "white", new Color(16777215), TextFormating.WHITE),
	ORANGE(1, 14, "orange", "orange", new Color(14188339), TextFormating.GOLD),
	MAGENTA(2, 13, "magenta", "magenta", new Color(11685080), TextFormating.AQUA),
	LIGHT_BLUE(3, 12, "light_blue", "lightBlue", new Color(6724056), TextFormating.BLUE),
	YELLOW(4, 11, "yellow", "yellow", new Color(15066419), TextFormating.YELLOW),
	LIME(5, 10, "lime", "lime", new Color(8375321), TextFormating.GREEN),
	PINK(6, 9, "pink", "pink", new Color(15892389), TextFormating.LIGHT_PURPLE),
	GRAY(7, 8, "gray", "gray", new Color(5000268), TextFormating.DARK_GRAY),
	SILVER(8, 7, "silver", "silver", new Color(10066329), TextFormating.GRAY),
	CYAN(9, 6, "cyan", "cyan", new Color(5013401), TextFormating.DARK_AQUA),
	PURPLE(10, 5, "purple", "purple", new Color(8339378), TextFormating.DARK_PURPLE),
	BLUE(11, 4, "blue", "blue", new Color(3361970), TextFormating.DARK_BLUE),
	BROWN(12, 3, "brown", "brown", new Color(6704179), TextFormating.GOLD),
	GREEN(13, 2, "green", "green", new Color(6717235), TextFormating.DARK_GREEN),
	RED(14, 1, "red", "red", new Color(10040115), TextFormating.DARK_RED),
	BLACK(15, 0, "black", "black", new Color(1644825), TextFormating.BLACK);

	private int id;
	private int dyeMetadata;
	private String name;
	private String unlocalizedName;
	private Color color;
	private TextModifier modifier;

	private DyeColor(int id, int dyeMetadata, String name, String unlocalizedName, Color color, TextModifier modifier) {
		this.id = id;
		this.dyeMetadata = dyeMetadata;
		this.name = name;
		this.unlocalizedName = unlocalizedName;
		this.color = color;
		this.modifier = modifier;
	}

	public int getId() {
		return id;
	}

	public int getDyeMetadata() {
		return dyeMetadata;
	}

	public String getName() {
		return name;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	public Color getColor() {
		return color;
	}

	public TextModifier getModifier() {
		return modifier;
	}
}
