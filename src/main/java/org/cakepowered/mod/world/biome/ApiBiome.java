package org.cakepowered.mod.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import org.cakepowered.api.util.Color;
import org.cakepowered.api.world.biome.Biome;
import org.cakepowered.mod.util.IImplementation;

/**
 * Created by cout970 on 17/06/2016.
 */
public class ApiBiome implements Biome, IImplementation<BiomeGenBase> {

    private BiomeGenBase biome;

    public ApiBiome(BiomeGenBase biome) {
        this.biome = biome;
    }

    @Override
    public int getID() {
        return biome.biomeID;
    }

    @Override
    public String getName() {
        return biome.biomeName;
    }

    @Override
    public Color getColor() {
        return new Color(biome.color);
    }

    @Override
    public float getTemperature() {
        return biome.temperature;
    }

    @Override
    public float getBaseHeight() {
        return biome.minHeight;
    }

    @Override
    public float getVariationHeight() {
        return biome.maxHeight;
    }

    @Override
    public BiomeGenBase getMcObject() {
        return biome;
    }
}
