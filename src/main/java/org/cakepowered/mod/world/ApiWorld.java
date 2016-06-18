package org.cakepowered.mod.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.core.Server;
import org.cakepowered.api.entity.Entity;
import org.cakepowered.api.firework.FireworkProperties;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.util.BlockLocation;
import org.cakepowered.api.util.Vector3;
import org.cakepowered.api.world.WorldDifficulty;
import org.cakepowered.api.world.biome.Biome;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.scoreboard.ApiScoreboard;
import org.cakepowered.mod.util.FireworkHelper;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

import java.util.ArrayList;
import java.util.List;

public class ApiWorld implements org.cakepowered.api.world.World, IImplementation<World> {

    public World world;

    public ApiWorld(net.minecraft.world.World world) {
        this.world = world;
    }

    @Override
    public WorldDifficulty getDifficulty() {
        switch (world.getDifficulty()) {
            case EASY:
                return WorldDifficulty.EASY;
            case NORMAL:
                return WorldDifficulty.NORMAL;
            case HARD:
                return WorldDifficulty.HARD;
            case PEACEFUL:
                return WorldDifficulty.PEACEFUL;
            default:
                return WorldDifficulty.NORMAL;
        }
    }

    @Override
    public Biome getBiome(int x, int z) {
        return ForgeInterface.getBiome(world.getBiomeGenForCoords(new BlockPos(x, 0, z)));
    }

    @Override
    public void setBiome(Biome biome, int x, int z) {
        Chunk chunk = world.getChunkFromBlockCoords(new BlockPos(x, 0, z));
        int i = x & 15;
        int j = z & 15;
        chunk.getBiomeArray()[j << 4 | i] = (byte) biome.getID();
    }

    @Override
    public String getName() {
        return world.getWorldInfo().getWorldName();
    }

    @Override
    public int getDimension() {
        return world.provider.getDimensionId();
    }

    @Override
    public Scoreboard getScoreboard() {
        return new ApiScoreboard((ServerScoreboard) this.world.getScoreboard());
    }

    @Override
    public BlockLocation getSpawnLocation() {
        return new BlockLocation(world.provider.getDimensionId(), world.getSpawnPoint().getX(), world.getSpawnPoint().getY(),
                world.getSpawnPoint().getZ());
    }

    @Override
    public Block getBlock(Vector3 pos) {
        IBlockState state = world.getBlockState(PluginInterface.getBlockPos(pos));
        return ForgeInterface.getBlock(state.getBlock());
    }

    @Override
    public TileEntity getTileEntity(Vector3 position) {
        return ForgeInterface.getTileEntity(world.getTileEntity(PluginInterface.getBlockPos(position)));
    }

    @Override
    public List<Entity> getEntities() {
        List<Entity> list = new ArrayList<Entity>();
        for (Object e : world.getLoadedEntityList()) {
            if (e instanceof net.minecraft.entity.Entity) {
                list.add(ForgeInterface.getEntity((net.minecraft.entity.Entity) e));
            }
        }
        return list;
    }

    @Override
    public World getMcObject() {
        return world;
    }

    @Override
    public boolean isAirBlock(Vector3 pos) {
        return world.isAirBlock(PluginInterface.getBlockPos(pos));
    }

    @Override
    public boolean isBlockLoaded(Vector3 pos) {
        return world.isBlockLoaded(PluginInterface.getBlockPos(pos));
    }

    @Override
    public boolean setBlockToAir(Vector3 pos) {
        return world.setBlockToAir(PluginInterface.getBlockPos(pos));
    }

    @Override
    public boolean setBlockState(Vector3 pos, BlockState state) {
        return world.setBlockState(PluginInterface.getBlockPos(pos), PluginInterface.getBlockState(state));
    }

    @Override
    public boolean setBlockState(Vector3 pos, BlockState state, int flags) {
        return world.setBlockState(PluginInterface.getBlockPos(pos), PluginInterface.getBlockState(state), flags);
    }

    @Override
    public BlockState getBlockState(Vector3 pos) {
        return ForgeInterface.getBlockState(world.getBlockState(PluginInterface.getBlockPos(pos)));
    }

    @Override
    public boolean isDaytime() {
        return world.isDaytime();
    }

    @Override
    public void playSoundAtEntity(Entity entity, String soundName, float volume, float pitch) {
        world.playSoundAtEntity(PluginInterface.getEntity(entity), soundName, volume, pitch);
    }

    @Override
    public void playSoundEffect(double x, double y, double z, String soundName, float volume, float pitch) {
        world.playSound(x, y, z, soundName, volume, pitch, false);
    }

    @Override
    public boolean spawnEntityInWorld(Entity entity) {
        return world.spawnEntityInWorld(PluginInterface.getEntity(entity));
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Entity> getEntitiesExcludingType(Entity type, int minX, int minY, int minZ, int maxX, int maxY,
                                                 int maxZ) {
        AxisAlignedBB aabb = AxisAlignedBB.fromBounds(minX, minY, minZ, maxX, maxY, maxZ);
        List list = world.getEntitiesWithinAABBExcludingEntity(PluginInterface.getEntity(type), aabb);
        List<Entity> ret = new ArrayList<Entity>(list.size());
        for (Object o : list) {
            if (o instanceof EntityPlayer) {
                ret.add(ForgeInterface.getPlayer((EntityPlayer) o));
            } else if (o instanceof net.minecraft.entity.Entity) {
                ret.add(ForgeInterface.getEntity((net.minecraft.entity.Entity) o));
            }
        }
        return ret;
    }

    @Override
    public void setWorldTime(long time) {
        world.getWorldInfo().setWorldTime(time);
    }

    @Override
    public Server getServer() {
        return CakeApiCore.server;
    }

    @Override
    public boolean canBlockSeeSky(int x, int y, int z) {
        return world.canSeeSky(new BlockPos(x, y, z));
    }

    @Override
    public boolean spawnFirework(Vector3 pos, FireworkProperties prop) {
        net.minecraft.item.ItemStack stack = new net.minecraft.item.ItemStack(Items.firework_charge);
        FireworkHelper.generateFirework(stack, prop);
        EntityFireworkRocket entity = new EntityFireworkRocket(world, pos.getXd(), pos.getYd(), pos.getZd(), stack);
        return world.spawnEntityInWorld(entity);
    }

    @Override
    public void loadChunk(int x, int z) {
        world.getChunkProvider().provideChunk(x, z);
    }
}
