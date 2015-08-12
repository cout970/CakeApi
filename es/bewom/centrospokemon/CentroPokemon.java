package es.bewom.centrospokemon;

import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Vector3d;
import org.cakepowered.api.util.Vector3i;

public class CentroPokemon {
	
	public static String DEFAULT_WORLD = "world";
	
	public int x, y, z;
	public String world;
	
	public CentroPokemon(int x, int y, int z, String world) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	public CentroPokemon(PreciseLocation location) {
		Vector3i vec = location.getPosition().toVector3i();
		this.x = vec.getX();
		this.y = vec.getY();
		this.z = vec.getZ();
		this.world = location.getWorld().getName();
	}

	public boolean isEqualTo(PreciseLocation location) {
		if(location.getPosition().toVector3i().equals(new Vector3i(x, y, z)) && world == location.getWorld().getName()) {
			return true;
		}
		return false;
	}
	
	public boolean isNear(PreciseLocation location) {
		if(!world.equals(location.getWorld().getName())) return false;
		if(location.getPosition().distance(getVector()) < 1) {
			return true;
		}
		return false;
	}
	
	public int distance(Vector3d vector3d) {
		Vector3i pos = new Vector3i(x, y, z);
		Vector3i loc = new Vector3i(vector3d.getX(), vector3d.getY(), vector3d.getZ());
		return (int) Math.abs(pos.toVector3d().distance(loc.toVector3d()));
	}
	
	public String getWorld() {
		return world;
	}
	
	public Vector3d getVector() {
		return new Vector3d(x, y, z);
	}

}
