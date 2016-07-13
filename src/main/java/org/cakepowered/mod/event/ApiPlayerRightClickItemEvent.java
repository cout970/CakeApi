package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerRightClickItemEvent;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiPlayerRightClickItemEvent extends ApiPlayerInteractEvent implements PlayerRightClickItemEvent {

    public ApiPlayerRightClickItemEvent(PlayerInteractEvent.RightClickItem e) {
        super(e);
    }
}
