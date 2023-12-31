package immortlv.automationimmortalv.pages;

import static immortlv.automationimmortalv.utils.Constants.OUTLOOK_USER_NAME;
import static immortlv.automationimmortalv.utils.Constants.OUTLOOK_USER_PASS;

public class ImmortalLoginPage extends ImmortalBasePage {
    private final String USERNAME_FIELD = "(//input[@id='username'])[1]";
    private final String PASSWORD_FIELD = "(//input[@id='password'])[1]";
    private final String CONTINUE_BUTTON = "(//*[@name='action'])[2]";

    public ImmortalHomePage loginAsAUser() {
        getDriverWrapper().inputText(USERNAME_FIELD, OUTLOOK_USER_NAME);
        getDriverWrapper().inputText(PASSWORD_FIELD, OUTLOOK_USER_PASS);
        getDriverWrapper().clickElement(CONTINUE_BUTTON);
        return pageFactory.getHomePage();
    }
}
