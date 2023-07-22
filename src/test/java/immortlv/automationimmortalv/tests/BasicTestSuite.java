package immortlv.automationimmortalv.tests;

import immortlv.automationimmortalv.utils.WebDriverWrapper;
import org.testng.annotations.AfterSuite;


public class BasicTestSuite {
    public final WebDriverWrapper driverWrapper;

    public BasicTestSuite() {
        this.driverWrapper = new WebDriverWrapper();
    }

    @AfterSuite
    public void afterTestsActions() {
        driverWrapper.closeAllBrowsers();
    }
}
