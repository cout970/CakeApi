package org.cakepowered.mod.event;

import org.cakepowered.api.core.Game;
import org.cakepowered.api.event.Event;
import org.cakepowered.mod.util.ForgeInterface;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiEvent implements Event {

    protected net.minecraftforge.fml.common.eventhandler.Event eventBase;

    public ApiEvent(net.minecraftforge.fml.common.eventhandler.Event eventBase) {
        this.eventBase = eventBase;
    }

    @Override
    public Game getGame() {
        return ForgeInterface.getGame();
    }

    @Override
    public boolean isEventCancelable() {
        return eventBase.isCancelable();
    }

    @Override
    public void setEventCanceled(boolean value) {
        eventBase.setCanceled(value);
    }

    @Override
    public boolean hasEventResult() {
        return eventBase.hasResult();
    }

    @Override
    public EventResult getEventResult() {
        return ForgeInterface.getEventResult(eventBase.getResult());
    }

    @Override
    public boolean isEventCanceled() {
        return eventBase.isCanceled();
    }
}
