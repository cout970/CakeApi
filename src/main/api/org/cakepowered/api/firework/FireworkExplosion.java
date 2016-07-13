package org.cakepowered.api.firework;

import org.cakepowered.api.util.Color;

/**
 * Created by cout970 on 17/06/2016.
 */
public class FireworkExplosion {

    public FireworkType type;
    public Color[] colors;
    public Color[] fadeColors;
    public boolean trail;
    public boolean flicker;

    public FireworkExplosion(FireworkType type, Color[] colors, boolean trail, boolean flicker, Color... fadeColors) {
        this.type = type;
        this.colors = colors;
        this.trail = trail;
        this.flicker = flicker;
        this.fadeColors = fadeColors;
    }

}
