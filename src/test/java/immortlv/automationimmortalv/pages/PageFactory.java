package immortlv.automationimmortalv.pages;

public class PageFactory {
    private ImmortalHomePage homePage;
    private ImmortalLoginPage loginPage;
    private ImmortalProfilesPage profilesPage;
    private ImmortalCabinetPage cabinetPage;
    private ImmortalCreateProfilePage createProfilePage;
    private ImmortalEditProfilePage editProfilePage;

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

    public ImmortalCreateProfilePage getCreateProfilePage() {
        if (createProfilePage == null) {
            createProfilePage = new ImmortalCreateProfilePage();
        }
        createProfilePage.waitUntilPageIsLoaded();
        return createProfilePage;
    }

    public ImmortalEditProfilePage getEditProfilePage() {
        if (editProfilePage == null) {
            editProfilePage = new ImmortalEditProfilePage();
        }
        editProfilePage.waitUntilPageIsLoaded();
        return editProfilePage;
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
