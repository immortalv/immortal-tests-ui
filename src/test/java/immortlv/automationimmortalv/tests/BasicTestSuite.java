package immortlv.automationimmortalv.tests;

import immortlv.automationimmortalv.utils.WebDriverWrapper;
import org.testng.annotations.AfterSuite;


public class BasicTestSuite {
    public final static String PROFILE_NAME = "Mirovic Nikola";
    public final WebDriverWrapper driverWrapper;

    public BasicTestSuite() {
        this.driverWrapper = new WebDriverWrapper();
    }

    @AfterSuite(alwaysRun = true)
    public void afterTestsActions() {
        driverWrapper.closeAllBrowsers();
    }
}
