package org.cakepowered.mod.nbt;

import org.cakepowered.api.nbt.NBTList;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.nbt.NBTTagList;

public class ApiNBTList extends ApiNBTBase implements NBTList {

	protected NBTTagList list;

	public ApiNBTList(NBTTagList b) {
		super(b);
		list = b;
	}

	@Override
	public byte getListType() {
		return (byte) list.getTagType();
	}

	@Override
	public void appendTag(org.cakepowered.api.nbt.NBTBase tag) {
		list.appendTag(PluginInterface.getNBTBase(tag));
	}

	@Override
	public org.cakepowered.api.nbt.NBTBase removeTag(int pos) {
		return ForgeInterface.getNBT(list.removeTag(pos));
	}

	@Override
	public int getTagAmount() {
		return list.tagCount();
	}

	@Override
	public org.cakepowered.api.nbt.NBTBase getTag(int pos) {
		return ForgeInterface.getNBT(list.get(pos));
	}
}
