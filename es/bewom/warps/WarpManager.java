package es.bewom.warps;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.soap.Text;

import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.PlayerInteractEvent;
import org.cakepowered.api.event.PlayerInteractEvent.ClickAction;
import org.cakepowered.api.util.Location;
import org.cakepowered.api.world.tileentity.TileEntities;
import org.cakepowered.api.world.tileentity.TileEntity;
import org.cakepowered.api.world.tileentity.TileEntitySign;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.bewom.BewomByte;

public class WarpManager {
	
	private static BewomByte plugin;

	static ArrayList<Warp> warps = new ArrayList<>();

	/**
	 * Adds a warp to the list of available warps.
	 * 
	 * @param warp
	 * @return Absent optional in case there was no error.
	 * @return {@link Optional} of type string with the error message in case
	 *         there was an error.
	 */
	public static String addWarp(Warp warp) {

		for (Warp w : warps) {
			if (w.getName().equalsIgnoreCase(warp.getName()))
				return "Name already in use.";
			if (w.isPositionSame(warp.getX(), warp.getY(), warp.getZ()))
				return "Position is already a warp.";
		}

		warps.add(warp);

		return null;

	}

	/**
	 * Deletes a warp from the current list of available warps.
	 * 
	 * @param warp
	 * @return Absent optional in case there was no error.
	 * @return {@link Optional} of type string with the error message in case
	 *         there was an error.
	 */
	public static String deleteWarp(String name) {

		for (Warp warp : warps) {
			if (warp.getName().equalsIgnoreCase(name)) {
				warps.remove(warp);
				return null;
			}
		}

		return "Warp not found.";

	}

	/**
	 * Returns the warp with the given name. The {@link Optional} will contain
	 * the found {@link Warp}. In case there was no {@link Warp} found this will
	 * return an Absent {@link Optional}.
	 * 
	 * @param name
	 * @return An {@link Optional} of type warp.
	 */
	public static Warp getWarpByName(String name) {

		for (Warp warp : warps) {
			if (warp.getName().equalsIgnoreCase(name)) {
				return warp;
			}
		}

		return null;

	}

	/**
	 * Returns a String with all the warp names available.
	 * 
	 * @return String with the list of names or error message in case of error.
	 */
	public static String getAllWarpNames() {

		if (warps.isEmpty())
			return "There are no warps.";

		String names = "Warps: ";

		for (int i = 0; i < warps.size(); i++) {
			names += warps.get(i).getName();
			if (i != warps.size() - 1) {
				names += ", ";
			} else {
				names += ".";
			}
		}

		return names;
	}

	/**
	 * Save the warps to the json file.
	 */
	public static void save() {

		try {

			Warp[] warpsArray = new Warp[warps.size()];
			for (int i = 0; i < warps.size(); i++) {
				warpsArray[i] = warps.get(i);
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(warpsArray);

			FileWriter writer = new FileWriter("bewom/warps.json");
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Load warps from the json file.
	 */
	public static void load() {

		try {

			File folder = new File("bewom");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			File file = new File("bewom/warps.json");
			if (!file.exists()) {
				file.createNewFile();
				return;
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Warp[] warpsArray = gson.fromJson(new FileReader("bewom/warps.json"),
					Warp[].class);

			ArrayList<Warp> warpsList = new ArrayList<>();
			if(!warpsList.isEmpty()) {
				for (Warp warp : warpsArray) {
					warpsList.add(warp);
				}
			}

			WarpManager.warps = warpsList;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Event triggered when a sign is created/changed.
	 * @param event
	 */
//	SignChangeEvent no existe
//	@Subscribe
//	public void onWarpSignCreated(SignChangeEvent event) {
//		
//		SignData newData = event.getNewData();
//		
//		if(Texts.toPlain(newData.lines().get(0)).equalsIgnoreCase("[WARP]")) {
//			
//			List<Text> lines = newData.lines().getAll();
//			String warpName = Texts.toPlain(lines.get(1));
//			Optional<Warp> warpOp = WarpManager.getWarpByName(warpName);
//			
//			if(warpOp.isPresent()) {
//				lines.set(0, Texts.of(TextColors.GREEN, "[WARP]"));
//				lines.set(1, Texts.of(TextColors.BLACK, warpName.toLowerCase()));
//				lines.set(2, Texts.of(""));
//				lines.set(3, Texts.of(""));
//			} else {
//				lines.set(0, Texts.of(TextColors.DARK_RED, "[WARP]"));
//				lines.set(1, Texts.of(TextColors.BLACK, "ERROR"));
//				lines.set(2, Texts.of(TextColors.BLACK, "Not found."));
//				lines.set(3, Texts.of(""));
//			}
//			
//			for(int i = 0; i < 4; i++) {
//				newData.lines().set(i, lines.get(i));
//			}
//			
//			event.setNewData(newData);
//			
//		}
//		
//	}
	
	/**
	 * Event triggered when a sign is clicked.
	 * @param event
	 */
	@EventSuscribe
	public void onSignClicked(PlayerInteractEvent event) {
		
		if(event.getAction() != ClickAction.RIGHT_CLICK_BLOCK)
			return;

		Location block = new Location(event.getWorld(), event.getPosition());
		
		if(block.getTileEntity() == null)
			return;
		
		if(!(block.getTileEntity().isEquivalentTo(TileEntities.SIGN))) {
			return;
		}
		
		TileEntity signEntity = block.getTileEntity();
		
		if(!(signEntity instanceof TileEntitySign)){
			return;
		}
		String line = ((TileEntitySign)signEntity).getTextLine(0);
		
		if(!line.equals("[WARP]")) {
			return;
		}
		
		line = ((TileEntitySign)signEntity).getTextLine(1);
		
		String command = "warp " + line;
		plugin.getGame().getCommandDispacher().executeCommand(event.getPlayer().getCommandSender(), command);
		
	}
	
	/**
	 * Used by the main class {@link BewomByte} to initialize plugin in this class.
	 * @param plugin
	 */
	public static void init(BewomByte plugin) {
		WarpManager.plugin = plugin;
	}

}
