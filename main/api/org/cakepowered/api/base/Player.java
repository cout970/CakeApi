package org.cakepowered.api.base;

import org.cakepowered.api.inventory.Inventory;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.scoreboard.Team;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Title;
import org.cakepowered.api.util.Vector3d;

public interface Player extends Entity{

	public String getUserName();
	
	public void sendMessage(String s);
	
	public void sendLink(String link);
	
	public void sendTitle(Title t);
	
	public void setSpawnLocation(Vector3d vec);

	public void moveToWorld(PreciseLocation loc);
	
	public void setLocation(PreciseLocation loc);
	
	public void setPitchAndYaw(float p, float y);
	
	public PreciseLocation getLocation();
	
	public int getDirection();
	
	public int getGameMode();
	public void setGameMode(int value);
	
	public boolean isOP();
	
	public Team getTeam();
	
	public Scoreboard getScoreboard();
	
	public void kick(String mes);
	
	public Inventory getPlayerInventory();
	
	/**
	 * Returns the itemstack in the player inventory that is selected in the hotbar
	 */
	public ItemStack getCurrentItem();
	
	/**
	 * Return the selected slot in the hotbar
	 */
	public int getSelectedslot();
}
