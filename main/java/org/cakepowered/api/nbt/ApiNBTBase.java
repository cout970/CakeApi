package org.cakepowered.api.nbt;

import net.minecraft.nbt.NBTBase;

public class ApiNBTBase implements org.cakepowered.api.nbt.NBTBase{
	
	public NBTBase base;
	
	public ApiNBTBase(NBTBase b){
		base = b;
	}

	@Override
	public byte getID() {
		return base.getId();
	}

	@Override
	public org.cakepowered.api.nbt.NBTBase copy() {
		return new ApiNBTBase(base.copy());
	}
	
	@Override
	public String toString(){
		return base.toString();
	}
}
