package pages.hepsiburada;

import concrete.TestStep;
import constants.hepsiburada.SearchResultPageXpaths;
import interfaces.hepsiburada.ISearchResultPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class SearchResultPage extends PageObject implements ISearchResultPage {
    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep<Integer> getVendorCount() {
        return super.getWebElementCount(SearchResultPageXpaths.VENDOR_LIST);
    }

    @Override
    public TestStep<String> getFirstItemName() {
        return super.getTextWithXpath(SearchResultPageXpaths.FIRST_ITEM_NAME);
    }

    @Override
    public TestStep<String> clickVendor(int order) {
        return super.clickWithXpath(String.format(SearchResultPageXpaths.N_TH_VENDOR, order));
    }

    @Override
    public TestStep addFirstItemToCart() {
        return super.clickWithXpath(SearchResultPageXpaths.ADD_FIRST_ITEM_TO_CART_BUTTON);
    }

    @Override
    public TestStep removeVendorFilter() {
        return super.clickWithXpath(SearchResultPageXpaths.REMOVE_FIRST_VENDOR_FILTER_BUTTON);
    }
}
