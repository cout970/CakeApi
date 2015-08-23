package org.cakepowered.api.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;

public class SurfaceWorldProvider extends WorldProvider{

	public WorldType type = WorldType.DEFAULT;

	@Override
	public String getDimensionName() {
		return "DIM"+getDimensionId();
	}

	@Override
    public String getInternalNameSuffix()
    {
        return "";
    }
	
	public long getSeed(){
		return ApiWorldManager.seeds.get(getDimensionId());
	}
	
	@Override
	public IChunkProvider createChunkGenerator(){
		return new net.minecraft.world.gen.ChunkProviderGenerate(worldObj, getSeed(), worldObj.getWorldInfo().isMapFeaturesEnabled(), worldObj.getWorldInfo().getGeneratorOptions());
	}
}
