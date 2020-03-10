package interfaces.github;

import concrete.TestStep;
import pages.github.CreatedNewRepositoryPage;

/**
 * @author sercansensulun on 9.03.2020.
 */
public interface INewRepositoryPage {

    TestStep enterNewRepositoryName(String name);
    CreatedNewRepositoryPage clickCreateNewRepositoryButton();

}
