package org.cakepowered.mod.event;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerRightClickBlockEvent;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.PluginInterface;

/**
 * Created by cout970 on 13/07/2016.
 */
public class ApiPlayerRightClickBlockEvent extends ApiPlayerInteractEvent implements PlayerRightClickBlockEvent {

    public PlayerInteractEvent.RightClickBlock event;

    public ApiPlayerRightClickBlockEvent(PlayerInteractEvent.RightClickBlock e) {
        super(e);
        event = e;
    }

    @Override
    public void setUseItem(EventResult result) {
        event.setUseItem(PluginInterface.getEventResult(result));
    }

    @Override
    public void setUseBlock(EventResult result) {
        event.setUseBlock(PluginInterface.getEventResult(result));
    }

    @Override
    public EventResult useItem() {
        return ForgeInterface.getEventResult(event.getUseItem());
    }

    @Override
    public EventResult useBlock() {
        return ForgeInterface.getEventResult(event.getUseBlock());
    }

    @Override
    public Vector3 getHit() {
        return ForgeInterface.getVector3(event.getHitVec());
    }
}