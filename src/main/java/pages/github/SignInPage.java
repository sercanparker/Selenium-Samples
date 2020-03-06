package pages.github;

import concrete.TestStep;
import constants.github.SignInPageXpaths;
import interfaces.github.ISignInPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 6.03.2020.
 */
public class SignInPage extends PageObject implements ISignInPage {
    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep enterUsername(String username) {
        return super.enterTextWithXpath(username, SignInPageXpaths.USERNAME);
    }

    @Override
    public TestStep enterPassword(String password) {
        return super.enterTextWithXpath(password, SignInPageXpaths.PASSWORD);
    }

    @Override
    public HomePage clickSignInButton() {
        TestStep clickSignInButton = super.clickWithXpath(SignInPageXpaths.SIGN_IN_BUTTON);
        if (!clickSignInButton.isSuccess()){
            return null;
        }
        return new HomePage(getWebDriver());
    }
}
