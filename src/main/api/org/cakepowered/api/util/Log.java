package org.cakepowered.api.util;

public interface Log {

    void error(String s);

    void debug(Object s);

    void info(String s);

    void warn(String s);

    void raw(Object s);
}
