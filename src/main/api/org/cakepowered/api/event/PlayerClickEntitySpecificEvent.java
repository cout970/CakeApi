package org.cakepowered.api.event;

import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.util.Vector3;

/**
 * Created by cout970 on 13/07/2016.
 */
public interface PlayerClickEntitySpecificEvent {

    Entity getTarget();

    /**
     * Returns the local interaction position. This is a 3D vector, where (0, 0, 0) is centered exactly at the
     * center of the entity's bounding box at their feet. This means the X and Z values will be in the range
     * [-width / 2, width / 2] while Y values will be in the range [0, height]
     * @return The local position
     */
    Vector3 getLocalPos();
}
