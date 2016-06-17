package org.cakepowered.api.world;

public enum VanillaDimensions {

	NETHER(-1),
	OVERWORLD(0),
	END(1);

	private int id;

	VanillaDimensions(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
