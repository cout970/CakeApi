package org.cakepowered.api.nbt;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public interface NBTFactory {

	NBTList newNBTList();

	NBTCompund newNBTCompound();

	NBTBase newNBTBase(byte id, Object data) throws ClassCastException;
	
	NBTCompund readCompressedNBT(InputStream stream);
	
	void writeCompressedNBT(OutputStream stream, NBTCompund nbt);
	
	NBTCompund readNBT(File file);
	
	void writeNBT(File file, NBTCompund nbt);
}
