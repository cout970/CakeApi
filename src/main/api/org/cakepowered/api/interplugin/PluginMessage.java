package org.cakepowered.api.interplugin;

import org.cakepowered.api.nbt.NBTCompound;

public class PluginMessage {

	protected String title;

	protected NBTCompound nbt;

	public PluginMessage(String title, NBTCompound nbt) {
		this.title = title;
		this.nbt = nbt;
	}

	public String getTitle() {
		return title;
	}

	public NBTCompound getNBTCompound() {
		return nbt;
	}

	@Override
	public String toString() {
		return "Plugin Message: Title: " + title + ", NBT: " + nbt;
	}
}
