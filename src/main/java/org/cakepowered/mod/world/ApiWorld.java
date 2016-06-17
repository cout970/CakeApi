package org.cakepowered.mod.world;

import java.util.ArrayList;
import java.util.List;

import org.cakepowered.api.base.Entity;
import org.cakepowered.api.base.Server;
import org.cakepowered.api.block.Block;
import org.cakepowered.api.block.BlockState;
import org.cakepowered.api.scoreboard.Scoreboard;
import org.cakepowered.api.tileentity.TileEntity;
import org.cakepowered.api.util.FireworkProperties;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.Vector3i;
import org.cakepowered.api.world.Difficulties;
import org.cakepowered.mod.CakeApiCore;
import org.cakepowered.mod.scoreboard.ApiScoreboard;
import org.cakepowered.mod.util.FireworkHelper;
import org.cakepowered.mod.util.ForgeInterface;
import org.cakepowered.mod.util.IImplementation;
import org.cakepowered.mod.util.PluginInterface;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ApiWorld implements org.cakepowered.api.world.World, IImplementation<World> {

	public World world;

	public ApiWorld(net.minecraft.world.World world) {

		this.world = world;
	}

	@Override
	public int getDifficulty() {
		switch (world.getDifficulty()) {
		case EASY:
			return Difficulties.EASY;
		case NORMAL:
			return Difficulties.NORMAL;
		case HARD:
			return Difficulties.HARD;
		case PEACEFUL:
			return Difficulties.PEACEFUL;
		default:
			return Difficulties.NORMAL;
		}
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
	public Location getSpawnLocation() {
		return new Location(world.provider.getDimensionId(), world.getSpawnPoint().getX(), world.getSpawnPoint().getY(),
				world.getSpawnPoint().getZ());
	}

	@Override
	public Block getBlock(Vector3i pos) {
		IBlockState state = world.getBlockState(PluginInterface.getBlockPos(pos));
		return ForgeInterface.getBlock(state.getBlock());
	}

	@Override
	public TileEntity getTileEntity(Vector3i position) {
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
	public boolean isAirBlock(Vector3i pos) {
		return world.isAirBlock(PluginInterface.getBlockPos(pos));
	}

	@Override
	public boolean isBlockLoaded(Vector3i pos) {
		return world.isBlockLoaded(PluginInterface.getBlockPos(pos));
	}

	@Override
	public boolean setBlockToAir(Vector3i pos) {
		return world.setBlockToAir(PluginInterface.getBlockPos(pos));
	}

	@Override
	public boolean setBlockState(Vector3i pos, BlockState state) {
		return world.setBlockState(PluginInterface.getBlockPos(pos), PluginInterface.getBlockState(state));
	}

	@Override
	public BlockState getBlockState(Vector3i pos) {
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
	public boolean canBlockSeeSky(int x, int y, int z){
		if(world.canSeeSky(new BlockPos(x, y, z))){
			return true;
		}
		return false;
	}

	@Override
	public boolean spawnFirework(Vector3d pos, FireworkProperties prop) {
		net.minecraft.item.ItemStack stack = new net.minecraft.item.ItemStack(Items.firework_charge);
		FireworkHelper.generateFirework(stack, prop);
		EntityFireworkRocket entity = new EntityFireworkRocket(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		return world.spawnEntityInWorld(entity);
	}

	@Override
	public void loadChunk(int x, int z) {
		world.getChunkProvider().provideChunk(x, z);
	}
}
