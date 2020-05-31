package interfaces.n11;

import concrete.TestStep;
import pages.n11.LoginPage;
import pages.n11.MainPage;
import pages.n11.SearchPage;

/**
 * @author sercansensulun on 30.05.2020.
 */
public interface IMainPage {

    TestStep<Boolean> isMainPageOpened();
    TestStep<LoginPage> clickLoginButton();
    TestStep<String> getLoggedUsername();
    TestStep enterSearchKeyword(String keyword);
    TestStep<SearchPage> clickSearchButton();
    TestStep<MainPage> clickLogoutButton();
    TestStep clickKVKDialogOKButton();

}
