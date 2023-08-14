package immortlv.automationimmortalv.pages;

import org.openqa.selenium.By;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class ImmortalEditProfilePage extends ImmortalBasePage {
    //General Field
    private final String NAME_FIELD = "//input[@name='firstName']";
    private final String LASTNAME_FIELD = "//input[@name='lastName']";
    private final String FATHERSNAME_FIELD = "//input[@name='middleName']";

    private final String YEARS_OF_LIFE_FIELD = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/button[1]";

    private final String FAVORITE_QUOTE_FIELD = "//input[@name='epitaph']";
    private final String BIOGRAPHY_FIELD = "//textarea[@name='description']";

    //Profile for military fields

    private final String PROFILE_FOR_MILITARY_CHECKBOX = "//input[@name='isMilitaryExperience']";
    private final String NAME_OF_WAR_FIELD = "//input[@name='militaryExperience.0.battle']";
    private final String YEARS_OF_WAR_FIELD = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/div[1]/button[1]";
    private final String DIVISION_NAME_FIELD = "//input[@name='militaryExperience.0.unit']";
    private final String POSITION_NAME_FIELD = "//input[@name='militaryExperience.0.position']";
    private final String RANK_NAME_FIELD = "//input[@name='militaryExperience.0.rank']";
    private final String NICKNAME_FIELD = "//input[@name='militaryExperience.0.callsign']";


    //Buttons
    private final String DELETE_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[5]/button[1]";
    private final String SAVE_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[5]/button[2]";
    private final String CREATE_PROFILE_BUTTON = "(//button[@type='submit'])[1]";

    public ImmortalEditProfilePage setName(String name) {
        info(String.format("Set Name: \"%s\"", name));
        getDriverWrapper().inputText(NAME_FIELD, name);
        return this;
    }

    public ImmortalEditProfilePage setLastname(String lastname) {
        info(String.format("Set Lastname: \"%s\"", lastname));
        getDriverWrapper().inputText(LASTNAME_FIELD, lastname);
        return this;
    }

    public ImmortalEditProfilePage setFathersname(String fathersname) {
        info(String.format("Set Fathersname: \"%s\"", fathersname));
        getDriverWrapper().inputText(FATHERSNAME_FIELD, fathersname);
        return this;
    }

    private ImmortalEditProfilePage setYearsOfLife(String yearsOfLife) {
        return this;
    }

    public ImmortalEditProfilePage setFavoriteQuote(String quote) {
        info(String.format("Set FavoriteQuote: \"%s\"", quote));
        getDriverWrapper().inputText(FAVORITE_QUOTE_FIELD, quote);
        return this;
    }

    public ImmortalEditProfilePage setBiography(String biography) {
        info("Set Biography");
        getDriverWrapper().inputText(BIOGRAPHY_FIELD, biography);
        return this;
    }

    public ImmortalEditProfilePage clickProfileForMilitaryCheckbox() {
        info("Click Profile For Military Checkbox");
        getDriverWrapper().clickElement(PROFILE_FOR_MILITARY_CHECKBOX);
        return this;
    }

    public ImmortalEditProfilePage setNameOfWar(String nameOfWar) {
        info(String.format("Set NameOfWar: \"%s\"", nameOfWar));
        getDriverWrapper().inputText(NAME_OF_WAR_FIELD, nameOfWar);
        return this;
    }

    public ImmortalEditProfilePage setDefaultYearsOfWar() {
        info("Set Default Years Of War");
        String FIRST_MONTH = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/button[1]";
        String SECOND_MONTH = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/button[1]";

        getDriverWrapper().clickElement(YEARS_OF_WAR_FIELD);
        getDriverWrapper().findElement("//table").findElement(By.xpath("tbody[1]/tr[1]/td[2]/button[1]")).click();
        getDriverWrapper().findElement("//table").findElement(By.xpath("tbody[1]/tr[1]/td[3]/button[1]")).click();
        return this;
    }

    private ImmortalEditProfilePage setYearsOfWar(String yearsOfWar) {
        getDriverWrapper().inputText(YEARS_OF_WAR_FIELD, yearsOfWar);
        return this;
    }

    public ImmortalEditProfilePage setDivisionName(String divisionName) {
        info(String.format("Set Division Name: \"%s\"", divisionName));
        getDriverWrapper().inputText(DIVISION_NAME_FIELD, divisionName);
        return this;
    }

    public ImmortalEditProfilePage setPositionName(String positionName) {
        info(String.format("Set Position Name: \"%s\"", positionName));
        getDriverWrapper().inputText(POSITION_NAME_FIELD, positionName);
        return this;
    }

    public ImmortalEditProfilePage setRankName(String rankName) {
        info(String.format("Set Rank Name: \"%s\"", rankName));
        getDriverWrapper().inputText(RANK_NAME_FIELD, rankName);
        return this;
    }

    public ImmortalEditProfilePage setNickName(String nickName) {
        info(String.format("Set Nick Name: \"%s\"", nickName));
        getDriverWrapper().inputText(NICKNAME_FIELD, nickName);
        return this;
    }

    ImmortalEditProfilePage clickSave() {
        info("Click Save");
        getDriverWrapper().clickElement(SAVE_BUTTON);
        return this;
    }

    ImmortalEditProfilePage clickDelete() {
        info("Click Delete");
        getDriverWrapper().clickElement(DELETE_BUTTON);
        return this;
    }

    public ImmortalCabinetPage clickSaveButton() {
        info("Click Create Profile");
        getDriverWrapper().clickElement(CREATE_PROFILE_BUTTON);
        return pageFactory.getCabinetPage();
    }

}
