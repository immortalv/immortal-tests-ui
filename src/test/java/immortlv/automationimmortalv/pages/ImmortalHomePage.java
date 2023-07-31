package immortlv.automationimmortalv.pages;

import org.springframework.stereotype.Component;

@Component
public class ImmortalHomePage extends ImmortalBasePage {
    private final String SAVE_MEMORY_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]";
    private final String SEE_PROFILES_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[2]";


    public String clickSaveMemory() {
        return SAVE_MEMORY_BUTTON;
    }

    public ImmortalProfilesPage clickSeeProfiles() {
        driverWrapper.clickElement(SEE_PROFILES_BUTTON);
        return pageFactory.getProfilesPage();
    }

    public ImmortalHomePage loginAsAUser() {
        clickUserMenuIcon();
        pageFactory.getLoginPage().loginAsAUser();
        return this;
    }
}
