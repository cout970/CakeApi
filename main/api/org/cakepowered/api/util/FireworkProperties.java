package org.cakepowered.api.util;

public class FireworkProperties {

	public byte flight;
	public FireworkExplosion[] explosions;

	public FireworkProperties(byte flight, FireworkExplosion... explosions) {
		this.flight = flight;
		this.explosions = explosions;
	}

	public static class FireworkExplosion {

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

	public enum FireworkType {
		SMALL(0), LARGE(1), STAR(2), CREEPER(3), BURST(4);

		private byte id;

		private FireworkType(int id) {
			this.id = (byte) id;
		}

		public byte getId() {
			return id;
		}
	}
}
