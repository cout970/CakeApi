package org.cakepowered.api.implement;

import java.util.UUID;

import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.IImplementation;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.world.World;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;

public class ApiEntity implements org.cakepowered.api.base.Entity, IImplementation<Entity> {

	protected Entity entity;
	
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
		entity.setPosition(vec.getX(), vec.getY(), vec.getZ());
	}

	@Override
	public org.cakepowered.api.base.Entity getRiddingEntity() {
		if(entity.ridingEntity == null)return null;
		return ForgeInterface.getEntity(entity.ridingEntity);
	}

	@Override
	public org.cakepowered.api.base.Entity getRiddingByEntity() {
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

	@Override
	public String getName() {
		return entity.getName();
	}

	@Override
	public String getModID() {
		EntityRegistration er = EntityRegistry.instance().lookupModSpawn(entity.getClass(), false);
		if(er == null)return null;
		ModContainer mc = er.getContainer();
		if(mc == null)return null;
		return mc.getModId();
	}

	@Override
	public void setDead() {	
		entity.setDead();
	}

	@Override
	public Entity getMcObject() {
		return entity;
	}
}
