package org.cakepowered.mod.nbt;

import org.cakepowered.mod.util.IImplementation;

import net.minecraft.nbt.NBTBase;

public class ApiNBTBase implements org.cakepowered.api.nbt.NBTBase, IImplementation<NBTBase>{
	
	protected NBTBase base;
	
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

	@Override
	public NBTBase getMcObject() {
		return base;
	}
}
