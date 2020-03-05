package bbc;

import concrete.TestStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.bbc.HomePage;
import pages.bbc.SearchPage;

/**
 * @author sercansensulun on 5.03.2020.
 */
public class Test002 extends BbcAbstractTest {

    @Test
    public void test002(){
        String searchKey = "software";
        HomePage homePage = getHomePage();
        TestStep enterSearchKeyStep = homePage.enterSearchInputArea(searchKey);
        Assert.assertTrue(enterSearchKeyStep.isSuccess());
        SearchPage searchPage = homePage.clickSearchButton();
        Assert.assertNotNull(searchPage);

        String searchResultContent = searchPage.getSearchResultContent();
        Assert.assertNotNull(searchResultContent);
        Assert.assertTrue(searchResultContent.contains(searchKey));


    }
}
