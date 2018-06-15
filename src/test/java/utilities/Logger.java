package utilities;

import org.apache.log4j.Level;

public class Logger {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(Logger.class);

    private static void log(Level lvl, String msg, Throwable t) {
        LOG.log(lvl, msg, t);
    }

    public static void info(String msg) {
        log(Level.INFO, msg, null);
    }

    public static void warning(String msg) {
        log(Level.WARN, msg, null);
    }

    public static void error(String msg) {
        log(Level.ERROR, msg, null);
    }

    public static void error(Throwable t) {
        log(Level.ERROR, "", t);
    }


}
