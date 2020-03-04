package pages.bbc;

import concrete.TestStep;
import constants.bbc.HomePageXpaths;
import interfaces.bbc.IHomePage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 4.03.2020.
 */
public class HomePage extends PageObject implements IHomePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SportPage clickSportPage() {
        TestStep clickStep = super.clickWithXpath(HomePageXpaths.SPORT_PAGE);
        if (!clickStep.isSuccess()){
            return null;
        }
        return new SportPage(super.getWebDriver());
    }
}
