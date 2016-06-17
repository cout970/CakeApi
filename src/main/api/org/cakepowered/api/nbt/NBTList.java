package org.cakepowered.api.nbt;

public interface NBTList extends NBTBase {

	byte getListType();

	void appendTag(NBTBase tag);

	NBTBase removeTag(int pos);

	int getTagAmount();

	NBTBase getTag(int pos);
}
