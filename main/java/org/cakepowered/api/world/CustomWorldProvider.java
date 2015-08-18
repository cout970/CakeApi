package org.cakepowered.api.world;

import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomWorldProvider extends WorldProvider{

	public WorldType type = WorldType.FLAT;
	public String genSettings = "";

	@Override
	public String getDimensionName() {
		return "DIM"+getDimensionId();
	}

	@Override
	public String getInternalNameSuffix() {
		return "_flat";
	}

	@Override
	protected void registerWorldChunkManager()
	{
		this.worldChunkMgr = type.getChunkManager(worldObj);
	}

	/**
	 * Returns a new chunk provider which generates chunks for this world
	 */
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return type.getChunkGenerator(worldObj, genSettings);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return this.type.getCloudHeight();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return true;
	}

	@Override
	public BlockPos getSpawnCoordinate()
	{
		return null;
	}

	@Override
	public int getAverageGroundLevel()
	{
		return this.type.getMinimumSpawnHeight(this.worldObj);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getVoidFogYFactor()
	{
		return this.type.voidFadeMagnitude();
	}

	@Override
	public BlockPos getRandomizedSpawnPoint()
	{
		BlockPos ret = this.worldObj.getSpawnPoint();

		boolean isAdventure = worldObj.getWorldInfo().getGameType() == WorldSettings.GameType.ADVENTURE;
		int spawnFuzz = type.getSpawnFuzz();
		int border = MathHelper.floor_double(worldObj.getWorldBorder().getClosestDistance(ret.getX(), ret.getZ()));
		if (border < spawnFuzz) spawnFuzz = border;
		if (spawnFuzz < 1) spawnFuzz = 1;
		int spawnFuzzHalf = spawnFuzz / 2;

		if (!getHasNoSky() && !isAdventure)
		{
			ret = worldObj.getTopSolidOrLiquidBlock(ret.add(worldObj.rand.nextInt(spawnFuzzHalf) - spawnFuzz, 0, worldObj.rand.nextInt(spawnFuzzHalf) - spawnFuzz));
		}

		return ret;
	}

}
