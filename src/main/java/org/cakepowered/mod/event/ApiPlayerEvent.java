package org.cakepowered.mod.event;

import org.cakepowered.api.entity.Player;
import org.cakepowered.api.event.PlayerEvent;
import org.cakepowered.mod.util.ForgeInterface;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiPlayerEvent extends ApiEvent implements PlayerEvent {

    protected net.minecraftforge.event.entity.player.PlayerEvent playerEvent;

    public ApiPlayerEvent(net.minecraftforge.event.entity.player.PlayerEvent eventBase) {
        super(eventBase);
        playerEvent = eventBase;
    }

    @Override
    public Player getPlayer() {
        return ForgeInterface.getPlayer(playerEvent.getEntityPlayer());
    }
}
