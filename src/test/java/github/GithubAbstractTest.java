package github;

import concrete.TestStep;
import constants.TestSettingConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.github.HomePage;
import pages.github.SignInPage;

/**
 * @author sercansensulun on 6.03.2020.
 */
public class GithubAbstractTest {

    private SignInPage signInPage;
    private HomePage homePage;

    public void setSignInPage(SignInPage signInPage) {
        this.signInPage = signInPage;
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        setSignInPage(new SignInPage(driver));

        SignInPage signInPage = getSignInPage();
        Assert.assertEquals(signInPage.getPageTitle(), "Sign in to GitHub · GitHub");

        TestStep enterUsernameStep = signInPage.enterUsername(TestSettingConstants.GITHUB_USERNAME);
        Assert.assertTrue(enterUsernameStep.isSuccess());

        TestStep enterPasswordStep = signInPage.enterPassword(TestSettingConstants.GITHUB_PASSWORD);
        Assert.assertTrue(enterPasswordStep.isSuccess());

        HomePage homePage = signInPage.clickSignInButton();
        Assert.assertNotNull(homePage);
        setHomePage(homePage);
    }

    @AfterSuite
    public void afterSuite(){
        HomePage homePage = getHomePage();
        TestStep clickMenuStep = homePage.clickMenu();
        Assert.assertTrue(clickMenuStep.isSuccess());

        SignInPage signInPage = homePage.clickSignOut();
        Assert.assertNotNull(signInPage);

        getSignInPage().closePage();
    }
}
