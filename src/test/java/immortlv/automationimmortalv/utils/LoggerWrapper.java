package immortlv.automationimmortalv.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerWrapper {
    private static final Logger log = LogManager.getRootLogger();

    public static void info(String message) {
        log.info("INFO: " + message);
    }

    public static void verifyInfo(String message) {
        log.info("VERIFY INFO: " + message);
    }


    public static void debug(String message) {
        log.debug("DEBUG: " + message);
    }

    public static void error(String message) {
        log.error("ERROR: " + message);
    }
}
