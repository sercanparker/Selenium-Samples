package pages.github;

import concrete.TestStep;
import constants.github.ConfirmationPageXpaths;
import interfaces.github.IConfirmationPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 10.03.2020.
 */
public class ConfirmationPage extends PageObject implements IConfirmationPage {
    public ConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep enterPassword(String password) {
        return super.enterTextWithXpath(password, ConfirmationPageXpaths.PASSWORD_INPUT_AREA);
    }

    @Override
    public HomePage clickConfirmButton() {
        TestStep clickConfirmationStep = super.clickWithXpath(ConfirmationPageXpaths.CONFIRM_BUTTON);
        if (!clickConfirmationStep.isSuccess()){
            return null;
        }
        return new HomePage(getWebDriver());
    }
}
