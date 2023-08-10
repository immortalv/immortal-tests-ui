package immortlv.automationimmortalv.pages;

import immortlv.automationimmortalv.utils.AssertWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class ImmortalCabinetPage extends ImmortalBasePage {
    private final String PROFILES_LIST = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div";

    public static String getAllUserProfileName(WebElement profile) {
        return profile.findElements(By.tagName("a")).get(1).getText();
    }

    public static void clickUserProfileEditButton(WebElement profile) {
        profile.findElements(By.tagName("a")).get(2).click();
    }

    public static void clickUserProfileOrderTableButton(WebElement profile) {
        profile.findElements(By.tagName("a")).get(3).click();
    }

    public List<WebElement> getAllUserProfiles() {
        List<WebElement> profilesList = driverWrapper.getDriver().findElements(By.xpath(PROFILES_LIST));
        return profilesList;
    }

    public List<String> getAllUserProfilesNames() {
        info("Get All User Profiles Names");
        List<String> profileListNames = getAllUserProfiles().stream().map(profile -> getAllUserProfileName(profile)).toList();
        info(String.format("Received next created profiles list: \"%s\"", Arrays.toString(profileListNames.toArray())));
        return profileListNames;
    }

    public ImmortalCabinetPage verifyProfileIsCreated(String profileName) {
        List<String> actualProfileListNames = getAllUserProfilesNames();
        AssertWrapper.assertTrue(actualProfileListNames.contains(profileName), profileName, Arrays.toString(actualProfileListNames.toArray()),
                String.format("Verify that actual created profile list \"%s\" contains profile with name \"%s\"", Arrays.toString(actualProfileListNames.toArray()), profileName));
        return this;
    }

    public ImmortalCabinetPage closeProfileCreatedModal() {
        info("Close Profile Created Modal");
        driverWrapper.findElement("//button[contains(@class,'CloseButton-root mantine-Modal-close')][1]").findElement(By.tagName("svg")).click();
        return this;
    }

    public ImmortalCabinetPage closeProfileDeletedModal() {
        info("Close Profile Deleted Modal");
        driverWrapper.findElement("//button[contains(@class,'CloseButton-root mantine-Modal-close')][1]").findElement(By.tagName("svg")).click();
        return this;
    }


}
