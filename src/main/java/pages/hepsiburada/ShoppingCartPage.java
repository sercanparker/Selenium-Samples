package pages.hepsiburada;

import concrete.TestStep;
import constants.hepsiburada.ShoppingCartPageXpaths;
import interfaces.hepsiburada.IShoppingCart;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class ShoppingCartPage extends PageObject implements IShoppingCart {
    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public TestStep<Integer> getNumberOfItems() {
        return super.getWebElementCount(ShoppingCartPageXpaths.ITEM_LIST);
    }

    @Override
    public TestStep<String> getItemTitle(int order) {
        return super.getTextWithXpath(String.format(ShoppingCartPageXpaths.N_TH_ITEM_TITLE, order));
    }

    @Override
    public TestStep<String> getVendorName(int order) {
        return super.getTextWithXpath(String.format(ShoppingCartPageXpaths.N_TH_ITEM_VENDOR, order));
    }

    @Override
    public TestStep removeItem(int order) {
        return super.clickWithXpath(String.format(ShoppingCartPageXpaths.N_TH_ITEM_REMOVE_BUTTON, order));
    }
}
