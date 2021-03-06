package interfaces.github;

import concrete.TestStep;
import pages.github.HomePage;

/**
 * @author sercansensulun on 6.03.2020.
 */
public interface ISignInPage {
    TestStep enterUsername(String username);
    TestStep enterPassword(String password);
    HomePage clickSignInButton();
}
