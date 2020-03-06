package interfaces.github;

import concrete.TestStep;
import pages.github.SignInPage;

/**
 * @author sercansensulun on 6.03.2020.
 */
public interface IHomePage {
    TestStep clickMenu();
    SignInPage clickSignOut();
}
