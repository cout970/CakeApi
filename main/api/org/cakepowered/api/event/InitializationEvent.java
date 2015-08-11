package org.cakepowered.api.event;

import org.cakepowered.api.base.Log;

public interface InitializationEvent extends StateChangeEvent{

	public Log getLogger(String pluginId);
}
