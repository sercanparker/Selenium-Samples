import org.testng.Assert;
import org.testng.annotations.Test;
import pages.bbc.HomePage;
import pages.bbc.SportPage;

/**
 * @author sercansensulun on 4.03.2020.
 */
public class Test001 extends AbstractTest {

    @Test
    public void test001(){
        HomePage homePage = getHomePage();

        Assert.assertEquals(homePage.getPageTitle(), "BBC - Homepage");
        SportPage sportPage = homePage.clickSportPage();
        Assert.assertNotNull(sportPage);
        Assert.assertEquals(sportPage.getPageTitle(), "Home - BBC Sport");

    }
}
