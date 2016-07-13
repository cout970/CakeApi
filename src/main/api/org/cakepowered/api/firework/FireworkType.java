package org.cakepowered.api.firework;

/**
 * Created by cout970 on 17/06/2016.
 */
public enum FireworkType {
    SMALL(0), LARGE(1), STAR(2), CREEPER(3), BURST(4);

    private byte id;

    FireworkType(int id) {
        this.id = (byte) id;
    }

    public byte getId() {
        return id;
    }
}
