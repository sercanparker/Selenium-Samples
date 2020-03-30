package pages.hepsiburada;

import concrete.TestStep;
import constants.hepsiburada.MainPageXpaths;
import interfaces.hepsiburada.IMainPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class MainPage extends PageObject implements IMainPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep enterSearchKeyword(String keyword) {
        return super.enterTextWithXpath(keyword, MainPageXpaths.SEARCH_INPUT_AREA);
    }

    @Override
    public SearchResultPage clickSearchButton() {
        TestStep clickStep = super.clickWithXpath(MainPageXpaths.SEARCH_BUTTON);
        if (!clickStep.isSuccess()){
            return null;
        }
        return new SearchResultPage(getWebDriver());
    }

    @Override
    public ShoppingCartPage clickMyCartButton() {
        TestStep clickStep = super.clickWithXpath(MainPageXpaths.MY_CART_BUTTON);
        if (!clickStep.isSuccess()){
            return null;
        }
        return new ShoppingCartPage(getWebDriver());
    }

    @Override
    public LoginPage clickLoginPage() {
        TestStep loginButtonStep = super.clickWithXpath(MainPageXpaths.BIG_LOGIN_BUTTON);
        if (!loginButtonStep.isSuccess()){
            return null;
        }
        TestStep loginItemStep = super.clickWithXpath(MainPageXpaths.LOGIN_ITEM);
        if (!loginItemStep.isSuccess()){
            return null;
        }
        return new LoginPage(getWebDriver());
    }

    @Override
    public void checkLoginSuccess() {
        super.sleep(5000);
        super.waitUntilVisibleWithXpath(MainPageXpaths.MY_ACCOUNT_TITLE);
    }


    @Override
    public TestStep logout() {
        TestStep myAccountButtonStep = super.clickWithXpath(MainPageXpaths.MY_ACCOUNT_TITLE);
        if (!myAccountButtonStep.isSuccess()){
            return myAccountButtonStep;
        }
        return super.clickWithXpath(MainPageXpaths.LOGOUT_ITEM);
    }
}
