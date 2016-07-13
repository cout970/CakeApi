package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerRightClickAirEvent;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiPlayerRightClickAirEvent extends ApiPlayerInteractEvent implements PlayerRightClickAirEvent {

    public ApiPlayerRightClickAirEvent(PlayerInteractEvent.RightClickEmpty e) {
        super(e);
    }
}
