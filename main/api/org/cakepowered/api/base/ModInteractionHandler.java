package org.cakepowered.api.base;

import org.cakepowered.api.block.Block;
import org.cakepowered.api.item.Item;
import org.cakepowered.api.nbt.NBTCompund;

/**
 * Created by cout970 on 12/12/2015.
 */
public interface ModInteractionHandler {

    NBTCompund toNBTCompound(Object o);

    Item toIItem(Object o);

    Block toBlock(Object o);
}
