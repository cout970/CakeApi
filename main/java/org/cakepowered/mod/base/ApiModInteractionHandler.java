package org.cakepowered.mod.base;

import net.minecraft.nbt.NBTBase;
import org.cakepowered.api.base.ModInteractionHandler;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompund;
import org.cakepowered.mod.util.ForgeInterface;

/**
 * Created by cout970 on 12/12/2015.
 */
public class ApiModInteractionHandler implements ModInteractionHandler {

    public static final ApiModInteractionHandler INSTANCE = new ApiModInteractionHandler();

    @Override
    public NBTCompund toNBTCompound(Object o) {
        return (NBTCompund) ForgeInterface.getNBT((NBTBase) o);
    }

    @Override
    public Item toIItem(Object o) {
        return ForgeInterface.getItem((net.minecraft.item.Item) o);
    }

    @Override
    public Block toBlock(Object o) {
        return ForgeInterface.getBlock((net.minecraft.block.Block) o);
    }
}
