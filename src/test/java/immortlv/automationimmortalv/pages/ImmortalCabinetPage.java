package immortlv.automationimmortalv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class ImmortalCabinetPage extends ImmortalBasePage {
    private final String PROFILES_LIST = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div";

    public List<WebElement> getAllUserProfiles() {
        info("Get All User Profiles");
        List<WebElement> profilesList = driverWrapper.getDriver().findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]"));
        info(String.format("Received next created profiles list: \"%s\"", Arrays.toString(profilesList.toArray())));
        return profilesList;
    }
}
