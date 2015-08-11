package org.cakepowered.api.world;

public interface WorldCreationSettings {

	String getWorldName();
	boolean isEnabled();
	long getSeed();
	int getdimensionType();
	
}
