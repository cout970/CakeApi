package org.cakepowered.mod.entity;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.inventory.PlayerInventory;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.text.TextFormating;
import org.cakepowered.api.title.Title;
import org.cakepowered.api.util.DirectionYaw;
import org.cakepowered.api.util.EntityLocation;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.inventory.ApiInventory;
import org.cakepowered.mod.inventory.ApiPlayerInventory;
import org.cakepowered.mod.scoreboard.ApiScoreboard;
import org.cakepowered.mod.scoreboard.ApiTeam;
import org.cakepowered.mod.tileentity.FakeTileEntityChest;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.PluginInterface;
import org.cakepowered.mod.util.TitleUtils;

import java.net.SocketAddress;
import java.util.Iterator;

public class ApiPlayer extends ApiEntity implements Player {

    protected EntityPlayer player;

    public ApiPlayer(EntityPlayer player) {
        super(player);
        this.player = player;
    }

    @Override
    public void playSound(String sound, float volume, float pitch) {
        Packet packet = new S29PacketSoundEffect(sound, player.posX, player.posY, player.posZ, volume, pitch);
        ((EntityPlayerMP) player).playerNetServerHandler.sendPacket(packet);
    }

    @Override
    public String getUserName() {
        return player.getName();
    }

    @Override
    public void sendMessage(String s) {
        player.addChatComponentMessage(new ChatComponentText(s));
    }

    @Override
    public void sendLink(String link) {
        IChatComponent chat = new ChatComponentText(link);
        ChatStyle style = new ChatStyle();
        style.setChatClickEvent(new ClickEvent(Action.OPEN_URL, TextFormating.toPlainString(link)));
        chat.setChatStyle(style);
        player.addChatMessage(chat);
    }

