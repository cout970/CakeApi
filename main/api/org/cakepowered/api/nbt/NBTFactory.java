package org.cakepowered.api.nbt;

public interface NBTFactory {

	public NBTList newNBTList();
	public NBTCompund newNBTCompound();
	public NBTBase newNBTBase(byte id, Object data) throws ClassCastException;
}
