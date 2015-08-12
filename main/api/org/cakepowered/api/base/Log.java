package org.cakepowered.api.base;

public interface Log {

	public void error(String s);
	public void debug(Object s);
	public void info(String s);
	public void warn(String s);
	public void raw(Object s);
}
