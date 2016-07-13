package org.cakepowered.mod.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;

public class SurfaceWorldProvider extends WorldProvider {

	public WorldType type = WorldType.DEFAULT;

	@Override
	public String getWelcomeMessage() {
		return "Loading dimension";
	}

	@Override
	public String getDepartMessage() {
		return "Leaving dimension";
	}

	@Override
	public long getSeed() {
		return ApiWorldManager.seeds.get(getDimension());
	}

	@Override
	public DimensionType getDimensionType() {
		return ApiWorldManager.surfaceWorld;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return type.getChunkGenerator(worldObj, worldObj.getWorldInfo().getGeneratorOptions());
	}
}
