package org.cakepowered.api.nbt;

public interface NBTList extends NBTBase {

	public byte getListType();

	public void appendTag(NBTBase tag);

	public NBTBase removeTag(int pos);

	public int getTagAmount();

	public NBTBase getTag(int pos);
}
