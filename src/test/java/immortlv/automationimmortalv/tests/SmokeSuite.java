package immortlv.automationimmortalv.tests;

import immortlv.automationimmortalv.pages.ImmortalHomePage;
import org.testng.annotations.Test;

@Test
public class SmokeSuite extends BasicTestSuite {


    @Test
    public void openWebsiteAsUnregisteredUser() {
     ImmortalHomePage homePage =  driverWrapper.openImmortalWebsite();
     homePage.verifyHeaderIsDisplayed();
    }

}
