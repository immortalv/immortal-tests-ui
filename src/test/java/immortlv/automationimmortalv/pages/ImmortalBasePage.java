package immortlv.automationimmortalv.pages;

import immortlv.automationimmortalv.utils.LoggerWrapper;
import immortlv.automationimmortalv.utils.WebDriverWrapper;

import static immortlv.automationimmortalv.utils.Constants.IMMORTAL_URL_PROD;

public abstract class ImmortalBasePage {

    public final static WebDriverWrapper driverWrapper = new WebDriverWrapper();
    public final static PageFactory pageFactory = new PageFactory();
    private final static String HEADER = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[1]";
    private final static String LOGO = HEADER + "/div[1]";
    private final static String MAIN_PAGE_BUTTON = HEADER + "/div[2]/a[1]";
    private final static String PROFILES_PAGE_BUTTON = HEADER + "/div[2]/a[2]";
    private final static String LANGUAGE_BUTTON = HEADER + "/div[3]/div[1]/div[1]/div[1]";

    private final static String USER_ICON_BUTTON = HEADER + "/div[3]/div[2]";
    private final static String USER_MENU_CABINET_ITEM = "(//a[@role='menuitem'])[1]";
    private final static String USER_MENU_LOG_OUT_ITEM = "(//button[@role='menuitem'])[1]";


    public static ImmortalHomePage openImmortalWebsite() {
        driverWrapper.openUrl(IMMORTAL_URL_PROD);
        return pageFactory.getHomePage();
    }

    public ImmortalBasePage verifyHeaderIsDisplayed() {
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
        return this;
    }

    public void waitUntilPageIsLoaded() {
        LoggerWrapper.info("Wait Until Page Is Loaded");
        driverWrapper.waitForElement(LOGO);
    }

    public WebDriverWrapper getDriverWrapper() {
        return driverWrapper;
    }

    public ImmortalHomePage clickImmortalLogoOnHeader() {
        driverWrapper.clickElement(LOGO);
        return pageFactory.getHomePage();
    }

    public ImmortalHomePage clickHomePageOnHeader() {
        driverWrapper.clickElement(MAIN_PAGE_BUTTON);
        return pageFactory.getHomePage();
    }

    public ImmortalHomePage clickProfilesPageOnHeader() {
        driverWrapper.clickElement(PROFILES_PAGE_BUTTON);
        return pageFactory.getHomePage();
    }

    public void clickUserMenuIcon() {
        driverWrapper.clickElement(USER_ICON_BUTTON);
    }

}
