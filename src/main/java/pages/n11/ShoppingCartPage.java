package pages.n11;


import concrete.IntegerUtils;
import concrete.TestStep;
import constants.n11.ShoppingCartExpectedResults;
import constants.n11.ShoppingCartPageXPATHs;
import interfaces.n11.IShoppingCartPage;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class ShoppingCartPage extends PageObject implements IShoppingCartPage {

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public TestStep<String> getItemName(int order) {
        return super.getTextWithXpath(String.format(ShoppingCartPageXPATHs.N_TH_ITEM_TITLE_LABEL, order));
    }

    @Override
    public TestStep<Integer> getItemPrice(int order) {
        TestStep<String> getPriceStep = super.getTextWithXpath(String.format(ShoppingCartPageXPATHs.N_TH_ITEM_PRICE_LABEL, order));
        if (!getPriceStep.isSuccess()){
            return new TestStep<Integer>(false, getPriceStep.getInformation(), 0);
        }
        String priceAsString = getPriceStep.getParameter();
        return new TestStep<>(true, getPriceStep.getInformation(), IntegerUtils.parseTLString(priceAsString));
    }

    @Override
    public TestStep incrementItemCount(int order) {
        return super.clickWithXpath(String.format(ShoppingCartPageXPATHs.N_TH_INCREMENT_BUTTON, order));
    }

    @Override
    public TestStep<Integer> getItemCount(int order) {
        TestStep<String> itemCountStep = super.getInputValue(String.format(ShoppingCartPageXPATHs.N_TH_ITEM_COUNT_LABEL, order));
        if (!itemCountStep.isSuccess()){
            return new TestStep<>(false, itemCountStep.getInformation(), 0);
        }
        String countAsString = itemCountStep.getParameter();
        return new TestStep<>(true, itemCountStep.getInformation(), Integer.valueOf(countAsString));

    }

    @Override
    public TestStep clickDeleteItemButton(int order) {
        return super.clickWithXpath(String.format(ShoppingCartPageXPATHs.N_TH_ITEM_DELETE_BUTTON, order));
    }

    @Override
    public TestStep<Integer> getDistinctItemCount() {
        return super.getWebElementCount(ShoppingCartPageXPATHs.SELECTED_ITEM_TABLE);
    }

    @Override
    public TestStep<Boolean> isCartEmpty() {
        TestStep<String> getChartTitle = super.getTextWithXpath(ShoppingCartPageXPATHs.EMPTY_CHART_TITLE);
        if (!getChartTitle.isSuccess()){
            return new TestStep<>(false, getChartTitle.getInformation(), false);
        }
        boolean isEmpty = getChartTitle.getParameter().equals(ShoppingCartExpectedResults.EMPTY_CART_MESSAGE);
        return new TestStep(true, "Actual chart title is " +
                getChartTitle.getParameter() + ". Expected title is " +
                ShoppingCartExpectedResults.EMPTY_CART_MESSAGE, isEmpty);
    }
}
