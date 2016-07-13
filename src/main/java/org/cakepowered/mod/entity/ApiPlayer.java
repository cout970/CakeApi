package org.cakepowered.mod.entity;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
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
import org.cakepowered.api.util.PlayerHand;
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
import org.cakepowered.mod.world.CustomTeleporter;

import java.net.SocketAddress;

public class ApiPlayer extends ApiEntity implements Player {

    protected EntityPlayer player;

    public ApiPlayer(EntityPlayer player) {
        super(player);
        this.player = player;
    }

    @Override
    public void playSound(String sound, float volume, float pitch) {
        SoundEvent event = SoundEvent.REGISTRY.getObject(new ResourceLocation(sound));
        Packet packet = new SPacketSoundEffect(event, SoundCategory.BLOCKS, player.posX, player.posY, player.posZ, volume, pitch);
        ((EntityPlayerMP) player).connection.sendPacket(packet);
    }

    @Override
    public String getUserName() {
        return player.getName();
    }

    @Override
    public void sendMessage(String s) {
        player.addChatComponentMessage(new TextComponentString(s));
    }

    @Override
    public void sendLink(String link) {
        ITextComponent chat = new TextComponentString(link);
        Style style = new Style();
        style.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, TextFormating.toPlainString(link)));
        chat.setStyle(style);
        player.addChatMessage(chat);
    }

    @Override
    public void sendMessageWithLinks(String s) {
        ITextComponent toSend = new TextComponentString("");
        String[] message = s.split(" ");

        for (int i = 0; i < message.length; i++) {
            if (message[i].contains("http:") || message[i].contains("https:")) {
                ITextComponent chat = new TextComponentString(message[i]);
                Style style = new Style();
                style.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, TextFormating.toPlainString(message[i])));
                chat.setStyle(style);
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
        return o instanceof Player && getUniqueID().equals(((Player) o).getUniqueID());
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
        return ((EntityPlayerMP) player).interactionManager.getGameType().getID();
    }

    @Override
    public void setGameMode(int value) {
        GameType mode = GameType.getByID(value);
        player.setGameType(mode);
    }

    @Override
    public boolean isOP() {
        for (String s : CakeApiCore.getServer().getPlayerList().getOppedPlayerNames()) {
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
        ((EntityPlayerMP) player).connection.setPlayerLocation(loc.getX(), loc.getY(), loc.getZ(),
                loc.getYaw(), loc.getPitch());
        if (w.provider.getDimension() != loc.getDimension()) {
            teleportToDimension((EntityPlayerMP) player, loc.getDimension());
        }
    }

    private void teleportToDimension(EntityPlayerMP player, int dimensionId) {
        //esto evita un bug con la barra de experiencia
        player.addExperienceLevel(0);
        player.changeDimension(dimensionId);
        CakeApiCore.getServer().getPlayerList().transferPlayerToDimension(player, dimensionId, new CustomTeleporter(player.getServerWorld()));
//        transferPlayerToDimension(player, dimensionId, CakeApiCore.getServer().getPlayerList());
        //        MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(player, dimensionId, new CustomTeleporter(world));
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
        TitleUtils.sendTitle(((EntityPlayerMP) player).connection, player, t);
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

            NetHandlerPlayServer net = e.connection;

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
    public ItemStack getCurrentItem(PlayerHand hand) {
        return ForgeInterface.getItemStack(player.getHeldItem(EnumHand.values()[hand.ordinal()]));
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

        player.addPotionEffect(new PotionEffect(Potion.getPotionById(id), effectDuration, effectAmplifier, ambient, showParticles));
    }

    @Override
    public void clearActivePotions() {
        player.clearActivePotions();
    }

    @Override
    public SocketAddress getAddress() {
        try {
            return ((EntityPlayerMP) player).connection.getNetworkManager().getRemoteAddress();
        } catch (Exception e) {
            //ignored
            return null;
        }
    }
}
