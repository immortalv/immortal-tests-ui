package immortlv.automationimmortalv.tests;

import immortlv.automationimmortalv.pages.ImmortalHomePage;
import immortlv.automationimmortalv.pages.ImmortalProfilesPage;
import org.testng.annotations.Test;

import static immortlv.automationimmortalv.pages.ImmortalBasePage.openImmortalWebsite;
import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

@Test
public class SmokeSuite extends BasicTestSuite {


    @Test
    public void verifyWebsiteAsUnregisteredUser() {
        ImmortalHomePage homePage = openImmortalWebsite();

        info("Verify Home page");
        homePage.verifyHeaderIsDisplayed();

        info("Verify Profiles Page");
        ImmortalProfilesPage profilesPage = homePage.clickSeeProfiles();

        info("Verify that profiles are displayed on 1 page");
        profilesPage.verifyAllProfilesAreDisplayed();
        info("Verify that profiles are displayed on 2 page");
        profilesPage.clickRightPaginationArrow().verifyAllProfilesAreDisplayed();
        info("Go back to first page and verify that profiles are displayed");
        profilesPage.clickLeftPaginationArrow().verifyAllProfilesAreDisplayed();

        info("Verify Profiles Searching");
        profilesPage.searchProfile(PROFILE_NAME);
        profilesPage.verifyProfileResultsContainsExpectedName(PROFILE_NAME);
    }

    @Test
    public void verifyWebsiteAsRegisteredUser() {
        ImmortalHomePage homePage = openImmortalWebsite();

        info("Verify Home page");
        homePage.verifyHeaderIsDisplayed();
        homePage.loginAsAUser();

        info("Verify Profiles Page");
        ImmortalProfilesPage profilesPage = homePage.clickSeeProfiles();

        info("Verify that profiles are displayed on 1 page");
        profilesPage.verifyAllProfilesAreDisplayed();
        info("Verify that profiles are displayed on 2 page");
        profilesPage.clickRightPaginationArrow().verifyAllProfilesAreDisplayed();
        info("Go back to first page and verify that profiles are displayed");
        profilesPage.clickLeftPaginationArrow().verifyAllProfilesAreDisplayed();

        info("Verify Profiles Searching");
        profilesPage.searchProfile(PROFILE_NAME);
        profilesPage.verifyProfileResultsContainsExpectedName(PROFILE_NAME);
    }

}
