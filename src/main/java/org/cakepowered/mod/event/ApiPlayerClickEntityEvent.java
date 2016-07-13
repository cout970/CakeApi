package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.event.PlayerInteractEntityEvent;
import org.cakepowered.mod.util.ForgeInterface;

public class ApiPlayerClickEntityEvent extends ApiPlayerInteractEvent implements PlayerInteractEntityEvent {

    public PlayerInteractEvent.EntityInteract event;

    public ApiPlayerClickEntityEvent(PlayerInteractEvent.EntityInteract e) {
        super(e);
        event = e;
    }

    @Override
    public Entity getTarget() {
        return ForgeInterface.getEntity(event.getTarget());
    }
}
