package immortlv.automationimmortalv.pages;

import org.springframework.stereotype.Component;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

@Component
public class ImmortalHomePage extends ImmortalBasePage {
    private final String SAVE_MEMORY_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]";
    private final String SEE_PROFILES_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[2]";


    public ImmortalCreateProfilePage clickSaveMemory() {
        info("Click Save Memory");
        driverWrapper.clickElement(SAVE_MEMORY_BUTTON);
        return pageFactory.getCreateProfilePage();
    }

    public ImmortalProfilesPage clickSeeProfiles() {
        info("Click See Profiles");
        driverWrapper.clickElement(SEE_PROFILES_BUTTON);
        return pageFactory.getProfilesPage();
    }

    public ImmortalHomePage loginAsAUser() {
        info("Login As A User");
        clickUserMenuIcon();
        pageFactory.getLoginPage().loginAsAUser();
        return this;
    }
}
