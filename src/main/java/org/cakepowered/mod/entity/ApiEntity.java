package org.cakepowered.mod.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;
import org.cakepowered.api.command.CommandSender;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ApiEntity implements org.cakepowered.api.entity.Entity, IImplementation<Entity> {

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
	public Vector3 getPosition() {
		return new Vector3(entity.posX, entity.posY, entity.posZ);
	}

	@Override
	public void setPosition(Vector3 vec) {
		entity.setPosition(vec.getXd(), vec.getYd(), vec.getZd());
	}

	@Override
	public org.cakepowered.api.entity.Entity getRiddingEntity() {
		if (entity.getRidingEntity() == null)
			return null;
		return ForgeInterface.getEntity(entity.getRidingEntity());
	}

	@Override
	public List<org.cakepowered.api.entity.Entity> getPassengers() {
		return entity.getPassengers().stream().map(ForgeInterface::getEntity).collect(Collectors.toCollection(LinkedList::new));
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
		if (er == null)
			return null;
		ModContainer mc = er.getContainer();
		if (mc == null)
			return null;
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
	
	@Override
	public Object getEntity(){
		return entity;
	}
	
}
