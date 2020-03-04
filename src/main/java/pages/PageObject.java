package pages;

import concrete.TestStep;
import constants.TestSettingConstants;
import interfaces.IPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sercansensulun on 4.03.2020.
 * Base class for each Page class.
 * Selenium implementations are here.
 */
public class PageObject implements IPageObject {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public PageObject(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new  WebDriverWait(webDriver, TestSettingConstants.WAIT_IN_SECONDS);
    }

    /**
     * Clicks to web element that is found by given xpath.
     * @param xpath
     * @return
     * @see TestStep
     */
    public TestStep clickWithXpath(String xpath) {
        WebElement webElement = waitUntilClickableWithXpath(xpath);
        if (webElement == null) {
            return new TestStep(false, String.format("Web element with %s xpath is not clickable.", xpath));
        }
        webElement.click();
        return new TestStep(true, String.format("Web element with %s xpath is clicked.", xpath));
    }

    /**
     * Returns page title.
     * @return
     */
    public String getPageTitle() {
        return getWebDriver().getTitle();
    }

    /**
     * Closes current active automated web page.
     */
    @Override
    public void closePage() {
        getWebDriver().close();
    }

    /**
     * Waits until web element that is found by given xpath is clickable.
     * If web element is not clickable, returns null.
     * @param xpath
     * @return clickable web element otherwise null.
     */
    private WebElement waitUntilClickableWithXpath(String xpath){
        try {
            return this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch (Exception e){
            //TODO:log here.
            return null;
        }
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
}
