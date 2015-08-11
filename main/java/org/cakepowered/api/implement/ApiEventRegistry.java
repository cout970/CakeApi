package org.cakepowered.api.implement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.cakepowered.api.CakeApiMod;
import org.cakepowered.api.base.EventRegistry;
import org.cakepowered.api.event.Event;
import org.cakepowered.api.event.EventSuscribe;
import org.cakepowered.api.event.PlayerJoinEvent;
import org.cakepowered.api.events.ApiPlayerJoinEvent;
import org.cakepowered.api.util.MethodCaller;

public class ApiEventRegistry implements EventRegistry{

	public static ApiEventRegistry INSTANCE = new ApiEventRegistry();

	public static HashMap<Class<?>, ArrayList<MethodCaller>> listeners = new HashMap<Class<?>, ArrayList<MethodCaller>>();

	@Override
	public boolean postEvent(Event e) {
		ArrayList<MethodCaller> methods = null;
		for(Class<?> clazz : listeners.keySet()){
			if(clazz.isInstance(e)){
				methods = listeners.get(clazz);
				break;
			}
		}
		if(methods != null){
			for(MethodCaller m : methods){
				m.call(e);
			}
		}
		return !e.isEventCanceled();
	}

	@Override
	public boolean registerEvent(Object o) {
		if(o == null)return false;
		boolean registered = false;
		for(Method m : o.getClass().getMethods()){
			
			if(m.isAnnotationPresent(EventSuscribe.class)){
				Class<?>[] parameterTypes = m.getParameterTypes();
				if(parameterTypes.length != 1){
					CakeApiMod.logger.error("Invalid number of arguments on the EventSuscribe method: "+m.getName());
					continue;
				}
				Class<?> eventType = parameterTypes[0];
				if (!Event.class.isAssignableFrom(eventType)) {
					CakeApiMod.logger.error("Invalid argument type on the EventSuscribe method: "+m.getName()+", the type "+eventType+" don't implements Event");
					continue;
                }
				
				register(eventType, o, m);
				registered = true;
			}
		}
		return registered;
	}

	private void register(Class<?> eventType, Object o, Method m) {
		ArrayList<MethodCaller> list;
		if(listeners.containsKey(eventType)){
			list = listeners.get(eventType);
		}else{
			list = new ArrayList<MethodCaller>();
			listeners.put(eventType, list);
		}
		MethodCaller caller = new MethodCaller(o,m);
		list.add(caller);
	}
}
