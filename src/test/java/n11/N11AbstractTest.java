package n11;

import concrete.WebDriverFactory;
import constants.EBrowserType;
import constants.EOSType;
import constants.TestSettingConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.n11.MainPage;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class N11AbstractTest {

    protected MainPage mainPage;

    @BeforeClass
    public void beforeClass() throws Exception {
        WebDriver driver =  WebDriverFactory.createWebDriver(TestSettingConstants.BROWSER_TYPE,
                "https://www.n11.com/",
                TestSettingConstants.OS_TYPE);
        mainPage = new MainPage(driver);
    }


    @AfterClass
    public void afterSuite(){

        mainPage.closePage();
    }
}
