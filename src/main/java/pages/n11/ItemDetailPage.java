package pages.n11;

import concrete.FileUtils;
import concrete.IntegerUtils;
import concrete.TestStep;
import constants.n11.ItemDetailXPATHs;
import interfaces.n11.IItemDetailPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class ItemDetailPage extends PageObject implements IItemDetailPage {

    public ItemDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep writeItemDetailsToTextFile() {
        return null;
    }

    @Override
    public TestStep<String> getItemName() {
        return super.getTextWithXpath(ItemDetailXPATHs.NAME_LABEL);
    }

    @Override
    public TestStep<Integer> getItemPrice() {
        TestStep<String> getPriceStep = super.getTextWithXpath(ItemDetailXPATHs.PRICE_LABEL);
        if (!getPriceStep.isSuccess()){
            return new TestStep<>(false, getPriceStep.getInformation(), 0);
        }
        String priceAsString = getPriceStep.getParameter();
        return new TestStep<>(true, getPriceStep.getInformation(), IntegerUtils.parseTLString(priceAsString));
    }

    @Override
    public TestStep clickAddToShoppingCartButton() {
        TestStep grayButtonStep = super.clickWithXpath(ItemDetailXPATHs.SHOPPING_CART_GRAY_BUTTON);
        FileUtils.writeN11SelectedItemDetails("Item name is " +
                getItemName().getParameter() + " | Item price is " + getItemPrice().getParameter());
        if (!grayButtonStep.isSuccess()){
            return super.clickWithXpath(ItemDetailXPATHs.SHOPPING_CART_GREEN_BUTTON);
        }
        return grayButtonStep;
    }

    @Override
    public TestStep<ShoppingCartPage> clickShoppingCartButton() {
        TestStep clickMyBasketButtonStep = super.clickWithXpath(ItemDetailXPATHs.MY_BASKET_BUTTON);
        if (!clickMyBasketButtonStep.isSuccess()){
            return clickMyBasketButtonStep;
        }
        return new TestStep<>(true, clickMyBasketButtonStep.getInformation(), new ShoppingCartPage(super.getWebDriver()));
    }
}
