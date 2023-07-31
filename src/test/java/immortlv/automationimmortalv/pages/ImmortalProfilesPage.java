package immortlv.automationimmortalv.pages;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static immortlv.automationimmortalv.utils.AssertWrapper.assertTrue;
import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class ImmortalProfilesPage extends ImmortalBasePage {
    //Search
    private final String SEARCH_FIELD = "//*[contains(@class,'mantine-Input-input mantine-TextInput-input')]";

    //Profiles Block
    private final String PROFILES_ON_PAGE_CONTAINER = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]";
    private final String ALL_PROFILES_ON_PAGE = PROFILES_ON_PAGE_CONTAINER + "/a";


    //Pagination
    private final String PROFILES_PAGINATION_BUTTONS = "//*[contains(@class,'mantine-UnstyledButton-root mantine-Pagination-control')]";
    private final String LEFT_ARROW = PROFILES_PAGINATION_BUTTONS + "[1]";
    private final String RIGHT_ARROW = PROFILES_PAGINATION_BUTTONS + "[5]";

    public ImmortalProfilesPage verifyAllProfilesAreDisplayed() {
        Integer expectedProfilesAmount = 24;
        driverWrapper.waitForElement(PROFILES_ON_PAGE_CONTAINER);
        Integer actualProfilesAmount = driverWrapper.getDriver().findElements(By.xpath(ALL_PROFILES_ON_PAGE)).size();
        assertTrue(expectedProfilesAmount == actualProfilesAmount, expectedProfilesAmount.toString(), actualProfilesAmount.toString(),
                "Verify that on current \"Profiles\" page - 24 profiles are displayed");
        return this;
    }

    public ImmortalProfilesPage clickRightPaginationArrow() {
        info("Click Right Pagination Arrow");
        driverWrapper.clickElement(RIGHT_ARROW);
        return this;
    }

    public ImmortalProfilesPage clickLeftPaginationArrow() {
        info("Click Left Pagination Arrow");
        driverWrapper.clickElement(LEFT_ARROW);
        return this;
    }

    public ImmortalProfilesPage searchProfile(String searchData) {
        info(String.format("Search profile with \"%s\"", searchData));
        driverWrapper.inputText(SEARCH_FIELD, searchData);
        driverWrapper.waitForElement(PROFILES_ON_PAGE_CONTAINER);
        return this;
    }

    public ImmortalProfilesPage verifyProfileResultsContainsExpectedName(String expectedProfileName) {
        List<String> actualProfiles = getDisplayedProfilesNames();

        assertTrue(actualProfiles.contains(expectedProfileName), expectedProfileName, Arrays.toString(actualProfiles.toArray()),
                String.format("Verify that on current \"Profiles\" page - profile with name \"%s\" is displayed", expectedProfileName));
        return this;
    }

    public List<String> getDisplayedProfilesNames() {
        info("Get Displayed Profiles Names");
        driverWrapper.waitForElement(PROFILES_ON_PAGE_CONTAINER);
        List<String> displayedProfileNames = driverWrapper.getDriver().findElements(By.xpath(ALL_PROFILES_ON_PAGE)).stream().map(profile -> profile.getText()).toList();
        return displayedProfileNames;
    }
}
