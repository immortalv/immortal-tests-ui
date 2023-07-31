package immortlv.automationimmortalv.pages;

public class PageFactory {
    private ImmortalHomePage homePage;
    private ImmortalLoginPage loginPage;
    private ImmortalProfilesPage profilesPage;
    private ImmortalCabinetPage cabinetPage;

    public ImmortalHomePage getHomePage() {
        if (homePage == null) {
            homePage = new ImmortalHomePage();
        }
        homePage.waitUntilPageIsLoaded();
        return homePage;
    }

    public ImmortalProfilesPage getProfilesPage() {
        if (profilesPage == null) {
            profilesPage = new ImmortalProfilesPage();
        }
        profilesPage.waitUntilPageIsLoaded();
        return profilesPage;
    }

    public ImmortalLoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new ImmortalLoginPage();
        }
        return loginPage;
    }

    public ImmortalCabinetPage getCabinetPage() {
        if (cabinetPage == null) {
            cabinetPage = new ImmortalCabinetPage();
        }
        cabinetPage.waitUntilPageIsLoaded();
        return cabinetPage;
    }
}
