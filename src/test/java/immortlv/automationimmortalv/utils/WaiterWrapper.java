package immortlv.automationimmortalv.utils;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class WaiterWrapper {


    public static void implicitWait(Integer secondsToWait, String reason) {
        info(String.format("Implicit Waiting %s seconds, reason: \"%s\"",secondsToWait,reason));
        try {
            Thread.sleep(secondsToWait * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
