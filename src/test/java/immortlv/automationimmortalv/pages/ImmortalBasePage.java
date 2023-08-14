package immortlv.automationimmortalv.pages;

import immortlv.automationimmortalv.utils.LoggerWrapper;
import immortlv.automationimmortalv.utils.WebDriverWrapper;

import static immortlv.automationimmortalv.utils.Constants.IMMORTAL_URL_PROD;

public abstract class ImmortalBasePage {

    public final static PageFactory pageFactory = new PageFactory();
    private final static String HEADER = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[1]";
    private final static String LOGO = HEADER + "/div[1]";
    private final static String MAIN_PAGE_BUTTON = HEADER + "/div[2]/a[1]";
    private final static String PROFILES_PAGE_BUTTON = HEADER + "/div[2]/a[2]";
    private final static String LANGUAGE_BUTTON = HEADER + "/div[3]/div[1]/div[1]/div[1]";
    private final static String USER_ICON_BUTTON = HEADER + "/div[3]/div[2]";
    private final static String USER_MENU_CABINET_ITEM = "(//a[@role='menuitem'])[1]";
    private final static String USER_MENU_LOG_OUT_ITEM = "(//button[@role='menuitem'])[1]";
    public static WebDriverWrapper driverWrapper;

    public  ImmortalHomePage openImmortalWebsite() {
        getDriverWrapper().openUrl(IMMORTAL_URL_PROD);
        return pageFactory.getHomePage();
    }

    public  WebDriverWrapper getDriverWrapper() {
        if (driverWrapper == null) {
            driverWrapper = new WebDriverWrapper();
        }
        return driverWrapper;
    }

    public ImmortalBasePage verifyHeaderIsDisplayed() {
        LoggerWrapper.info("Verify Logo is Displayed");
        getDriverWrapper().waitForElement(LOGO);

        LoggerWrapper.info("Verify Main Page Button is Displayed");
        getDriverWrapper().waitForElement(MAIN_PAGE_BUTTON);

        LoggerWrapper.info("Verify Profiles Page Button is Displayed");
        getDriverWrapper().waitForElement(PROFILES_PAGE_BUTTON);

        LoggerWrapper.info("Verify Language Button is Displayed");
        getDriverWrapper().waitForElement(LANGUAGE_BUTTON);

        LoggerWrapper.info("Verify User Icon Button is Displayed");
        getDriverWrapper().waitForElement(USER_ICON_BUTTON);
        return this;
    }

    public void waitUntilPageIsLoaded() {
        LoggerWrapper.info("Wait Until Page Is Loaded");
        getDriverWrapper().waitForElement(LOGO);
    }

    public ImmortalHomePage clickImmortalLogoOnHeader() {
        getDriverWrapper().clickElement(LOGO);
        return pageFactory.getHomePage();
    }

    public ImmortalHomePage clickHomePageOnHeader() {
        getDriverWrapper().clickElement(MAIN_PAGE_BUTTON);
        return pageFactory.getHomePage();
    }

    public ImmortalHomePage clickProfilesPageOnHeader() {
        getDriverWrapper().clickElement(PROFILES_PAGE_BUTTON);
        return pageFactory.getHomePage();
    }

    public void clickUserMenuIcon() {
        getDriverWrapper().clickElement(USER_ICON_BUTTON);
    }

}
