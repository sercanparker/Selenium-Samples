package hepsiburada;

import concrete.TestStep;
import concrete.WebDriverFactory;
import constants.EBrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.hepsiburada.MainPage;
import pages.hepsiburada.SearchResultPage;
import pages.hepsiburada.ShoppingCartPage;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class HepsiburadaAbstractTest {

    private MainPage mainPage;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        WebDriver driver =  WebDriverFactory.createWebDriver(EBrowserType.CHROME, "https://www.hepsiburada.com/");
        mainPage = new MainPage(driver);

    }


    @AfterSuite
    public void afterSuite(){
        mainPage.closePage();

    }

    public MainPage getMainPage() {
        return mainPage;
    }


    /**
     * Add two items (if exist) from different vendors (if exist) to cart.
     */
    public void addTwoItemsFromDifferentVendorsToCart(){
        boolean isMoreThanOneVendor = false;

        String firstItemNameOnSearchResult;
        String secondItemNameOnSearchResult = null;

        String firstItemNameOnCart;
        String secondItemNameOnCart;

        String firstVendorNameOnSearchResult;
        String secondVendorNameOnSearchResult = null;

        String firstVendorNameOnCart;
        String secondVendorNameOnCart;


        MainPage mainPage = getMainPage();
        TestStep enterSearchKeywordStep = mainPage.enterSearchKeyword("basketbol topu");
        Assert.assertTrue(enterSearchKeywordStep.isSuccess());

        SearchResultPage searchResultPage = mainPage.clickSearchButton();
        Assert.assertNotNull(searchResultPage);

        TestStep<Integer> vendorCountStep = searchResultPage.getVendorCount();
        Assert.assertTrue(vendorCountStep.isSuccess());
        Integer vendorCount = vendorCountStep.getParameter();
        Assert.assertTrue(vendorCount > 0, "There should be at least one vendor.");

        TestStep<String> filterFirstVendorStep = searchResultPage.clickVendor(1);
        Assert.assertTrue(filterFirstVendorStep.isSuccess(), "First vendor is filtered.");
        firstVendorNameOnSearchResult= filterFirstVendorStep.getParameter();

        TestStep<String> firstItemNameStep = searchResultPage.getFirstItemName();
        Assert.assertTrue(firstItemNameStep.isSuccess());
        firstItemNameOnSearchResult = firstItemNameStep.getParameter();

        TestStep addFirstItemToCartStep = searchResultPage.addFirstItemToCart();
        Assert.assertTrue(addFirstItemToCartStep.isSuccess(), "First item is added to cart.");

        TestStep removeFirstVendorFilter = searchResultPage.removeVendorFilter();
        Assert.assertTrue(removeFirstVendorFilter.isSuccess());

        if (vendorCount > 1) {
            isMoreThanOneVendor = true;
            TestStep<String> filterSecondVendor = searchResultPage.clickVendor(2);
            Assert.assertTrue(filterSecondVendor.isSuccess(), "Second vendor is filtered.");
            secondVendorNameOnSearchResult = filterSecondVendor.getParameter();

            TestStep<String> firstItemNameStepForSecondVendor = searchResultPage.getFirstItemName();
            Assert.assertTrue(firstItemNameStepForSecondVendor.isSuccess());
            secondItemNameOnSearchResult = firstItemNameStepForSecondVendor.getParameter();

            TestStep addFirstItemToCartStepForSecondVendor = searchResultPage.addFirstItemToCart();
            Assert.assertTrue(addFirstItemToCartStepForSecondVendor.isSuccess(), "First item is added to cart for second vendor.");

            TestStep removeSecondVendorFilter = searchResultPage.removeVendorFilter();
            Assert.assertTrue(removeSecondVendorFilter.isSuccess());
        }

        ShoppingCartPage shoppingCartPage = mainPage.clickMyCartButton();
        Assert.assertNotNull(shoppingCartPage);

        TestStep<String> firstItemTitleStep = shoppingCartPage.getItemTitle(1);
        Assert.assertTrue(firstItemTitleStep.isSuccess());
        firstItemNameOnCart = firstItemTitleStep.getParameter();
        Assert.assertTrue(firstItemNameOnCart.contains(firstItemNameOnSearchResult));

        TestStep<String> firstVendorNameStep =  shoppingCartPage.getVendorName(1);
        Assert.assertTrue(firstVendorNameStep.isSuccess());
        firstVendorNameOnCart = firstVendorNameStep.getParameter();
        Assert.assertTrue(firstVendorNameOnSearchResult == firstVendorNameOnCart);

        if (isMoreThanOneVendor){
            TestStep<Integer> getItemsStep = shoppingCartPage.getNumberOfItems();
            int numberOfItemsOnCart = getItemsStep.getParameter();
            Assert.assertEquals(numberOfItemsOnCart, 2);

            TestStep<String> secondItemTitleStep = shoppingCartPage.getItemTitle(2);
            Assert.assertTrue(secondItemTitleStep.isSuccess());
            secondItemNameOnCart = secondItemTitleStep.getParameter();
            Assert.assertTrue(secondItemNameOnCart.contains(secondItemNameOnSearchResult));

            TestStep<String> secondVendorNameStep = shoppingCartPage.getVendorName(2);
            Assert.assertTrue(secondVendorNameStep.isSuccess());
            secondVendorNameOnCart = secondVendorNameStep.getParameter();
            Assert.assertTrue(secondVendorNameOnSearchResult == secondVendorNameOnCart);

            TestStep itemRemoveStep = shoppingCartPage.removeItem(1);
            Assert.assertTrue(itemRemoveStep.isSuccess());

        }

        TestStep itemRemoveStep = shoppingCartPage.removeItem(1);
        Assert.assertTrue(itemRemoveStep.isSuccess());
    }


}
