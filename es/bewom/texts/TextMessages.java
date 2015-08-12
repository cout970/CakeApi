package es.bewom.texts;

import org.cakepowered.api.util.text.TextFormating;

public class TextMessages {
	
	public static final String NO_PERMISSIONS = TextFormating.RED + "No tienes permisos.";
	public static final String NOT_CONSOLE_COMPATIBLE = "Este comando no funciona en consola.";

	public static final String TP_SUCCESS = TextFormating.RED + "Teletransporte exitoso.";
	public static final String TP_EXPIRED = TextFormating.RED + "La solicitud ha expirado.";
	public static final String TP_NOT_FOUND = TextFormating.RED + "No hay ninguna solicitud.";
	public static final String TP_DENIED = TextFormating.RED + "Solicitud de teletransporte denegada.";
	public static final String TP_REQUEST_SENT = TextFormating.RED + "Se ha enviado una solicitud.";
	
	public static final String LOGIN_SUCCESS = TextFormating.RED + "Bienvenido a " + TextFormating.GOLD + "BEWOM" + TextFormating.RED + ".";
	
	public static final String WORLD_NOT_FOUND = TextFormating.RED + "No se ha encontrado el mundo especificado.";
	
	public static final String BROADCAST = TextFormating.WHITE+"/"+
			TextFormating.DARK_RED +
			TextFormating.OBFUSCATED + "K" +
			TextFormating.WHITE +
			TextFormating.RESET + "/" +
			TextFormating.BOLD + TextFormating.DARK_RED + "WOM" +  
			TextFormating.RESET + TextFormating.WHITE + " < ";
	
}
