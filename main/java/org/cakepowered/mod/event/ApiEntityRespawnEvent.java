package org.cakepowered.mod.event;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Game;
import org.cakepowered.api.event.EntitySpawnEvent;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ApiEntityRespawnEvent implements EntitySpawnEvent{

	public EntityJoinWorldEvent event;
	
	public ApiEntityRespawnEvent(EntityJoinWorldEvent e) {
		event = e;
	}

	@Override
	public Game getGame() {
		return ForgeInterface.getGame();
	}

	@Override
	public boolean isEventCancelable() {
		return event.isCancelable();
	}

	@Override
	public void setEventCanceled(boolean value) {
		event.setCanceled(value);
	}

	@Override
	public boolean hasEventResult() {
		return event.hasResult();
	}

	@Override
	public EventResult getEventResult() {
		return ForgeInterface.getEventResult(event.getResult());
	}

	@Override
	public boolean isEventCanceled() {
		return event.isCanceled();
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(event.world);
	}

	@Override
	public Entity getEntity() {
		return ForgeInterface.getEntity(event.entity);
	}
}
