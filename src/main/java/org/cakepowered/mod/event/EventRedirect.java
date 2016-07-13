package org.cakepowered.mod.event;

import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.core.ApiEventRegistry;
import org.cakepowered.mod.world.ApiWorldManager;

public class EventRedirect {

    @SubscribeEvent
    public void onLoadFromFile(PlayerEvent.LoadFromFile event) {
        event.getEntityPlayer().dimension = 0;
    }

    @SubscribeEvent
    public void onExecuteCommand(CommandEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiCommandExecuteEvent(e));
    }

    @SubscribeEvent
    public void onSpawn(EntityJoinWorldEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiEntityRespawnEvent(e));
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent event) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiServerUpdateEvent(event, CakeApiCore.server));
    }

    @SubscribeEvent
    public void onPlayerJoinEvent(PlayerLoggedInEvent e) {
        ApiWorldManager.INSTANCE.sendDimensionData(e.player);
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerJoinEvent(e));
    }

    @SubscribeEvent
    public void onPlayerQuitEvent(PlayerLoggedOutEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerQuitEvent(e));
    }

    @SubscribeEvent
    public void onPlayerChatEvent(ServerChatEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerChatEvent(e));
    }

    @SubscribeEvent
    public void onPlayerRespawn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerRespawnEvent(e));
    }

    @SubscribeEvent
    public void onPlayerClickEntitySpecific(net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerClickEntitySpecificEvent(e));
    }

    @SubscribeEvent
    public void onPlayerRightClickItem(net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerRightClickItemEvent(e));
    }

    @SubscribeEvent
    public void onPlayerClickEntity(net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerClickEntityEvent(e));
    }

    @SubscribeEvent
    public void onPlayerRightClickEmpty(net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerRightClickAirEvent(e));
    }

    @SubscribeEvent
    public void onPlayerRightClickBlock(net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerRightClickBlockEvent(e));
    }

    @SubscribeEvent
    public void onPlayerLeftClickEmptyk(net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickEmpty e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerLeftClickAirEvent(e));
    }

    @SubscribeEvent
    public void onPlayerLeftClickBlock(net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiPlayerLeftClickBlockEvent(e));
    }

    @SubscribeEvent
    public void onBlockBreak(BreakEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiBlockBreakEvent(e));
    }

    @SubscribeEvent
    public void onBlockPlace(PlaceEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiBlockPlaceEvent(e));
    }

    @SubscribeEvent
    public void onPlayerAttackEntity(AttackEntityEvent e) {
        ApiEventRegistry.INSTANCE.postEvent(new ApiEntityAttackedEvent(e));
    }
}
