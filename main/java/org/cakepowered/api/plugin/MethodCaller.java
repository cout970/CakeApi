package org.cakepowered.api.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.cakepowered.api.events.ApiPlayerJoinEvent;

public class MethodCaller {
	
	private Object obj;
	private Method method;

	public MethodCaller(Object o, Method m) {
		obj = o;
		method = m;
	}

	public void call(Object arg) {
		try {
			method.invoke(obj, arg);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
