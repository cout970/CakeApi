package es.bewom.p;

import org.cakepowered.api.util.Location;
import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.world.World;

public class Door {
	
	private World[] world = {null, null};
	private double[] x = new double[2];
	private double[] y = new double[2];
	private double[] z = new double[2];
	
	private int pos;
	
	public World[] getWorld() {
		return world;
	}
	public double[] getX() {
		return x;
	}
	public double[] getY() {
		return y;
	}
	public double[] getZ() {
		return z;
	}
	public PreciseLocation getLocation(){
		return new PreciseLocation(world[pos], x[pos] + 0.5, y[pos], z[pos] + 0.5);
	}
	
	public Door setDoorPos(int pos){
		this.pos = pos;
		return this;
	}
	public Door setWorld(World world) {
		this.world[pos] = world;
		return this;
	}
	public Door setX(double x) {
		this.x[pos] = x;
		return this;
	}
	public Door setY(double y) {
		this.y[pos] = y;
		return this;
	}
	public Door setZ(double z) {
		this.z[pos] = z;
		return this;
	}
	public Door setLocation(double x, double y, double z){
		this.x[pos] = x;
		this.y[pos] = y;
		this.z[pos] = z;
		return this;
	}
	
	public boolean isSelected(double x, double y, double z, World world){
		if(x == this.x[pos] && (y == this.y[pos] || y == this.y[pos] + 1) && z == this.z[pos] && world.equals(this.world[pos])){
			return true;									
		}
		return false;
	}

}
