package pages;

import concrete.TestStep;
import constants.TestSettingConstants;
import interfaces.IPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
            System.out.println(String.format("Web element with %s xpath is not clickable.", xpath));
            return new TestStep(false, String.format("Web element with %s xpath is not clickable.", xpath));
        }
        webElement.click();
        waitForLoad(getWebDriver());
        System.out.println(String.format("Web element with %s xpath is clicked.", xpath));
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
     * Enter text to web element that is found by given xpath.
     * @param text
     * @param xpath
     * @return
     */
    @Override
    public TestStep enterTextWithXpath(String text, String xpath) {
        WebElement webElement = waitUntilClickableWithXpath(xpath);
        if (webElement == null){
            return new TestStep(false, String.format("Web element with %s xpath is not clickable.", xpath));
        }
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
        return new TestStep(true, String.format("%s text is entered on web element with %s xpath", text, xpath));
    }

    /**
     * Waits until web element that is found by given xpath is visible.
     * If web element is not clickable, returns null.*
     * @param xpath
     * @return
     */
    @Override
    public WebElement waitUntilVisibleWithXpath(String xpath) {
        try {
            waitForLoad(getWebDriver());
            return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }catch (Exception e){
            //TODO:log here.
            return null;
        }
    }

    /**
     * Returns text on web element that is found by given xpath.
     * @param xpath
     * @return
     */
    @Override
    public TestStep<String> getTextWithXpath(String xpath) {
        WebElement webElement = waitUntilVisibleWithXpath(xpath);
        if (webElement == null){
            return new TestStep<>(false, null,null);
        }
        String text = webElement.getText();
        return new TestStep<>(true,
                String.format("%s text was found on web element with %s xpath", text, xpath),text);

    }



    @Override
    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns number of elements by xpath.
     * @return
     */
    @Override
    public TestStep<Integer> getWebElementCount(String xpath) {
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath(xpath));
        if (!(webElementList.size() > 0)){
            return new TestStep<Integer>(false, null,0);
        }
        return new TestStep<Integer>(true,"", webElementList.size());
    }

    @Override
    public TestStep<String> getInputValue(String xpath) {
        WebElement webElement = waitUntilVisibleWithXpath(xpath);
        if (webElement == null){
            return new TestStep<>(false, null,null);
        }
        String text = webElement.getAttribute("value");
        return new TestStep<>(true,
                String.format("%s text was found on web element with %s xpath", text, xpath),text);
    }

    /**
     * Waits until web element that is found by given xpath is clickable.
     * If web element is not clickable, returns null.
     * @param xpath
     * @return clickable web element otherwise null.
     */
    private WebElement waitUntilClickableWithXpath(String xpath){
        try {
            waitForLoad(getWebDriver());
            return new WebDriverWait(getWebDriver(), TestSettingConstants.WAIT_IN_SECONDS_FOR_WEB_ELEMENT).
                    until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch (Exception e){
            //TODO:log here.
            return null;
        }
    }

    private void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, TestSettingConstants.WAIT_IN_SECONDS);
        wait.until(pageLoadCondition);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
