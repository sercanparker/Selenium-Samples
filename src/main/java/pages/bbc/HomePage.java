package pages.bbc;

import concrete.TestStep;
import constants.bbc.HomePageXpaths;
import constants.bbc.SearchPageXpaths;
import interfaces.bbc.IHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Override
    public void clickMore() {
        super.clickWithXpath(HomePageXpaths.MORE_BUTTON);
    }

    @Override
    public MusicPage clickMusicPage() {
        TestStep clickStep = super.clickWithXpath(HomePageXpaths.MUSIC_BUTTON);
        if (!clickStep.isSuccess()){
            return null;
        }
        return new MusicPage(super.getWebDriver());
    }

    @Override
    public TestStep enterSearchInputArea(String searchKeyword) {
        return super.enterTextWithXpath(searchKeyword, HomePageXpaths.SEARCH_INPUT_AREA);
    }

    @Override
    public SearchPage clickSearchButton() {
        TestStep clickStep = super.clickWithXpath(HomePageXpaths.SEARCH_BUTTON);
        if (!clickStep.isSuccess()){
            return null;
        }
        WebElement searchResultContent = super.waitUntilVisibleWithXpath(SearchPageXpaths.SEARCH_RESULT_CONTENT);
        if (searchResultContent == null){
            return null;
        }
        return new SearchPage(getWebDriver());
    }

    @Override
    public HomePage clickHomePage() {
        TestStep clickStep = super.clickWithXpath(HomePageXpaths.HOME_BUTTON);
        if (!clickStep.isSuccess()){
            return null;
        }
        return new HomePage(getWebDriver());
    }

}
