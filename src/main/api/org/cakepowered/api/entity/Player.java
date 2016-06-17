package org.cakepowered.api.entity;

import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.inventory.PlayerInventory;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.DirectionYaw;
import org.cakepowered.api.util.EntityLocation;
import org.cakepowered.api.title.Title;
import org.cakepowered.api.util.Vector3;

public interface Player extends Entity {

	String getUserName();

	void sendMessage(String s);

	void sendLink(String link);

	void sendTitle(Title t);

	void setSpawnLocation(Vector3 vec);

	void moveToWorld(EntityLocation loc);

	void setLocation(EntityLocation loc);

	void setPitchAndYaw(float p, float y);

	EntityLocation getLocation();

	DirectionYaw getDirection();

	int getGameMode();

	void setGameMode(int value);

	boolean isOP();

	Team getTeam();

	Scoreboard getScoreboard();

	void kick(String mes);

	PlayerInventory getPlayerInventory();

	Inventory getPlayerEnderChest();

	/**
	 * Returns the itemstack in the player inventory that is selected in the hotbar
	 */
	ItemStack getCurrentItem();

	/**
	 * Return the selected slot in the hotbar
	 */
	int getSelectedSlot();

	boolean isSneaking();

	void openGui(Inventory chest);

	void addPotionEffect(int id, int duration, int amplification, boolean ambient, boolean showParticles);

	void clearActivePotions();

	void playSound(String sound, float volume, float pitch);

	void sendMessageWithLinks(String s);

	void openGuiEnderChest(Inventory enderChest);

	void openGuiWorkBench();
}
