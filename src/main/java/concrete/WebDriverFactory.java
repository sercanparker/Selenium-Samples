package concrete;

import constants.EBrowserType;
import constants.EOSType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;

/**
 * @author sercansensulun on 29.03.2020.
 */
public class WebDriverFactory {

    public static WebDriver createWebDriver(EBrowserType browserType, String url, EOSType osType) throws Exception {

        String driverFolderPath = "";

        switch (osType){
            case LINUX:
                driverFolderPath = "driver/linux/";
                break;
            case WINDOWS:
                driverFolderPath = "driver/windows/";
                break;
            default:
                driverFolderPath = "driver/macos/";
        }

        switch (browserType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver",driverFolderPath + "chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                WebDriver driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(url);
                return driver;

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",driverFolderPath + "geckodriver");
                WebDriver driverFireFox = new FirefoxDriver();
                driverFireFox.manage().window().maximize();
                driverFireFox.get(url);
                return driverFireFox;
        }
        throw new Exception("Given browser does not supported for now.");
    }
}
