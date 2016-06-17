package org.cakepowered.api.util;

public enum DirectionYaw {

    NORTH(0, 180),
    SOUTH(1, 0),
    WEST(2, 90),
    EAST(3, 270);

    private static final int OPOSITES[] = {1, 0, 3, 2};
    int index;
    float angle;

    DirectionYaw(int index, float angle) {
        this.index = index;
        this.angle = angle;
    }

    public int getIndex() {
        return index;
    }

    public float getAngle() {
        return angle;
    }

    public DirectionYaw getOpposite(){
        return DirectionYaw.values()[OPOSITES[index]];
    }
}
