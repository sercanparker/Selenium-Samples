package pages.hepsiburada;

import concrete.TestStep;
import constants.hepsiburada.LoginPageXpaths;
import interfaces.hepsiburada.ILoginPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 30.03.2020.
 */
public class LoginPage extends PageObject implements ILoginPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep clickLoginRadioButton() {
        return super.clickWithXpath(LoginPageXpaths.LOGIN_RADIO_BUTTON);
    }

    @Override
    public TestStep enterEmail(String email) {
        return super.enterTextWithXpath(email, LoginPageXpaths.EMAIL_INPUT_AREA);
    }

    @Override
    public TestStep enterPassword(String password) {
        return super.enterTextWithXpath(password, LoginPageXpaths.PASSWORD_INPUT_AREA);
    }

    @Override
    public MainPage clickLoginButton() {
        TestStep clickLoginButtonStep = super.clickWithXpath(LoginPageXpaths.LOGIN_BUTTON);
        if (!clickLoginButtonStep.isSuccess()){
            return null;
        }
        return new MainPage(getWebDriver());
    }
}
