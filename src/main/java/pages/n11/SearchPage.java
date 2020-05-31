package pages.n11;

import concrete.TestStep;
import constants.n11.SearchPageXPATHs;
import interfaces.n11.ISearchPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

import java.util.Random;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class SearchPage extends PageObject implements ISearchPage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep clickNthSearchPage(int n) {
        return super.clickWithXpath(String.format(SearchPageXPATHs.N_TH_PAGE_BUTTON, n));
    }

    @Override
    public TestStep<Integer> getActiveSearchPageNumber() {
         TestStep<String> currentActivePageStep = super.getTextWithXpath(SearchPageXPATHs.CURRENT_PAGE_BUTTON);
         if (!currentActivePageStep.isSuccess()){
             return new TestStep<>(false, currentActivePageStep.getInformation(), 0);
         }
         String currentPage = currentActivePageStep.getParameter();
         return new TestStep<>(true, currentActivePageStep.getInformation(), Integer.valueOf(currentPage));

    }

    @Override
    public TestStep<ItemDetailPage> clickRandomItem(int max) {
        int random = new Random().nextInt(max);
        if (random == 0){
            random++;
        }
        TestStep clickNthPageStep = super.clickWithXpath(String.format(SearchPageXPATHs.N_TH_ITEM, random));
        if (!clickNthPageStep.isSuccess()){
            return clickNthPageStep;
        }
        return new TestStep<>(true, clickNthPageStep.getInformation(), new ItemDetailPage(super.getWebDriver()));
    }
}
