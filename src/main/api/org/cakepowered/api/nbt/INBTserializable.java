package org.cakepowered.api.nbt;

/**
 * Created by cout970 on 17/06/2016.
 */
public interface INBTserializable {

    NBTCompound serialize();

    void deserialize(NBTCompound nbt);
}
