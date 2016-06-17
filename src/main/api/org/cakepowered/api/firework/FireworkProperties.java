package org.cakepowered.api.firework;

public class FireworkProperties {

	public byte flight;
	public FireworkExplosion[] explosions;

	public FireworkProperties(byte flight, FireworkExplosion... explosions) {
		this.flight = flight;
		this.explosions = explosions;
	}

}
