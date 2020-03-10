package interfaces.github;

import concrete.TestStep;
import pages.github.HomePage;

/**
 * @author sercansensulun on 10.03.2020.
 */
public interface IConfirmationPage {

    TestStep enterPassword(String password);
    HomePage clickConfirmButton();

}
