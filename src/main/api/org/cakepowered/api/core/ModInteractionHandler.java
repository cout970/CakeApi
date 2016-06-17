package org.cakepowered.api.core;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompound;

/**
 * Created by cout970 on 12/12/2015.
 */
public interface ModInteractionHandler {

    NBTCompound toNBTCompound(Object o);

    Item toItem(Object o);

    Block toBlock(Object o);

    Entity toEntity(Object o);
}
