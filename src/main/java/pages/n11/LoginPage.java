package pages.n11;

import concrete.TestStep;
import constants.n11.LoginPageXPATHs;
import interfaces.n11.ILoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageObject;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class LoginPage extends PageObject implements ILoginPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep enterEmail(String username) {
        return super.enterTextWithXpath(username, LoginPageXPATHs.USERNAME_INPUT_AREA);
    }

    @Override
    public TestStep enterPassword(String password) {
        return super.enterTextWithXpath(password, LoginPageXPATHs.PASSWORD_INPUT_AREA);
    }

    @Override
    public TestStep<MainPage> clickLoginButton() {
        TestStep clickLoginButtonStep = super.clickWithXpath(LoginPageXPATHs.LOGIN_BUTTON);
        if (!clickLoginButtonStep.isSuccess()){
            return clickLoginButtonStep;
        }
        return new TestStep<>(true, clickLoginButtonStep.getInformation(), new MainPage(getWebDriver()));
    }
}
