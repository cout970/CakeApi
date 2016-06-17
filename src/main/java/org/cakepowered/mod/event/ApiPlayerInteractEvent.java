package org.cakepowered.mod.event;

import org.cakepowered.api.core.Game;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.util.Direction;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ApiPlayerInteractEvent implements org.cakepowered.api.event.PlayerInteractEvent {

	public PlayerInteractEvent event;

	public ApiPlayerInteractEvent(PlayerInteractEvent e) {
		event = e;
	}

	@Override
	public Player getPlayer() {
		return ForgeInterface.getPlayer(event.entityPlayer);
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
	public Direction getFace() {
		return ForgeInterface.getDirection(event.face);
	}

	@Override
	public ClickAction getAction() {
		if (event.action == null)
			return null;
		return ClickAction.values()[event.action.ordinal()];
	}

	@Override
	public Vector3 getPosition() {
		return ForgeInterface.getVector3(event.pos);
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(event.world);
	}

	@Override
	public Block getInteractBlock() {
		return ForgeInterface.getGame().getServer().getWorld(getPlayer().getDimensionID()).getBlock(getPosition());
	}
}
