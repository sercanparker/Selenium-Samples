package pages.n11;

import concrete.TestStep;
import constants.n11.MainPageExpectedResults;
import constants.n11.MainPageXPATHs;
import interfaces.n11.IMainPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class MainPage extends PageObject implements IMainPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep<Boolean> isMainPageOpened() {
        boolean isTitleMatched = super.getWebDriver().getTitle().equals(MainPageExpectedResults.MAIN_PAGE_TITLE);
        return new TestStep<>(isTitleMatched, "Expected is " +
                MainPageExpectedResults.MAIN_PAGE_TITLE + "Actual is " +
                getWebDriver().getTitle()
                ,isTitleMatched);
    }

    @Override
    public TestStep<LoginPage> clickLoginButton() {
        TestStep clickLoginStep = super.clickWithXpath(MainPageXPATHs.LOGIN_BUTTON);
        if (!clickLoginStep.isSuccess()){
            return clickLoginStep;
        }
        return new TestStep<>(true, clickLoginStep.getInformation(), new LoginPage(super.getWebDriver()));

    }

    @Override
    public TestStep<String> getLoggedUsername() {
        return super.getTextWithXpath(MainPageXPATHs.LOGGED_USERNAME_LABEL);
    }

    @Override
    public TestStep enterSearchKeyword(String keyword) {
        TestStep enterSearchKeywordStep = super.enterTextWithXpath(keyword, MainPageXPATHs.SEARCH_INPUT_AREA);
        if (!enterSearchKeywordStep.isSuccess()){
            return enterSearchKeywordStep;
        }
        return new TestStep(true, enterSearchKeywordStep.getInformation());
    }

    @Override
    public TestStep<SearchPage> clickSearchButton() {
        TestStep clickSearchButtonStep = super.clickWithXpath(MainPageXPATHs.SEARCH_BUTTON);
        if (!clickSearchButtonStep.isSuccess()){
            return clickSearchButtonStep;
        }
        return new TestStep<>(true, clickSearchButtonStep.getInformation(), new SearchPage(super.getWebDriver()));
    }

    @Override
    public TestStep<MainPage> clickLogoutButton() {
        TestStep clickLogoutButtonStep = super.clickWithXpath(MainPageXPATHs.LOGOUT_BUTTON);
        if (!clickLogoutButtonStep.isSuccess()){
            return clickLogoutButtonStep;
        }
        return new TestStep<>(true, clickLogoutButtonStep.getInformation(), new MainPage(super.getWebDriver()));
    }

    @Override
    public TestStep clickKVKDialogOKButton() {
        return super.clickWithXpath(MainPageXPATHs.KVK_DIALOG_OK_BUTTON);
    }
}
