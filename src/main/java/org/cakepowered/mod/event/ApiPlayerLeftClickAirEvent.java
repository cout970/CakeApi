package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerLeftClickAirEvent;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiPlayerLeftClickAirEvent extends ApiPlayerInteractEvent implements PlayerLeftClickAirEvent {

    public ApiPlayerLeftClickAirEvent(PlayerInteractEvent.LeftClickEmpty e) {
        super(e);
    }
}
