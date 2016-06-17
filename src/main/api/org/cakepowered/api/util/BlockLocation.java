package org.cakepowered.api.util;

import org.cakepowered.api.core.References;
import org.cakepowered.api.nbt.INBTserializable;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.util.vector.Vector3i;
import org.cakepowered.api.world.World;

public final class BlockLocation implements INBTserializable {

    protected int dimension;
    protected Vector3i position;

    public BlockLocation() {
        dimension = 0;
        position = new Vector3i(0, 0, 0);
    }

    public BlockLocation(int d, int x, int y, int z) {
        this(d, new Vector3i(x, y, z));
    }

    public BlockLocation(int d, Vector3i pos) {
        dimension = d;
        pos = pos.copy();
    }

    public int getDimension() {
        return dimension;
    }

    public World getWorld() {
        return References.GAME.getWorldManager().getWorld(dimension);
    }

    public Vector3i getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public int getZ() {
        return position.getZ();
    }

    @Override
    public NBTCompound serialize() {
        NBTCompound nbt = References.GAME.getNBTFactory().newNBTCompound();
        nbt.setInteger("dimension", dimension);
        nbt.setInteger("x", getX());
        nbt.setInteger("y", getY());
        nbt.setInteger("z", getZ());
        return nbt;
    }

    @Override
    public void deserialize(NBTCompound nbt) {
        position.set(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
        dimension = nbt.getInteger("dimension");
    }
}
