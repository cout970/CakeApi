package org.cakepowered.api.util;

import org.cakepowered.api.core.References;
import org.cakepowered.api.nbt.INBTserializable;
import org.cakepowered.api.nbt.NBTCompound;
import org.cakepowered.api.util.vector.Vector3;
import org.cakepowered.api.world.World;

public final class BlockLocation implements INBTserializable {

    protected int dimension;
    protected Vector3 position;

    public BlockLocation() {
        dimension = 0;
        position = new Vector3(0, 0, 0);
    }

    public BlockLocation(int d, int x, int y, int z) {
        this(d, new Vector3(x, y, z));
    }

    public BlockLocation(int d, Vector3 pos) {
        dimension = d;
        position = pos;
    }

    public int getDimension() {
        return dimension;
    }

    public World getWorld() {
        return References.GAME.getWorldManager().getWorld(dimension);
    }

    public Vector3 getPosition() {
        return position;
    }

    public int getX() {
        return position.getXi();
    }

    public int getY() {
        return position.getYi();
    }

    public int getZ() {
        return position.getZi();
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
        position = new Vector3(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
        dimension = nbt.getInteger("dimension");
    }
}
