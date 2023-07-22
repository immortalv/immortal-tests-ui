package immortlv.automationimmortalv.pages;

import immortlv.automationimmortalv.utils.LoggerWrapper;
import immortlv.automationimmortalv.utils.WebDriverWrapper;

public abstract class ImmortalBasePage {

    private final static String HEADER = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[1]";
    private final static String LOGO = HEADER + "/div[1]";
    private final static String MAIN_PAGE_BUTTON = HEADER + "/div[2]/a[1]";
    private final static String PROFILES_PAGE_BUTTON = HEADER + "/div[2]/a[2]";
    private final static String LANGUAGE_BUTTON = HEADER + "/div[3]/div[1]/div[1]/div[1]";
    private final static String USER_ICON_BUTTON = HEADER + "/div[3]/div[2]";


    private final WebDriverWrapper driverWrapper;

    public ImmortalBasePage(WebDriverWrapper driverWrapper) {
        this.driverWrapper = driverWrapper;
    }


    public void verifyHeaderIsDisplayed() {
        LoggerWrapper.info("Verify Logo is Displayed");
        driverWrapper.waitForElement(LOGO);

        LoggerWrapper.info("Verify Main Page Button is Displayed");
        driverWrapper.waitForElement(MAIN_PAGE_BUTTON);

        LoggerWrapper.info("Verify Profiles Page Button is Displayed");
        driverWrapper.waitForElement(PROFILES_PAGE_BUTTON);

        LoggerWrapper.info("Verify Language Button is Displayed");
        driverWrapper.waitForElement(LANGUAGE_BUTTON);

        LoggerWrapper.info("Verify User Icon Button is Displayed");
        driverWrapper.waitForElement(USER_ICON_BUTTON);
    }


}
