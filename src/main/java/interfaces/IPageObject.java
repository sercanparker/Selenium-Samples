package interfaces;

import concrete.TestStep;

/**
 * @author sercansensulun on 4.03.2020.
 */
public interface IPageObject {

    TestStep clickWithXpath(String xpath);
    String getPageTitle();
    void closePage();
}
