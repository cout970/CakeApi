package org.cakepowered.api.implement;

import java.util.UUID;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

public class ApiEntity implements Entity {

	public net.minecraft.entity.Entity entity;
	
	public ApiEntity(net.minecraft.entity.Entity target) {
		entity = target;
	}

	@Override
	public UUID getUniqueID() {
		return entity.getUniqueID();
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(entity.getEntityWorld());
	}

	@Override
	public Vector3d getPosition() {
		return new Vector3d(entity.posX, entity.posY, entity.posZ);
	}

	@Override
	public void setPosition(Vector3d vec) {
		entity.posX = vec.getX();
		entity.posY = vec.getY();
		entity.posZ = vec.getZ();
	}

	@Override
	public Entity getRiddingEntity() {
		if(entity.ridingEntity == null)return null;
		return ForgeInterface.getEntity(entity.ridingEntity);
	}

	@Override
	public Entity getRiddingByEntity() {
		if(entity.riddenByEntity == null)return null;
		return ForgeInterface.getEntity(entity.riddenByEntity);
	}

	@Override
	public int getDimensionID() {
		return entity.dimension;
	}

	@Override
	public CommandSender getCommandSender() {
		return ForgeInterface.getCommandSender(entity);
	}
}