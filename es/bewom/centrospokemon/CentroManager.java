package es.bewom.centrospokemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.cakepowered.api.util.PreciseLocation;
import org.cakepowered.api.util.Vector3d;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.bewom.BewomByte;

public class CentroManager {
	
	public static ArrayList<CentroPokemon> centros = new ArrayList<>();
	
	public static String add(PreciseLocation location) {
		if(centros.size() > 0) {
			for(CentroPokemon centro : centros) {
				if(centro.isEqualTo(location)) {
					return "Location already used.";
				}
			}
		}
		centros.add(new CentroPokemon(location));
		return null;
	}
	
	public static String remove(PreciseLocation location) {
		if(centros.size() == 0) return "No hay Centros Pokemon establecidos.";
		for(CentroPokemon centro : centros) {
			if(centro.isNear(location)) {
				centros.remove(centro);
				return null;
			}
		}
		return "No hay un centro poquemon en su posicion actual.";
	}
	
	public static CentroPokemon getClosest(PreciseLocation location) {
		Vector3d vector3d = location.getPosition();
		if(centros.size() == 0) return null;
		CentroPokemon closest = centros.get(0);
		for(CentroPokemon centro : centros) {
			if(!centro.world.equals(location.getWorld().getName())){
				continue;
			}
			int dist1 = closest.distance(vector3d);
			int dist2 = centro.distance(vector3d);
			if(dist2 < dist1) {
				closest = centro;
			}
		}
		return closest;
	}
	
	/**
	 * Saves all {@link CentroPokemon} into a Json file.
	 */
	public static void save() {
		
		try {
		
			CentroPokemon[] centroArray = new CentroPokemon[centros.size()];
			for(int i = 0; i < centros.size(); i++) {
				centroArray[i] = centros.get(i);
			}
			
			File folder = new File("bewom");
			if(!folder.exists()) folder.mkdirs();
			
			File file = new File("bewom/centros_pokemon.json");
			if(!file.exists()) file.createNewFile();
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(centroArray);
			
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			
			writer.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Loads all {@link CentroPokemon} from a Json file.
	 */
	public static void load() {
		
		try {
		
			File folder = new File("bewom");
			if(!folder.exists()) folder.mkdirs();
			
			File file = new File("bewom/centros_pokemon.json");
			if(!file.exists()) file.createNewFile();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			CentroPokemon[] centroArray = gson.fromJson(reader, CentroPokemon[].class);
			
			centros.clear();
			
			if(centroArray != null){
				for(CentroPokemon centro : centroArray) {
					centros.add(centro);
				}			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void init(BewomByte plugin) {
		load();
	}	
}
