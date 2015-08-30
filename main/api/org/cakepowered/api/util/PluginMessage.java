package org.cakepowered.api.util;

import org.cakepowered.api.nbt.NBTCompund;

public class PluginMessage {

	protected String title;

	protected NBTCompund nbt;

	public PluginMessage(String title, NBTCompund nbt) {
		this.title = title;
		this.nbt = nbt;
	}

	public String getTitle() {
		return title;
	}

	public NBTCompund getNBTCompound() {
		return nbt;
	}

	@Override
	public String toString() {
		return "Plugin Message: Title: " + title + ", NBT: " + nbt;
	}
}
