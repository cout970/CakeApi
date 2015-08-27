package org.cakepowered.api.implement;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.Player;
import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.inventory.PlayerInventory;
import org.cakepowered.api.scoreboard.ApiScoreboard;
import org.cakepowered.api.scoreboard.ApiTeam;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.DirectionYaw;
import org.cakepowered.api.util.ForgeInterface;
import org.cakepowered.api.util.PluginInterface;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Title;
import org.cakepowered.api.util.TitleUtils;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.text.TextFormating;
import org.cakepowered.api.world.CustomTeleporter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings.GameType;

public class ApiPlayer extends ApiEntity implements Player {

	protected EntityPlayer player;

	public ApiPlayer(EntityPlayer player) {
		super(player);
		this.player = player;
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
	public boolean equals(Object o) {
		if (o instanceof Player) {
			return getUniqueID().equals(((Player) o).getUniqueID());
		}
		return false;
	}

	@Override
	public void setSpawnLocation(Vector3d loc) {
		player.setSpawnPoint(PluginInterface.getBlockPos(loc), false);
	}

	@Override
	public void moveToWorld(PreciseLocation loc) {
		player.travelToDimension(loc.getDimension());
	}

	@Override
	public PreciseLocation getLocation() {
		return new PreciseLocation(getWorld().getDimension(), getPosition(), player.rotationYaw, player.rotationPitch);
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
		for (String s : ((ApiServer) CakeApiMod.server).server.getConfigurationManager().getOppedPlayerNames()) {
			if (getUserName().equals(s)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setLocation(PreciseLocation loc) {
		World w = player.getEntityWorld();
		if (w.provider.getDimensionId() != loc.getDimension()) {
			teleportToDimension(player, loc);
		}
		player.setSpawnPoint(PluginInterface.getBlockPos(loc.getPosition()), true);
		player.setPositionAndUpdate(loc.getX(), loc.getY(), loc.getZ());
		((EntityPlayerMP) player).playerNetServerHandler.setPlayerLocation(loc.getX(), loc.getY(), loc.getZ(),
				loc.getYaw(), loc.getPitch());
	}

	public static void teleportToDimension(EntityPlayer player, PreciseLocation loc) {
		int oldDimension = player.worldObj.provider.getDimensionId();
		EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
		WorldServer worldServer = MinecraftServer.getServer().worldServerForDimension(loc.getDimension());
		player.addExperienceLevel(0);
		MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(entityPlayerMP,
				loc.getDimension(), new CustomTeleporter(worldServer));
		if (oldDimension == 1) {
			player.setPositionAndUpdate(loc.getX(), loc.getY(), loc.getZ());
			worldServer.spawnEntityInWorld(player);
			worldServer.updateEntityWithOptionalForce(player, false);
		}
	}

	@Override
	public int getDirection() {
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
		return 0;
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
		if (t == null)
			return;
		TitleUtils.sendTitle(((EntityPlayerMP) player).playerNetServerHandler, player, t);
	}

	@Override
	public Team getTeam() {
		return new ApiTeam((ScorePlayerTeam) (player.getTeam()));
	}

	@Override
	public Scoreboard getScoreboard() {
		return new ApiScoreboard(player.getWorldScoreboard());
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
	public void kick(String mes) {
		if (mes == null)
			mes = "";
		((EntityPlayerMP) entity).playerNetServerHandler.kickPlayerFromServer(mes);
	}

	@Override
	public void setPitchAndYaw(float p, float y) {
		((EntityPlayerMP) player).playerNetServerHandler.setPlayerLocation(getLocation().getX(), getLocation().getY(),
				getLocation().getZ(), y, p);

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
}
