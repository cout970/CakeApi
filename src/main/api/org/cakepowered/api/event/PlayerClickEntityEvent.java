package org.cakepowered.api.event;

import org.cakepowered.api.entity.Entity;

/**
 * Created by cout970 on 13/07/2016.
 */
public interface PlayerClickEntityEvent extends PlayerInteractEvent {

    Entity getTarget();
}
