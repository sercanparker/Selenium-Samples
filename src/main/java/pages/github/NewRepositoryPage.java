package pages.github;

import concrete.TestStep;
import constants.github.NewRepositoryPageXpaths;
import interfaces.github.INewRepositoryPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 9.03.2020.
 */
public class NewRepositoryPage extends PageObject implements INewRepositoryPage {
    public NewRepositoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep enterNewRepositoryName(String name) {
        return super.enterTextWithXpath(name, NewRepositoryPageXpaths.NEW_REPOSITORY_NAME_INPUT_AREA);
    }

    @Override
    public CreatedNewRepositoryPage clickCreateNewRepositoryButton() {
        TestStep newRepositoryClickStep =
                super.clickWithXpath(NewRepositoryPageXpaths.CREATE_NEW_REPOSITORY_BUTTON);

        if (!newRepositoryClickStep.isSuccess()){
            return null;
        }
        return new CreatedNewRepositoryPage(getWebDriver());
    }
}
