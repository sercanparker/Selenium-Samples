package pages.github;

import concrete.TestStep;
import constants.github.CreatedNewRepositoryPageXpaths;
import interfaces.github.ICreatedNewRepositoryPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 10.03.2020.
 */
public class CreatedNewRepositoryPage extends PageObject implements ICreatedNewRepositoryPage {
    public CreatedNewRepositoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep clickSettings() {
        return super.clickWithXpath(CreatedNewRepositoryPageXpaths.SETTINGS_BUTTON);
    }

    @Override
    public TestStep clickOptions() {
        return super.clickWithXpath(CreatedNewRepositoryPageXpaths.OPTIONS_BUTTON);
    }

    @Override
    public TestStep clickDeleteThisRepositoryButton() {
        return super.clickWithXpath(CreatedNewRepositoryPageXpaths.DELETE_THIS_REPO_BUTTON);
    }

    @Override
    public TestStep enterRepositoryNameOnDeleteAttemptDialog(String repositoryName) {
        return super.enterTextWithXpath(repositoryName, CreatedNewRepositoryPageXpaths.REPO_NAME_INPUT_AREA_ON_DELETE_DIALOG);
    }

    @Override
    public ConfirmationPage clickConfirmationButtonToOnDeleteAttemptDialog() {
        TestStep deleteRepoStep = super.clickWithXpath(CreatedNewRepositoryPageXpaths.CONFIRMATION_BUTTON_ON_DELETE_DIALOG);
        if (!deleteRepoStep.isSuccess()){
            return null;
        }
        return new ConfirmationPage(getWebDriver());
    }
}
