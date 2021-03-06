package org.cakepowered.mod.nbt;

import net.minecraft.nbt.*;
import org.cakepowered.api.nbt.NBTBase;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.nbt.NBTFactory;
import org.cakepowered.api.nbt.NBTList;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.PluginInterface;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ApiNBTFactory implements NBTFactory {

	public static final ApiNBTFactory INSTANCE = new ApiNBTFactory();

	@Override
	public NBTList newNBTList() {
		return new ApiNBTList(new NBTTagList());
	}

	@Override
	public NBTCompound newNBTCompound() {
		return new ApiNBTCompound(new NBTTagCompound());
	}

	@Override
	public NBTBase newNBTBase(byte id, Object data) throws ClassCastException {
		net.minecraft.nbt.NBTBase nbt = null;
		switch (id) {
		case 0:
			nbt = new NBTTagEnd();
			break;
		case 1:
			nbt = new NBTTagByte((Byte) data);
			break;
		case 2:
			nbt = new NBTTagShort((Short) data);
			break;
		case 3:
			nbt = new NBTTagInt((Integer) data);
			break;
		case 4:
			nbt = new NBTTagLong((Long) data);
			break;
		case 5:
			nbt = new NBTTagFloat((Float) data);
			break;
		case 6:
			nbt = new NBTTagDouble((Double) data);
			break;
		case 7:
			nbt = new NBTTagByteArray((byte[]) data);
			break;
		case 8:
			nbt = new NBTTagString((String) data);
			break;
		case 9:
			nbt = new NBTTagList();
			break;
		case 10:
			nbt = new NBTTagCompound();
			break;
		case 11:
			nbt = new NBTTagIntArray((int[]) data);
			break;
		default:
			return null;
		}
		return ForgeInterface.getNBT(nbt);
	}
	
	@Override
	public NBTCompound readCompressedNBT(InputStream stream){
		NBTTagCompound nbt = null;
		
		try {
			nbt = CompressedStreamTools.readCompressed(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return (NBTCompound) ForgeInterface.getNBT(nbt);
	}
	
	@Override
	public void writeCompressedNBT(OutputStream stream, NBTCompound nbt){
		try {
			CompressedStreamTools.writeCompressed(PluginInterface.getNBT(nbt), stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public NBTCompound readNBT(File file){
		NBTTagCompound nbt = null;
		try {
			nbt = CompressedStreamTools.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (NBTCompound) ForgeInterface.getNBT(nbt);
	}
	
	@Override
	public void writeNBT(File file, NBTCompound nbt){
		try {
			CompressedStreamTools.write(PluginInterface.getNBT(nbt), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
