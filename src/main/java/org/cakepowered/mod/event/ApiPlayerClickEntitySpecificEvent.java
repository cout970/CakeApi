package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.event.PlayerClickEntitySpecificEvent;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.mod.util.ForgeInterface;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiPlayerClickEntitySpecificEvent extends ApiPlayerInteractEvent implements PlayerClickEntitySpecificEvent {

    public PlayerInteractEvent.EntityInteractSpecific event;

    public ApiPlayerClickEntitySpecificEvent(PlayerInteractEvent.EntityInteractSpecific e) {
        super(e);
        event = e;
    }

    @Override
    public Entity getTarget() {
        return ForgeInterface.getEntity(event.getTarget());
    }

    @Override
    public Vector3 getLocalPos() {
        return ForgeInterface.getVector3(event.getLocalPos());
    }
}
