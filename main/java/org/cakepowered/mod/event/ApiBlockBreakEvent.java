package org.cakepowered.mod.event;

import org.cakepowered.api.base.Game;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.event.BlockBreakEvent;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class ApiBlockBreakEvent implements BlockBreakEvent{

	public BreakEvent event;
	
	public ApiBlockBreakEvent(BreakEvent e){
		event = e;
	}

	@Override
	public Vector3i getPosition() {
		return ForgeInterface.getVector3i(event.pos);
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(event.world);
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
	public boolean isEventCanceled() {
		return event.isCanceled();
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
	public Player getPlayer() {
		return ForgeInterface.getPlayer(event.getPlayer());
	}
}
