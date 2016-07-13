package org.cakepowered.api.event;

import org.cakepowered.api.util.Vector3;

/**
 * Created by cout970 on 13/07/2016.
 */
public interface PlayerLeftClickBlockEvent extends PlayerInteractEvent {

    Vector3 getHit();

    EventResult useBlock();

    EventResult useItem();

    void setUseBlock(EventResult result);

    void setUseItem(EventResult result);
}
