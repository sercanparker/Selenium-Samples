package interfaces.n11;

import concrete.TestStep;
import pages.n11.MainPage;

/**
 * @author sercansensulun on 30.05.2020.
 */
public interface ILoginPage {

    TestStep enterEmail(String username);
    TestStep enterPassword(String password);
    TestStep<MainPage> clickLoginButton();



}
