package interfaces;

import concrete.TestStep;
import org.openqa.selenium.WebElement;

/**
 * @author sercansensulun on 4.03.2020.
 */
public interface IPageObject {

    TestStep clickWithXpath(String xpath);
    String getPageTitle();
    void closePage();
    TestStep enterTextWithXpath(String text, String xpath);
    WebElement waitUntilVisibleWithXpath(String xpath);
    TestStep<String> getTextWithXpath(String xpath);
}
