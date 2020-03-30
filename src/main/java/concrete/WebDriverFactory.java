package concrete;

import constants.EBrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class WebDriverFactory {

    public static WebDriver createWebDriver(EBrowserType browserType, String url) throws Exception {

        switch (browserType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver","driver/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(url);
                return driver;

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver","driver/geckodriver");
                WebDriver driverFireFox = new FirefoxDriver();
                driverFireFox.manage().window().maximize();
                driverFireFox.get(url);
                return driverFireFox;
        }
        throw new Exception("Given browser does not supported for now.");
    }
}
