package pages.bbc;

import concrete.TestStep;
import constants.bbc.SearchPageXpaths;
import interfaces.bbc.ISearchPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 5.03.2020.
 */
public class SearchPage extends PageObject implements ISearchPage {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getSearchResultContent() {
        TestStep<String> testStep =
                super.getTextWithXpath(SearchPageXpaths.SEARCH_RESULT_CONTENT);
        if (!testStep.isSuccess()){
            return null;
        }
        return testStep.getParameter();
    }
}
