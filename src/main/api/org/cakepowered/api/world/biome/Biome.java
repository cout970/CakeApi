package org.cakepowered.api.world.biome;

import org.cakepowered.api.util.Color;

/**
 * Created by cout970 on 17/06/2016.
 */
public interface Biome {

    int getID();

    String getName();

    Color getColor();

    float getTemperature();

    float getBaseHeight();

    float getVariationHeight();
}
