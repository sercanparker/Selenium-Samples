package n11;

import concrete.Credentials;
import concrete.FileUtils;
import concrete.TestStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.n11.*;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class Test001 extends N11AbstractTest {

    @Test
    public void test(){

        TestStep<Boolean> openedMainPageStep = mainPage.isMainPageOpened();
        Assert.assertTrue(openedMainPageStep.isSuccess(), openedMainPageStep.getInformation());
        Assert.assertTrue(openedMainPageStep.getParameter(), openedMainPageStep.getInformation());

        TestStep clickKVKDialogOKButtonStep = mainPage.clickKVKDialogOKButton();
        Assert.assertTrue(clickKVKDialogOKButtonStep.isSuccess());


        TestStep<LoginPage> clickLoginButtonStep = mainPage.clickLoginButton();
        Assert.assertTrue(clickLoginButtonStep.isSuccess(), clickLoginButtonStep.getInformation());
        Assert.assertNotNull(clickLoginButtonStep.getParameter(), clickLoginButtonStep.getInformation());

        LoginPage loginPage = clickLoginButtonStep.getParameter();

        Credentials credentials = FileUtils.getN11Credentials();

        TestStep enterEmailStep = loginPage.enterEmail(credentials.getEmail());
        Assert.assertTrue(enterEmailStep.isSuccess(), enterEmailStep.getInformation());
        TestStep enterPasswordStep = loginPage.enterPassword(credentials.getPassword());
        Assert.assertTrue(enterPasswordStep.isSuccess(), enterPasswordStep.getInformation());
        TestStep<MainPage> clickLoginButton = loginPage.clickLoginButton();
        Assert.assertTrue(clickLoginButton.isSuccess(), clickLoginButton.getInformation());
        Assert.assertNotNull(clickLoginButton.getParameter());

        TestStep<String> getLoggedUsernameStep = mainPage.getLoggedUsername();
        Assert.assertTrue(getLoggedUsernameStep.isSuccess(), getLoggedUsernameStep.getInformation());
        Assert.assertEquals(getLoggedUsernameStep.getParameter(), credentials.getUsername(), "Logged username and expected username are compared.");

        TestStep enterSearchKeyStep = mainPage.enterSearchKeyword("bilgisayar");
        Assert.assertTrue(enterSearchKeyStep.isSuccess(), enterSearchKeyStep.getInformation());
        TestStep<SearchPage> clickSearchButtonStep = mainPage.clickSearchButton();
        Assert.assertTrue(clickSearchButtonStep.isSuccess(), clickSearchButtonStep.getInformation());
        Assert.assertNotNull(clickSearchButtonStep.getParameter());

        SearchPage searchPage = clickSearchButtonStep.getParameter();

        TestStep open2sndPageStep = searchPage.clickNthSearchPage(2);
        Assert.assertTrue(open2sndPageStep.isSuccess());


        TestStep<Integer> getActiveSearchPageStep = searchPage.getActiveSearchPageNumber();
        Assert.assertTrue(getActiveSearchPageStep.isSuccess());
        Assert.assertEquals(getActiveSearchPageStep.getParameter().intValue(), 2);

        TestStep<ItemDetailPage> randomItemSelected = searchPage.clickRandomItem(10);
        Assert.assertTrue(randomItemSelected.isSuccess(), randomItemSelected.getInformation());
        Assert.assertNotNull(randomItemSelected.getParameter());

        ItemDetailPage itemDetailPage = randomItemSelected.getParameter();
        TestStep clickAddToShoppingCartStep = itemDetailPage.clickAddToShoppingCartButton();
        Assert.assertTrue(clickAddToShoppingCartStep.isSuccess(), clickAddToShoppingCartStep.getInformation());

        TestStep<String> getItemNameStep = itemDetailPage.getItemName();
        Assert.assertTrue(getItemNameStep.isSuccess(), getItemNameStep.getInformation());
        Assert.assertNotNull(getItemNameStep.getParameter());
        String selectedItemName = getItemNameStep.getParameter();

        TestStep<Integer> getItemPriceStep = itemDetailPage.getItemPrice();
        Assert.assertTrue(getItemPriceStep.isSuccess(), getItemPriceStep.getInformation());
        Assert.assertNotNull(getItemPriceStep.getParameter());
        Integer selectedItemPrice = getItemPriceStep.getParameter();

        TestStep<ShoppingCartPage> clickShoppingCartButtonStep = itemDetailPage.clickShoppingCartButton();
        Assert.assertTrue(clickShoppingCartButtonStep.isSuccess(), clickShoppingCartButtonStep.getInformation());
        Assert.assertNotNull(clickShoppingCartButtonStep.getParameter());

        ShoppingCartPage shoppingCartPage = clickShoppingCartButtonStep.getParameter();
        TestStep<Integer> countDistinctItemStep = shoppingCartPage.getDistinctItemCount();
        Assert.assertTrue(countDistinctItemStep.isSuccess(),countDistinctItemStep.getInformation());
        Assert.assertNotNull(countDistinctItemStep.getParameter());
        Assert.assertEquals(countDistinctItemStep.getParameter().intValue(), 1);

        TestStep<Integer> get1stItemCountStep = shoppingCartPage.getItemCount(1);
        Assert.assertTrue(get1stItemCountStep.isSuccess(), get1stItemCountStep.getInformation());
        Assert.assertNotNull(get1stItemCountStep.getParameter());
        Assert.assertEquals(get1stItemCountStep.getParameter().intValue(), 1);

        TestStep<String> get1stItemName = shoppingCartPage.getItemName(1);
        Assert.assertTrue(get1stItemName.isSuccess(), get1stItemName.getInformation());
        Assert.assertNotNull(get1stItemName.getParameter());
        Assert.assertEquals(get1stItemName.getParameter(), selectedItemName);

        TestStep<Integer> get1stItemPrice = shoppingCartPage.getItemPrice(1);
        Assert.assertTrue(get1stItemPrice.isSuccess(),get1stItemPrice.getInformation());
        Assert.assertNotNull(get1stItemPrice.getParameter());
        Assert.assertEquals(get1stItemPrice.getParameter().intValue(), selectedItemPrice.intValue());

        TestStep incrementItemCountStep = shoppingCartPage.incrementItemCount(1);
        Assert.assertTrue(incrementItemCountStep.isSuccess(), incrementItemCountStep.getInformation());

        TestStep<Integer> get1stItemCountAgain = shoppingCartPage.getItemCount(1);
        Assert.assertTrue(get1stItemCountAgain.isSuccess(), get1stItemCountAgain.getInformation());
        Assert.assertNotNull(get1stItemCountAgain.getParameter());
        Assert.assertEquals(get1stItemCountAgain.getParameter().intValue(), 2, "Item count is incremented by 1 successfully.");

        TestStep deleteItemStep = shoppingCartPage.clickDeleteItemButton(1);
        Assert.assertTrue(deleteItemStep.isSuccess(), deleteItemStep.getInformation());

        TestStep<Boolean> checkCartEmpty =  shoppingCartPage.isCartEmpty();
        Assert.assertTrue(checkCartEmpty.isSuccess(), checkCartEmpty.getInformation());
        Assert.assertTrue(checkCartEmpty.getParameter());

    }
}
