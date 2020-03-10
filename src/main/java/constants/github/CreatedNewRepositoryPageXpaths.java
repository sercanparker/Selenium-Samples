package constants.github;

/**
 * @author sercansensulun on 10.03.2020.
 */
public class CreatedNewRepositoryPageXpaths {
    public static final String SETTINGS_BUTTON = "//*[@id=\"js-repo-pjax-container\"]//a[@class=\"js-selected-navigation-item reponav-item\"][5]";
    public static final String OPTIONS_BUTTON = "//*[@class=\"menu\"][1]//*[contains(text(),'Options')]";
    public static final String DELETE_THIS_REPO_BUTTON = "//*[@class=\"btn btn-danger boxed-action\" and contains(text(),'Delete this repository')]";
    public static final String REPO_NAME_INPUT_AREA_ON_DELETE_DIALOG = "(//input[@type=\"text\" and @name=\"verify\"])[3]";
    public static final String CONFIRMATION_BUTTON_ON_DELETE_DIALOG = "//button[@type=\"submit\" and @class=\"btn btn-block btn-danger\" and text() = 'I understand the consequences, delete this repository']";
}
