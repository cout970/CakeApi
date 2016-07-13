package org.cakepowered.api.world.biome;

import org.cakepowered.api.core.References;

/**
 * Created by cout970 on 17/06/2016.
 */
public enum Biomes {

    OCEAN(0),
    PLAINS(1),
    DESERT(2),
    EXTREME_HILLS(3),
    FOREST(4),
    TAIGA(5),
    SWAMPLAND(6),
    RIVER(7),
    HELL(8),
    SKY(9),
    FROZEN_OCEAN(10),
    FROZEN_RIVER(11),
    ICE_PLAINS(12),
    ICE_MOUNTAINS(13),
    MUSHROOM_ISLAND(14),
    MUSHROOM_ISLAND_SHORE(15),
    BEACH(16),
    DESERT_HILLS(17),
    FOREST_HILLS(18),
    TAIGA_HILLS(19),
    EXTREME_HILLS_EDGE(20),
    JUNGLE(21),
    JUNGLE_HILLS(22),
    JUNGLE_EDGE(23),
    DEEP_OCEAN(24),
    STONE_BEACH(25),
    COLD_BEACH(26),
    BIRCH_FOREST(27),
    BIRCH_FOREST_HILLS(28),
    ROOFED_FOREST(29),
    COLD_TAIGA(30),
    COLD_TAIGA_HILLS(31),
    MEGA_TAIGA(32),
    MEGA_TAIGA_HILLS(33),
    EXTREME_HILLS_PLUS(34),
    SAVANNA(35),
    SAVANNA_PLATEAU(36),
    MESA(37),
    MESA_PLATEAU_F(38),
    MESA_PLATEAU(39);

    private int id;

    Biomes(int id) {
        this.id = id;
    }

    public Biome getBiome(){
        return References.GAME.getWorldManager().getBiome(id);
    }
}
