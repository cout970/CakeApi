package org.cakepowered.mod.world;


import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.cakepowered.mod.CakeApiCore;

public class FlatWorldProvider extends WorldProvider {

    public WorldType type = WorldType.FLAT;

    @Override
    protected void createBiomeProvider() {
        this.biomeProvider = type.getBiomeProvider(worldObj);
    }

    @Override
    public DimensionType getDimensionType() {
        return ApiWorldManager.flatWorld;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return type.getChunkGenerator(worldObj, worldObj.getWorldInfo().getGeneratorOptions());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return this.type.getCloudHeight();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return true;
    }

    @Override
    public int getAverageGroundLevel() {
        return this.type.getMinimumSpawnHeight(this.worldObj);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public double getVoidFogYFactor() {
        return this.type.voidFadeMagnitude();
    }

    @Override
    public String getWelcomeMessage() {
        return "Loading dimension";
    }

    @Override
    public String getDepartMessage() {
        return "Leaving dimension";
    }

    @Override
    public BlockPos getRandomizedSpawnPoint() {
        BlockPos ret = this.worldObj.getSpawnPoint();

        boolean isAdventure = worldObj.getWorldInfo().getGameType() == GameType.ADVENTURE;
        int spawnFuzz = type.getSpawnFuzz((WorldServer) worldObj, CakeApiCore.getServer());
        int border = MathHelper.floor_double(worldObj.getWorldBorder().getClosestDistance(ret.getX(), ret.getZ()));
        if (border < spawnFuzz)
            spawnFuzz = border;
        if (spawnFuzz < 1)
            spawnFuzz = 1;
        int spawnFuzzHalf = spawnFuzz / 2;

        if (!getHasNoSky() && !isAdventure) {
            ret = worldObj.getTopSolidOrLiquidBlock(ret.add(worldObj.rand.nextInt(spawnFuzzHalf) - spawnFuzz, 0,
                    worldObj.rand.nextInt(spawnFuzzHalf) - spawnFuzz));
        }

        return ret;
    }
}
