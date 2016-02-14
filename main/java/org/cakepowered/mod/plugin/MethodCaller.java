package org.cakepowered.mod.plugin;

import java.lang.reflect.Method;

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
        } catch (Exception e) {
            if (e.getCause() == null) {
                e.printStackTrace();
            } else {
                e.getCause().printStackTrace();
            }
        }
    }
}
