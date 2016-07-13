package org.cakepowered.mod.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import org.cakepowered.api.entity.Player;
import org.cakepowered.api.inventory.ItemStack;
import org.cakepowered.api.inventory.PlayerInventory;
import org.cakepowered.api.item.Item;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.PluginInterface;

public class ApiPlayerInventory extends ApiInventory implements PlayerInventory {

    public InventoryPlayer player;

    public ApiPlayerInventory(InventoryPlayer inventory) {
        super(inventory);
        player = inventory;
    }

    @Override
    public Player getPlayer() {
        return ForgeInterface.getPlayer(player.player);
    }

    @Override
    public int getFirstEmptySlot() {
        return player.getFirstEmptyStack();
    }

    @Override
    public boolean consumeInventoryItem(Item item) {
        return consumeInventoryItem(PluginInterface.getItem(item));
    }

    //readded
    private int getInventorySlotContainItem(net.minecraft.item.Item itemIn) {
        for (int i = 0; i < player.mainInventory.length; ++i) {
            if (player.mainInventory[i] != null && player.mainInventory[i].getItem() == itemIn) {
                return i;
            }
        }

        return -1;
    }

    public boolean consumeInventoryItem(net.minecraft.item.Item itemIn) {
        int i = getInventorySlotContainItem(itemIn);

        if (i < 0) {
            return false;
        } else {
            if (--player.mainInventory[i].stackSize <= 0) {
                player.mainInventory[i] = null;
            }
            return true;
        }
    }

    public boolean hasItem(net.minecraft.item.Item itemIn) {
        int i = this.getInventorySlotContainItem(itemIn);
        return i >= 0;
    }

    //readded

    @Override
    public void consumeInventoryItemStack(ItemStack item) {
        player.deleteStack(PluginInterface.getItemStack(item));
    }

    @Override
    public boolean hasItem(Item item) {
        return hasItem(PluginInterface.getItem(item));
    }

    @Override
    public boolean addItemStackToInventory(ItemStack stack) {
        return player.addItemStackToInventory(((ApiItemStack) stack).stack);
    }

    @Override
    public ItemStack armorItemInSlot(int slot) {
        return ForgeInterface.getItemStack(player.armorItemInSlot(slot));
    }

    @Override
    public void dropAllItems() {
        player.dropAllItems();
    }

    @Override
    public boolean hasItemStack(ItemStack stack) {
        return player.hasItemStack(PluginInterface.getItemStack(stack));
    }
}
