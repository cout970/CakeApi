package org.cakepowered.mod.world.biome;

import org.cakepowered.api.util.Color;
import org.cakepowered.api.world.biome.Biome;
import org.cakepowered.mod.util.IImplementation;

/**
 * Created by cout970 on 17/06/2016.
 */
public class ApiBiome implements Biome, IImplementation<net.minecraft.world.biome.Biome> {

    private net.minecraft.world.biome.Biome biome;

    public ApiBiome(net.minecraft.world.biome.Biome biome) {
        this.biome = biome;
    }

    @Override
    public int getID() {
        return net.minecraft.world.biome.Biome.getIdForBiome(biome);
    }

    @Override
    public String getName() {
        return biome.getBiomeName();
    }

    @Override
    public Color getColor() {
        return new Color(0);
    }

    @Override
    public float getTemperature() {
        return biome.getTemperature();
    }

    @Override
    public float getBaseHeight() {
        return biome.getBaseHeight();
    }

    @Override
    public float getVariationHeight() {
        return biome.getHeightVariation();
    }

    @Override
    public net.minecraft.world.biome.Biome getMcObject() {
        return biome;
    }
}
