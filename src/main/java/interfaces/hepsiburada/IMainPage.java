package interfaces.hepsiburada;

import concrete.TestStep;
import pages.hepsiburada.LoginPage;
import pages.hepsiburada.SearchResultPage;
import pages.hepsiburada.ShoppingCartPage;

/**
 * @author sercansensulun on 29.03.2020.
 */
public interface IMainPage {

    TestStep enterSearchKeyword(String keyword);
    SearchResultPage clickSearchButton();
    ShoppingCartPage clickMyCartButton();
    LoginPage clickLoginPage();
    void checkLoginSuccess();
    TestStep logout();


}
