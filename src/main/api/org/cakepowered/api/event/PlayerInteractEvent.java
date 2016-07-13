package org.cakepowered.api.event;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.util.Direction;
import org.cakepowered.api.util.PlayerHand;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.World;

//Se deberia dejar de usar esta clase para usar sus subclases
@Deprecated
public interface PlayerInteractEvent extends PlayerEvent {

	Vector3 getPosition();

	Direction getFace();

	PlayerHand getHand();

    ItemStack getStack();

    World getWorld();


	//la accion se extra del tipo de subclase del evento
	@Deprecated
	ClickAction getAction();

	@Deprecated
	enum ClickAction {
		RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK, LEFT_CLICK_BLOCK, LEFT_CLICK_AIR, UNKNOWN

	}

	@Deprecated
	Block getInteractBlock();
}
