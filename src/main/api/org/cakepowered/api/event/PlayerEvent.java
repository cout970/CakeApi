package org.cakepowered.api.event;

import org.cakepowered.api.entity.Player;

public interface PlayerEvent extends Event {

	Player getPlayer();
}
