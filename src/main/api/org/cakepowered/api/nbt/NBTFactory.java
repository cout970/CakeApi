package org.cakepowered.api.nbt;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public interface NBTFactory {

	NBTList newNBTList();

	NBTCompound newNBTCompound();

	NBTBase newNBTBase(byte id, Object data) throws ClassCastException;
	
	NBTCompound readCompressedNBT(InputStream stream);
	
	void writeCompressedNBT(OutputStream stream, NBTCompound nbt);
	
	NBTCompound readNBT(File file);
	
	void writeNBT(File file, NBTCompound nbt);
}
