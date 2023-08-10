package immortlv.automationimmortalv.pages;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class ImmortalCreateProfilePage extends ImmortalEditProfilePage {
    //Buttons
    private final String CREATE_PROFILE_BUTTON = "(//button[@type='submit'])[1]";

    public ImmortalCabinetPage clickCreateProfile() {
        info("Click Create Profile");
        driverWrapper.clickElement(CREATE_PROFILE_BUTTON);
        return pageFactory.getCabinetPage();
    }

}
