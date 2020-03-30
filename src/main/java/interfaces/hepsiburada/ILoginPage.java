package interfaces.hepsiburada;

import concrete.TestStep;
import pages.hepsiburada.MainPage;

/**
 * @author sercansensulun on 30.03.2020.
 */
public interface ILoginPage {

    TestStep clickLoginRadioButton();
    TestStep enterEmail(String email);
    TestStep enterPassword(String password);
    MainPage clickLoginButton();
}