    @Override
    public void sendMessageWithLinks(String s) {
        IChatComponent toSend = new ChatComponentText("");
        String[] message = s.split(" ");

        for (int i = 0; i < message.length; i++) {
            if (message[i].contains("http:") || message[i].contains("https:")) {
                IChatComponent chat = new ChatComponentText(message[i]);
                ChatStyle style = new ChatStyle();
                style.setChatClickEvent(new ClickEvent(Action.OPEN_URL, TextFormating.toPlainString(message[i])));
                chat.setChatStyle(style);
                if (i != 0) {
                    toSend.appendText(" ");
                }
                toSend.appendSibling(chat);
            } else {
                if (i != 0) {
                    toSend.appendText(" ");
                }
                toSend.appendText(message[i]);
            }
        }

        player.addChatMessage(toSend);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            return getUniqueID().equals(((Player) o).getUniqueID());
        }
        return false;
    }

    @Override
    public void setSpawnLocation(Vector3 loc) {
        player.setSpawnPoint(PluginInterface.getBlockPos(loc), false);
    }

    @Override
    public void moveToWorld(EntityLocation loc) {
        setLocation(loc);
    }

    @Override
    public EntityLocation getLocation() {
        return new EntityLocation(getWorld().getDimension(), getPosition(), player.rotationYaw, player.rotationPitch);
    }

    @Override
    public int getGameMode() {
        return ((EntityPlayerMP) player).theItemInWorldManager.getGameType().getID();
    }

    @Override
    public void setGameMode(int value) {
        GameType mode = GameType.getByID(value);
        player.setGameType(mode);
    }

    @Override
    public boolean isOP() {
        for (String s : PluginInterface.getServer(CakeApiCore.server).getConfigurationManager().getOppedPlayerNames()) {
            if (getUserName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setLocation(EntityLocation loc) {
        World w = player.getEntityWorld();
        getWorld().loadChunk(player.chunkCoordX, player.chunkCoordZ);
        player.setPositionAndUpdate(loc.getX(), loc.getY(), loc.getZ());
        ((EntityPlayerMP) player).playerNetServerHandler.setPlayerLocation(loc.getX(), loc.getY(), loc.getZ(),
                loc.getYaw(), loc.getPitch());
        if (w.provider.getDimensionId() != loc.getDimension()) {
            teleportToDimension((EntityPlayerMP) player, loc.getDimension());
        }
    }

    private void teleportToDimension(EntityPlayerMP player, int dimensionId) {
        //esto evita un bug con la barra de experiencia
        player.addExperienceLevel(0);
        transferPlayerToDimension(player, dimensionId, MinecraftServer.getServer().getConfigurationManager());
        //        MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(player, dimensionId, new CustomTeleporter(world));
    }

    public static void transferEntityToWorld(Entity entity, WorldServer oldWorld, WorldServer newWorld) {

        WorldProvider pOld = oldWorld.provider;
        WorldProvider pNew = newWorld.provider;
        double moveFactor = pOld.getMovementFactor() / pNew.getMovementFactor();
        double x = entity.posX * moveFactor;
        double z = entity.posZ * moveFactor;

        oldWorld.theProfiler.startSection("placing");
        x = MathHelper.clamp_double(x, -29999872, 29999872);
        z = MathHelper.clamp_double(z, -29999872, 29999872);

        if (entity.isEntityAlive()) {
            entity.setLocationAndAngles(x, entity.posY, z, entity.rotationYaw, entity.rotationPitch);
            newWorld.spawnEntityInWorld(entity);
            newWorld.updateEntityWithOptionalForce(entity, false);
        }

        oldWorld.theProfiler.endSection();

        entity.setWorld(newWorld);
    }

    public static void transferPlayerToDimension(EntityPlayerMP player, int dimension, ServerConfigurationManager manager) {

        int oldDim = player.dimension;
        WorldServer worldserver = manager.getServerInstance().worldServerForDimension(player.dimension);
        player.dimension = dimension;
        WorldServer worldserver1 = manager.getServerInstance().worldServerForDimension(player.dimension);
        player.playerNetServerHandler.sendPacket(new S07PacketRespawn(player.dimension, player.worldObj.getDifficulty(), player.worldObj.getWorldInfo()
                .getTerrainType(), player.theItemInWorldManager.getGameType()));
        worldserver.removePlayerEntityDangerously(player);
        if (player.riddenByEntity != null) {
            player.riddenByEntity.mountEntity(null);
        }
        if (player.ridingEntity != null) {
            player.mountEntity(null);
        }
        player.isDead = false;
        transferEntityToWorld(player, worldserver, worldserver1);
        manager.preparePlayer(player, worldserver);
        player.playerNetServerHandler.setPlayerLocation(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
        player.theItemInWorldManager.setWorld(worldserver1);
        manager.updateTimeAndWeatherForPlayer(player, worldserver1);
        manager.syncPlayerInventory(player);
        Iterator<PotionEffect> iterator = player.getActivePotionEffects().iterator();

        while (iterator.hasNext()) {
            PotionEffect potioneffect = iterator.next();
            player.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(player.getEntityId(), potioneffect));
        }
        FMLCommonHandler.instance().firePlayerChangedDimensionEvent(player, oldDim, dimension);
    }

    @Override
    public DirectionYaw getDirection() {
        float yaw = wrapTo180(player.rotationYaw);
        if ((yaw < 45 && yaw >= 0) || (yaw > -45 && yaw <= 0)) {
            return DirectionYaw.SOUTH;
        } else if (yaw >= 45 && yaw < 135) {
            return DirectionYaw.WEST;
        } else if (yaw <= -45 && yaw > -135) {
            return DirectionYaw.EAST;
        } else if ((yaw >= 135 && yaw <= 180) || (yaw <= -135 && yaw >= -180)) {
            return DirectionYaw.NORTH;
        }
        return DirectionYaw.NORTH;
    }

    private static float wrapTo180(float angle) {
        angle %= 360.0F;

        if (angle >= 180.0F) {
            angle -= 360.0F;
        }

        if (angle < -180.0F) {
            angle += 360.0F;
        }

        return angle;
    }

    @Override
    public void sendTitle(Title t) {
        if (t == null) { return; }
        TitleUtils.sendTitle(((EntityPlayerMP) player).playerNetServerHandler, player, t);
    }

    @Override
    public Team getTeam() {
        return new ApiTeam((ScorePlayerTeam) (player.getTeam()));
    }

    @Override
    public Scoreboard getScoreboard() {
        return new ApiScoreboard((ServerScoreboard) player.getWorldScoreboard());
    }

    @Override
    public void kick(String mes) {
        if (mes == null) {
            mes = "";
        }
        EntityPlayerMP e = ((EntityPlayerMP) entity);

        if (e != null) {

            NetHandlerPlayServer net = e.playerNetServerHandler;

            if (net != null) {

                net.kickPlayerFromServer(mes);

            }

        }

    }

    @Override
    public void setPitchAndYaw(float p, float y) {
        player.rotationYaw = y;
        player.rotationPitch = p;

    }

    @Override
    public PlayerInventory getPlayerInventory() {
        return new ApiPlayerInventory(player.inventory);
    }

    @Override
    public ItemStack getCurrentItem() {
        return ForgeInterface.getItemStack(player.getCurrentEquippedItem());
    }

    @Override
    public int getSelectedSlot() {
        return player.inventory.currentItem;
    }

    @Override
    public boolean isSneaking() {
        return player.isSneaking();
    }

    public EntityPlayer getMcPlayer() {
        return player;
    }

    @Override
    public Inventory getPlayerEnderChest() {
        return new ApiInventory(player.getInventoryEnderChest());
    }

    @Override
    public void openGui(Inventory chest) {
        IInventory inv = PluginInterface.getInventory(chest);
        if (inv instanceof InventoryEnderChest) {
            openGuiEnderChest(chest);
            return;
        }
        player.displayGUIChest(inv);
    }

    @Override
    public void openGuiEnderChest(Inventory enderChest) {
        IInventory inv = PluginInterface.getInventory(enderChest);
        if (inv instanceof InventoryEnderChest) {
            InventoryEnderChest chest = (InventoryEnderChest) inv;
            chest.setChestTileEntity(new FakeTileEntityChest());
            player.displayGUIChest(chest);
        }
    }

    @Override
    public void openGuiWorkBench() {

        player.displayGui(new BlockWorkbench.InterfaceCraftingTable(player.worldObj, null) {

            @Override
            public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
                return new ContainerWorkbench(playerInventory, player.worldObj, null) {
                    @Override
                    public boolean canInteractWith(EntityPlayer playerIn) {
                        return true;
                    }
                };
            }
        });
    }

    @Override
    public void addPotionEffect(int id, int effectDuration, int effectAmplifier, boolean ambient,
                                boolean showParticles) {
        player.addPotionEffect(new PotionEffect(id, effectDuration, effectAmplifier, ambient, showParticles));
    }

    @Override
    public void clearActivePotions() {
        player.clearActivePotions();
    }

    @Override
    public SocketAddress getAddress() {
        try {
            return ((EntityPlayerMP) player).playerNetServerHandler.getNetworkManager().getRemoteAddress();
        } catch (Exception e) {
            //ignored
            return null;
        }
    }
}
