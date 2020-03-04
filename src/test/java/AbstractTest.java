import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.bbc.HomePage;
import pages.bbc.SportPage;

/**
 * @author sercansensulun on 4.03.2020.
 */
public abstract class AbstractTest {

    private HomePage homePage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
        setHomePage(new HomePage(driver));
    }

    @AfterClass
    public void afterClass(){
        getHomePage().closePage();
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
