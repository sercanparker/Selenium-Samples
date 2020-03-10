package pages.github;

import concrete.TestStep;
import constants.github.HomePageXpaths;
import interfaces.github.IHomePage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 6.03.2020.
 */
public class HomePage extends PageObject implements IHomePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep clickMenu() {
        return super.clickWithXpath(HomePageXpaths.MENU_BUTTON);
    }

    @Override
    public SignInPage clickSignOut() {
        TestStep clickSignOutButtonStep = super.clickWithXpath(HomePageXpaths.SIGN_OUT_BUTTON);
        if (!clickSignOutButtonStep.isSuccess()){
            return null;
        }
        return new SignInPage(getWebDriver());

    }

    @Override
    public NewRepositoryPage clickNewRepositoryButton() {
        TestStep clickNewRepoStep = super.clickWithXpath(HomePageXpaths.NEW_REPOSITORY_BUTTON);
        if (!clickNewRepoStep.isSuccess()){
            return null;
        }
        return new NewRepositoryPage(getWebDriver());
    }
}
