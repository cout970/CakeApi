package org.cakepowered.api.event;

import org.cakepowered.api.util.Log;

public interface InitializationEvent extends StateChangeEvent {

	Log getLogger(String pluginId);
}
