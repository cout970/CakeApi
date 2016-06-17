package org.cakepowered.api.world;

public enum WorldDifficulty {

    PEACEFUL(0),
    EASY(1),
    NORMAL(2),
    HARD(3);

    private int level;

    WorldDifficulty(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
