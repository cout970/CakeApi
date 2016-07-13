package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.util.Direction;
import org.cakepowered.api.util.PlayerHand;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;
import org.cakepowered.mod.util.ForgeInterface;

public class ApiPlayerInteractEvent  extends ApiPlayerEvent implements org.cakepowered.api.event.PlayerInteractEvent {

	protected PlayerInteractEvent interactEvent;

	public ApiPlayerInteractEvent(PlayerInteractEvent e) {
		super(e);
		interactEvent = e;
	}

	@Override
	public ItemStack getStack() {
		return ForgeInterface.getItemStack(interactEvent.getItemStack());
	}

	@Override
	public Direction getFace() {
		return ForgeInterface.getDirection(interactEvent.getFace());
	}

	@Override
	public Vector3 getPosition() {
		return ForgeInterface.getVector3(interactEvent.getPos());
	}

	@Override
	public World getWorld() {
		return ForgeInterface.getWorld(interactEvent.getWorld());
	}

	@Override
	public PlayerHand getHand() {
		return PlayerHand.values()[interactEvent.getHand().ordinal()];
	}

	@Override
	public ClickAction getAction() {
		if(interactEvent instanceof PlayerInteractEvent.LeftClickBlock) return ClickAction.LEFT_CLICK_BLOCK;
		if(interactEvent instanceof PlayerInteractEvent.RightClickBlock) return ClickAction.RIGHT_CLICK_BLOCK;
		if(interactEvent instanceof PlayerInteractEvent.RightClickEmpty) return ClickAction.RIGHT_CLICK_AIR;
		if(interactEvent instanceof PlayerInteractEvent.LeftClickEmpty) return ClickAction.LEFT_CLICK_AIR;
		return ClickAction.UNKNOWN;
	}

	@Override
	public Block getInteractBlock() {
		return ForgeInterface.getGame().getServer().getWorld(getPlayer().getDimensionID()).getBlock(getPosition());
	}
}
