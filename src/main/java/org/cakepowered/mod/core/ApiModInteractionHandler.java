package org.cakepowered.mod.core;

import net.minecraft.nbt.NBTBase;
import org.cakepowered.api.core.ModInteractionHandler;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.mod.util.ForgeInterface;

/**
 * Created by cout970 on 12/12/2015.
 */
public class ApiModInteractionHandler implements ModInteractionHandler {

    public static final ApiModInteractionHandler INSTANCE = new ApiModInteractionHandler();

    @Override
    public NBTCompound toNBTCompound(Object o) {
        return (NBTCompound) ForgeInterface.getNBT((NBTBase) o);
    }

    @Override
    public Item toItem(Object o) {
        return ForgeInterface.getItem((net.minecraft.item.Item) o);
    }

    @Override
    public Block toBlock(Object o) {
        return ForgeInterface.getBlock((net.minecraft.block.Block) o);
    }

    @Override
    public Entity toEntity(Object o) {
        return ForgeInterface.getEntity((net.minecraft.entity.Entity) o);
    }
}
