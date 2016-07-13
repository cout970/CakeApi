package org.cakepowered.api.nbt;

public interface NBTCompound extends NBTBase {

	void removeTag(String name);

	boolean containsTag(String name);

	void setInteger(String name, int id);

	void setLong(String name, long id);

	void setFloat(String name, float id);

	void setDouble(String name, double id);

	void setString(String name, String id);

	void setIntegerArray(String name, int[] id);

	void setByte(String name, byte id);

	void setByteArray(String name, byte[] id);

	void setCompound(String name, NBTCompound id);

	void setBoolean(String name, boolean id);

	int getInteger(String name);

	long getLong(String name);

	float getFloat(String name);

	double getDouble(String name);

	String getString(String name);

	int[] getIntegerArray(String name);

	byte getByte(String name);

	byte[] getByteArray(String name);

	NBTCompound getCompound(String name);

	boolean getBoolean(String name);
}
