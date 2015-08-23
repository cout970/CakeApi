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
	
	@Override
	public IChunkProvider createChunkGenerator(){
		return new net.minecraft.world.gen.ChunkProviderGenerate(worldObj, ApiWorldManager.seeds.get(getDimensionId()), worldObj.getWorldInfo().isMapFeaturesEnabled(), worldObj.getWorldInfo().getGeneratorOptions());
	}
}
