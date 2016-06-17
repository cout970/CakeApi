package org.cakepowered.api.util.text;

public class TextModifier {

	public String name;
	public String controlString;
	public int colorIndex;

	public TextModifier(String name, String string, int colorIndex) {
		this.name = name;
		controlString = string;
		this.colorIndex = colorIndex;
	}

	@Override
	public String toString() {
		return controlString;
	}
}
